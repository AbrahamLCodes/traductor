package app.traductor.traductor.fragments;

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
import app.traductor.traductor.modelo.Opcion;
import app.traductor.traductor.modelo.OpcionAdapter;

public class SenasFragment extends Fragment implements AdapterView.OnItemClickListener {

    private ListView listaSe;
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
        return inflater.inflate(R.layout.fragment_senas, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        iniciarComponentes(view);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(getContext(), "" + opciones[i].getTexto(), Toast.LENGTH_SHORT).show();
    }

    private void iniciarComponentes(View view) {
        listaSe = view.findViewById(R.id.listaSe);
        listaSe.setOnItemClickListener(this);
        listaSe.setAdapter(new OpcionAdapter(
                getContext(),
                R.layout.opcion2_adapter,
                opciones
        ));
    }
}