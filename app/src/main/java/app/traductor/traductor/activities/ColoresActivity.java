package app.traductor.traductor.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.text.Normalizer;

import app.traductor.traductor.R;
import app.traductor.traductor.fragments.DetailFragment;
import app.traductor.traductor.modelo.StringListAdapter;

public class ColoresActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ImageView regresar;
    private ListView coloresList;
    private String[] colores = {
            "Amarillo",
            "Anaranjado",
            "Azul",
            "Blanco",
            "Brillante",
            "Café",
            "Claro",
            "Gris",
            "Morado",
            "Negro",
            "Oro",
            "Oscuro",
            "Plata",
            "Rojo",
            "Rosa",
            "Verde"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colores);

        regresar = findViewById(R.id.regresar);
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        coloresList = findViewById(R.id.coloresList);
        coloresList.setAdapter(new StringListAdapter(
                this,
                R.layout.string_list_adapter,
                colores
        ));
        coloresList.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String original = colores[i].toLowerCase().replaceAll("\\s+", "");
        String cadenaNormalize = Normalizer.normalize(original, Normalizer.Form.NFD);
        String cadenaSinAcentos = cadenaNormalize.replaceAll("[^\\p{ASCII}]", "");

        DetailFragment detailFragment = new DetailFragment(
                colores[i],
                cadenaSinAcentos,
                getApplicationContext()
        );
        detailFragment.show(getSupportFragmentManager(),"Info");
    }
}