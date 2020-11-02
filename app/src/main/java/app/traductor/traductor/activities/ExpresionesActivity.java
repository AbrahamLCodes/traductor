package app.traductor.traductor.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import app.traductor.traductor.R;
import app.traductor.traductor.fragments.DetailFragment;
import app.traductor.traductor.modelo.StringListAdapter;

public class ExpresionesActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ImageView regresar;
    private ListView expresionesList;
    private String[] expresiones = {
            "A veces",
            "Diferente",
            "Permiso",
            "Por favor",
            "Siempre"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expresiones);

        regresar = findViewById(R.id.regresar);
        expresionesList = findViewById(R.id.expresionesList);

        expresionesList.setAdapter(new StringListAdapter(
                this,
                R.layout.string_list_adapter,
                expresiones));
        expresionesList.setOnItemClickListener(this);
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        DetailFragment detailFragment = new DetailFragment(
                expresiones[i],
                expresiones[i].toLowerCase().replaceAll("\\s+",""),
                getApplicationContext());

        detailFragment.show(getSupportFragmentManager(), "Info");
    }
}