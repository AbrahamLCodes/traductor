package app.traductor.traductor.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import app.traductor.traductor.R;

public class AbecedarioActivity extends AppCompatActivity implements TextWatcher {

    //Declaración de variables
    private EditText abcTxt;
    private ImageView abcImg, regresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abecedario);

        //Relacionando variables de la clase con las Views
        abcTxt = findViewById(R.id.abcTxt);
        abcImg = findViewById(R.id.abcImg);
        regresar = findViewById(R.id.regresar);

        //Asignar KeyListener al EditText
        abcTxt.addTextChangedListener(this);

        //Asignar ClickListener al Botn de Regresar
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    //Metodo requerido para la interfaz TextWatcher
    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
    }

    //Cuando se presiona la tecla. Aqui haremos todo el salseo.
    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        validarLetra(charSequence);
    }

    //Metodo requerido para la interfaz TextWatcher
    @Override
    public void afterTextChanged(Editable editable) {
    }

    private void validarLetra(CharSequence charSequence) {
        if (charSequence.length() > 0) {
            //Checa que el metodo getLetra devuelva 0, si devuelve 0 es porque no encontro el recurso
            if (getLetra(charSequence.toString()) == 0) {
                corregirLetra();
            } else {
                asignarLetra(charSequence);
            }
        }
    }

    //Método para configurar la nueva imágen respecto a la letra introducida.
    private void asignarLetra(CharSequence charSequence) {
        //El try-catch es para manejar errores de usuario. Si introduce algo que no sea letra devuelve 0
        try {
            abcImg.setImageResource(getLetra(charSequence.toString()));
        } catch (Resources.NotFoundException e) {
            corregirLetra();
        }
        ocultarTeclado();
        abcTxt.setText("", TextView.BufferType.EDITABLE);
    }

    //Método para verificar y corregir al usuario cuando este introdujo valor no válido.
    private void corregirLetra() {
        Toast.makeText(AbecedarioActivity.this, "Introduce una letra", Toast.LENGTH_SHORT).show();
        ocultarTeclado();
        abcTxt.setText("", TextView.BufferType.EDITABLE);
    }

    private int getLetra(String l) {
        String letra = l.toLowerCase();
        if (letra.equals("ñ")) {
            return R.drawable.nn;
        } else {
            return getResources().getIdentifier(letra, "drawable", getPackageName());
        }
    }

    private void ocultarTeclado() {
        InputMethodManager imm = (InputMethodManager) getSystemService(this.INPUT_METHOD_SERVICE);
        //Obtener la View actual (EditText)
        View view = this.getCurrentFocus();
        //Si no hay una View con el focus, creamos una nueva, solo para obtener el evento.
        if (view == null) {
            view = new View(this);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}