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
import com.example.proyecto1desmovil.ThirdActivity;
import com.example.proyecto1desmovil.utils.Desarrollador;
import com.example.proyecto1desmovil.utils.Juego;

import java.util.ArrayList;

public class AdaptadorJuego extends RecyclerView.Adapter<AdaptadorJuego.MyHolder>{

    private ArrayList<Juego> listaJuegos;
    private Context context;
    private OnRecyclerListener listener;

    public AdaptadorJuego(ArrayList<Juego> listaJuegos, Context context) {
        this.listaJuegos = listaJuegos;
        this.context = context;
        this.listener = (OnRecyclerListener) context;

    }

    // retorna un objeto holder con una vista puesta
    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate( R.layout.item_recycler_juegos,parent,
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

        Juego juego = listaJuegos.get(position);
        holder.textView.setText(juego.getNombre());
        holder.imageView.setImageResource(juego.getImagen());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // realizo comunicacion
                listener.onJuegoSelected(juego);
                Log.v("imagen","Juego seleccionado: " + juego.getNombre());
                /*
                Intent intent = new Intent(context, ThirdActivity.class);

                intent.putExtra("juego", juego);
                //intent.putExtra("imagen", desarrollador.getImagen());

                context.startActivity(intent);*/
            }
        });
    }

    // numero de filas que tengo que pintar
    @Override
    public int getItemCount() {
        return listaJuegos.size();
    }

    public interface OnRecyclerListener{

        void onJuegoSelected(Juego juego);

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
