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

public class DiasActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ImageView regresar;
    private ListView diasList;
    private String [] dias = {
            "Domingo",
            "Lunes",
            "Martes",
            "Miércoles",
            "Jueves",
            "Viernes",
            "Sábado"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dias);

        regresar = findViewById(R.id.regresar);
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        diasList = findViewById(R.id.diasList);
        diasList.setAdapter(new StringListAdapter(
                this,
                R.layout.string_list_adapter,
                dias
        ));
        diasList.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String original = dias[i].toLowerCase();
        String cadenaNormalize = Normalizer.normalize(original, Normalizer.Form.NFD);
        String cadenaSinAcentos = cadenaNormalize.replaceAll("[^\\p{ASCII}]", "");

        DetailFragment detailFragment = new DetailFragment(
          dias[i],
          cadenaSinAcentos,
          getApplicationContext()
        );
        detailFragment.show(getSupportFragmentManager(),"Info");
    }
}