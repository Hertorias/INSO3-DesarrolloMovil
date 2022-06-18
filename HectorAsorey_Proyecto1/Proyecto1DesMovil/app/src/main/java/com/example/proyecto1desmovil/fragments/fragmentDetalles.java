package com.example.proyecto1desmovil.fragments;

import android.app.ActionBar;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyecto1desmovil.R;
import com.example.proyecto1desmovil.adapters.AdaptadorJuego;
import com.example.proyecto1desmovil.datos.DatosLista;
import com.example.proyecto1desmovil.utils.Juego;

import java.util.ArrayList;

public class fragmentDetalles extends Fragment {

    private String desarrollador;

    private View view;

    private ImageView imageView;
    private TextView nombre;
    private TextView developer;
    private TextView publisher;
    private TextView genero;
    private TextView fecha;
    private TextView plataformas;

    private ArrayList<Juego> listaDatos;
    private ArrayList<Juego> listaDatosAMostrar;

    private DatosLista datosLista;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_detalle, container, false);

        nombre = view.findViewById(R.id.nombreDetalle);
        developer = view.findViewById(R.id.desarolladorDetalle);
        publisher = view.findViewById(R.id.publisherDetalle);
        genero = view.findViewById(R.id.generoDetalle);
        fecha = view.findViewById(R.id.fechaDetalle);
        plataformas = view.findViewById(R.id.plataformasDetalle);
        imageView = view.findViewById(R.id.imagenDetalle);

        return view;
    }


    public void mostrarJuego(Juego juego){
        //Juego nuevoJuego = new Juego(juego, desarrollador, publisher, genero, R.drawable.unknown);
        //listaDatos.add(nuevoJuego);

        Log.v("debug", "He entrado en la funcion");


        imageView.setImageResource(juego.getImagen());
        nombre.setText("Titulo: " + juego.getNombre());
        developer.setText("Desarrollador: " + juego.getDesarrollador());
        publisher.setText("Publisher: " + juego.getPublisher());
        genero.setText("Genero: " + juego.getGenero());
        fecha.setText("Fecha de lanzamiento: " + juego.getFecha());
        plataformas.setText("Disponible en: " + juego.getPlataformas());

    }

    @Override
    public void onStart() {
        super.onStart();

        Log.v("debug", "OnCreate");
    }

}
