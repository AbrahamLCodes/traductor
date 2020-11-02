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

public class VerbosActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ImageView regresar;
    private ListView verbosList;
    private String[] verbos = {
            "Comer",
            "Dormir",
            "Llorar",
            "Mirar",
            "Olvidar",
            "Querer A",
            "Querer B",
            "Reír",
            "Saber"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verbos);

        regresar = findViewById(R.id.regresar);
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        verbosList = findViewById(R.id.verbosList);
        verbosList.setAdapter(new StringListAdapter(
                this,
                R.layout.string_list_adapter,
                verbos
        ));
        verbosList.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String original = verbos[i].toLowerCase().replaceAll("\\s+", "");
        String cadenaNormalize = Normalizer.normalize(original, Normalizer.Form.NFD);
        String cadenaSinAcentos = cadenaNormalize.replaceAll("[^\\p{ASCII}]", "");

        DetailFragment detailFragment = new DetailFragment(
                verbos[i],
                cadenaSinAcentos,
                getApplicationContext()
        );
        detailFragment.show(getSupportFragmentManager(), "Info");
    }
}