package com.example.trabajofinaljuniov2.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trabajofinaljuniov2.R;
import com.example.trabajofinaljuniov2.utils.Juego;

import java.util.ArrayList;

public class AdaptadorCarrito extends RecyclerView.Adapter<AdaptadorCarrito.MyHolder>{

    private ArrayList<Juego> listaJuegos;
    private Context context;
    private AdaptadorJuego.OnRecyclerListener listener;

    public AdaptadorCarrito(ArrayList<Juego> listaJuegos, Context context) {
        this.listaJuegos = listaJuegos;
        this.context = context;
        this.listener = (AdaptadorJuego.OnRecyclerListener) context;

    }

    // retorna un objeto holder con una vista puesta
    @NonNull
    @Override
    public AdaptadorCarrito.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recycler_carrito,parent,
                false);
        AdaptadorCarrito.MyHolder myHolder = new AdaptadorCarrito.MyHolder(view);
        return myHolder;
    }

    // metodo que se encarga de pintar cada uno de los contenedores
    // asocio todas las acciones a los elementos
    // ejecutado tantas veces como elementos de la lista
    @Override
    public void onBindViewHolder(@NonNull AdaptadorCarrito.MyHolder holder, int position) {
        Juego juego = listaJuegos.get(position);
        holder.textView.setText(juego.getNombre());
        holder.textView2.setText(juego.getPlataforma());
        holder.textView3.setText(String.valueOf(juego.getPrecio()) + "€");
        holder.imageView.setImageResource(juego.getImagen());
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
        TextView textView2;
        TextView textView3;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imagen_fila);
            textView = itemView.findViewById(R.id.nombre_fila);
            textView2 = itemView.findViewById(R.id.nombre_plataforma);
            textView3 = itemView.findViewById(R.id.nombre_precio);
        }
    }

}
