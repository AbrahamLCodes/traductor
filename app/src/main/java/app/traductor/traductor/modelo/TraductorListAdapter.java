package app.traductor.traductor.modelo;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import app.traductor.traductor.R;

public class TraductorListAdapter extends ArrayAdapter<TraductorList> {

    private TraductorList[] objects;
    private Context context;
    private int resource;

    public TraductorListAdapter(@NonNull Context context, int resource, @NonNull TraductorList[] objects) {
        super(context, resource, objects);

        this.objects = objects;
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {//Primera vez que se ejecuta la aplicación
            convertView = ((Activity) context).getLayoutInflater().inflate(resource, parent, false);
        }

        //Declarando componentes
        ImageView imagen;
        TextView titulo;

        /** Obteniendo componentes del String_adapter*/
        imagen = convertView.findViewById(R.id.imagenAdapter);
        titulo = convertView.findViewById(R.id.imgTitle);

        /** Configurando componentes del opcion_adapter*/
        imagen.setImageResource(objects[position].getImagen());
        titulo.setText(objects[position].getTitulo());

        return convertView;
    }
}
