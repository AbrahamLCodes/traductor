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
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import app.traductor.traductor.R;
import app.traductor.traductor.modelo.Opcion;
import app.traductor.traductor.modelo.OpcionAdapter;
import app.traductor.traductor.modelo.TraductorList;
import app.traductor.traductor.modelo.TraductorListAdapter;

public class SenasFragment extends Fragment implements View.OnClickListener {

    private ListView lista;
    private EditText campo;
    private TextView btn;
    private TraductorList[] listaImagenes = {
            new TraductorList(R.drawable.sabado, "Sabado"),
            new TraductorList(R.drawable.yo, "Yo"),
            new TraductorList(R.drawable.dormir, "Dormir")
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
    public void onClick(View view) {
        if (view.getId() == R.id.btnTraducir){
            Toast.makeText(getContext(), "Accion en construccion", Toast.LENGTH_SHORT).show();
        }
    }

    private void iniciarComponentes(View view) {
        lista = view.findViewById(R.id.listaTraductor);
        campo = view.findViewById(R.id.traducirEdtTxt);
        btn = view.findViewById(R.id.btnTraducir);

        btn.setOnClickListener(this);
        lista.setAdapter(new TraductorListAdapter(
                getContext(),
                R.layout.traductor_adapter,
                listaImagenes
        ));
    }

}