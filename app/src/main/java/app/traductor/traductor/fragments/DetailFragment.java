package app.traductor.traductor.fragments;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import app.traductor.traductor.R;

public class DetailFragment extends AppCompatDialogFragment implements View.OnClickListener {

    private String titulo, nombreRecurso;
    private TextView tituloTxt, regresar;
    private ImageView imagen;
    private Context context;

    public DetailFragment(String titulo, String nombreRecurso, Context context){
        this.titulo = titulo;
        this.nombreRecurso = nombreRecurso;
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initComponents(view);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.detailRegresar) {
            dismiss();
        }
    }

    private void initComponents(View v){
        tituloTxt = v.findViewById(R.id.detailTitle);
        imagen = v.findViewById(R.id.detailImage);
        regresar = v.findViewById(R.id.detailRegresar);

        tituloTxt.setText(titulo);
        imagen.setImageResource(getImage(nombreRecurso));
        regresar.setOnClickListener(this);
    }

    private int getImage(String s) {
        return getResources().getIdentifier(s, "drawable", context.getPackageName());
    }
}
