package app.traductor.traductor.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import app.traductor.traductor.R;
import app.traductor.traductor.activities.AbecedarioActivity;
import app.traductor.traductor.activities.DiasActivity;
import app.traductor.traductor.activities.ExpresionesActivity;
import app.traductor.traductor.activities.MesesActivity;
import app.traductor.traductor.activities.VerbosActivity;
import app.traductor.traductor.modelo.Opcion;
import app.traductor.traductor.modelo.OpcionAdapter;

public class EspanolFragment extends Fragment implements AdapterView.OnItemClickListener {

    private ListView listaEs;
    private Opcion[] opciones = {
            new Opcion(R.drawable.abc, "Abecedario"),
            new Opcion(R.drawable.expresiones, "Expresiones básicas"),
            new Opcion(R.drawable.dia, "Días de la semana"),
            new Opcion(R.drawable.mes, "Meses del año"),
            new Opcion(R.drawable.verbo, "Verbos"),
            new Opcion(R.drawable.pronombre, "Pronombres"),
            new Opcion(R.drawable.color, "Colores"),
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_espanol, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        iniciarComponentes(view);
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        switch (i){
            case 0:
                startActivity(new Intent(getContext(), AbecedarioActivity.class));
                break;
            case 1:
                startActivity(new Intent(getContext(), ExpresionesActivity.class));
                break;
            case 2:
                startActivity(new Intent(getContext(), DiasActivity.class));
                break;
            case 3:
                startActivity(new Intent(getContext(), MesesActivity.class));
                break;
            case 4:
                startActivity(new Intent(getContext(), VerbosActivity.class));
                break;
        }
    }

    private void iniciarComponentes(View view) {
        listaEs = view.findViewById(R.id.listaEs);
        listaEs.setOnItemClickListener(this);
        listaEs.setAdapter(new OpcionAdapter(
                getContext(),
                R.layout.opcion_adapter,
                opciones
        ));
    }
}