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

public class PronombresActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ImageView regresar;
    private ListView pronombresList;
    private String[] pronombres = {
            "Él",
            "Ellos",
            "Nosotros",
            "Tu",
            "Usted",
            "Ustedes",
            "Yo"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pronombres);

        regresar = findViewById(R.id.regresar);
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        pronombresList = findViewById(R.id.pronombresList);
        pronombresList.setAdapter(new StringListAdapter(
                this,
                R.layout.string_list_adapter,
                pronombres
        ));
        pronombresList.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String original = pronombres[i].toLowerCase().replaceAll("\\s+", "");
        String cadenaNormalize = Normalizer.normalize(original, Normalizer.Form.NFD);
        String cadenaSinAcentos = cadenaNormalize.replaceAll("[^\\p{ASCII}]", "");

        DetailFragment detailFragment = new DetailFragment(
                pronombres[i],
                cadenaSinAcentos,
                getApplicationContext()
        );
        detailFragment.show(getSupportFragmentManager(), "Info");
    }
}