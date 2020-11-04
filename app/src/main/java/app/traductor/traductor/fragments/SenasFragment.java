package app.traductor.traductor.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.text.Normalizer;
import java.util.ArrayList;


import app.traductor.traductor.R;
import app.traductor.traductor.modelo.Conjugaciones;
import app.traductor.traductor.modelo.TraductorList;
import app.traductor.traductor.modelo.TraductorListAdapter;

public class SenasFragment extends Fragment implements View.OnClickListener {

    private ListView lista;
    private EditText campo;
    private TextView btn;
    private ArrayList<TraductorList> listaImagenes;

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

        listaImagenes = new ArrayList<>();
        iniciarComponentes(view);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnTraducir) {
            //Descomponemos toda la cadena en palabras individuales
            separar(campo.getText().toString());
            campo.setText("");
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
                new TraductorList[]{

                }
        ));
    }

    private void separar(String s) {
        //Areglo en donde se guardarán las palabras
        String[] arr = s.split(" ");

        //Ciclo forEach para iterar cada palabra dentro del arreglo
        for (String ss : arr) {
            //Checar si el String tiene 3 o más caracteres (Las palabras a traducir los tienen)
            if (ss.length() > 2) {
                /* Construimos un String con los 3 primeros caracteres de cada palabra puesto que
                * de esa manera está construido el algoritmo de devolución de información*/
                String buscar = (""+ss.charAt(0)) + (""+ ss.charAt(1)) + (""+ss.charAt(2));
                //Verificamos que el string esté dentro de las palabras a traducir
                if (Conjugaciones.convertirVerbo(limpiarString(buscar)) != 0) {
                    //Añadimos un nuevo objeto TraductorList al ArrayList
                    listaImagenes.add(new TraductorList(
                            Conjugaciones.convertirVerbo(
                                    limpiarString(buscar)), ss));
                }
            }
        }

        //Actualizamos la interfaz gráfica
        lista.setAdapter(new TraductorListAdapter(
                getContext(),
                R.layout.traductor_adapter,
                convertirArrayList(listaImagenes)
        ));
        //Reiniciamos el ArrayList para que no se acumulen resultados
        listaImagenes = new ArrayList<>();
    }

    //Método para poner un String en minúsculas y sin acentos
    private String limpiarString(String s) {
        String original = s.toLowerCase().replaceAll("\\s+", "");
        String cadenaNormalize = Normalizer.normalize(original, Normalizer.Form.NFD);
        String cadenaSinAcentos = cadenaNormalize.replaceAll("[^\\p{ASCII}]", "");
        return cadenaSinAcentos;
    }

    //Usamos este método para convertir el ArrayList<> en un Array[] puesto que el ListAdapter así lo pide
    private TraductorList[] convertirArrayList(ArrayList<TraductorList> array) {
        TraductorList[] arreglo = new TraductorList[array.size()];
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = array.get(i);
        }
        return arreglo;
    }
}