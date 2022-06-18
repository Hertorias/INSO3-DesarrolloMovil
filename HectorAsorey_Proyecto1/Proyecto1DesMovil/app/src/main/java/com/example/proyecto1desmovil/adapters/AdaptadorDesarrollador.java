package com.example.proyecto1desmovil.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.DeadSystemException;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyecto1desmovil.R;
import com.example.proyecto1desmovil.utils.Desarrollador;
import com.example.proyecto1desmovil.utils.Juego;

import java.util.ArrayList;

public class AdaptadorDesarrollador extends RecyclerView.Adapter<AdaptadorDesarrollador.MyHolder>{

    private ArrayList<Desarrollador> listaDesarrollador;
    private Context context;
    private OnRecyclerListener listener;

    public AdaptadorDesarrollador(ArrayList<Desarrollador> listaDesarrollador, Context context) {
        this.listaDesarrollador = listaDesarrollador;
        this.context = context;
        this.listener = (OnRecyclerListener) context;

    }

    // retorna un objeto holder con una vista puesta
    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate( R.layout.item_recycler_desarrollador,parent,
                false);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    // metodo que se encarga de pintar cada uno de los contenedores
    // asocio todas las acciones a los elementos
    // ejecutado tantas veces como elementos de la lista
    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        // aqui holder.textView pongo el nombre del juego del de la position correspondiente;
        // aqui holder.imageView pongo la imagen del juego;

        Desarrollador desarrollador = listaDesarrollador.get(position);
        holder.textView.setText(desarrollador.getNombre());
        holder.imageView.setImageResource(desarrollador.getImagen());
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // realizo comunicacion
                listener.onDesarrolladorSelected(desarrollador);
                Log.v("imagen","Juego seleccionado: "+desarrollador.getNombre());

                //Intent intent = new Intent(context, MainActivity2.class);

                //intent.putExtra("nombre", desarrollador.getNombre());
                //intent.putExtra("imagen", desarrollador.getImagen());

                //context.startActivity(intent);
            }
        });
    }

    // numero de filas que tengo que pintar
    @Override
    public int getItemCount() {
        return listaDesarrollador.size();
    }

    public interface OnRecyclerListener{

        void onDesarrolladorSelected(Desarrollador desarrollador);

    }

    // clase que se utilizar para el "cacheo" de cada una de las filas
    // marca el aspecto "generico" de una fila
    class MyHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imagen_fila);
            textView = itemView.findViewById(R.id.nombre_fila);

        }
    }

}
