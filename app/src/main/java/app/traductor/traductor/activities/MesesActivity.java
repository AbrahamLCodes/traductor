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

public class MesesActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ImageView regresar;
    private ListView mesesList;
    private String[] meses = {
            "Enero",
            "Febrero",
            "Marzo",
            "Abril",
            "Mayo",
            "Junio",
            "Julio",
            "Agosto",
            "Septiembre",
            "Octubre",
            "Noviembre",
            "Diciembre"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meses);

        regresar = findViewById(R.id.regresar);
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        mesesList = findViewById(R.id.mesesList);
        mesesList.setAdapter(new StringListAdapter(
                this,
                R.layout.string_list_adapter,
                meses
        ));
        mesesList.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        DetailFragment detailFragment = new DetailFragment(
                meses[i],
                meses[i].toLowerCase(),
                getApplicationContext()
        );
        detailFragment.show(getSupportFragmentManager(), "Info");
    }
}