package com.example.proyecto1desmovil.fragments;

import android.app.ActionBar;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyecto1desmovil.R;
import com.example.proyecto1desmovil.adapters.AdaptadorDesarrollador;
import com.example.proyecto1desmovil.adapters.AdaptadorJuego;
import com.example.proyecto1desmovil.datos.DatosLista;
import com.example.proyecto1desmovil.utils.Desarrollador;
import com.example.proyecto1desmovil.utils.Juego;

import java.util.ArrayList;

public class fragmentJuego extends Fragment {

    private String desarrollador;

    private View view;
    private RecyclerView recycler;
    private AdaptadorJuego adaptador;
    private Toolbar toolbar;
    private ActionBar actionBar;

    private ArrayList<Juego> listaDatos;
    private ArrayList<Juego> listaDatosAMostrar;

    private DatosLista datosLista;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        datosLista = new DatosLista();
        datosLista.instanciarJuegos();

        listaDatos = new ArrayList<>();
        listaDatosAMostrar = new ArrayList<>();

        listaDatos = datosLista.getJuegos();
        /*
        listaDatos.add(new Juego("Halo 3","Bungie", R.drawable.halo3));
        listaDatos.add(new Juego("Halo 3: ODST","Bungie", R.drawable.haloodst));
        listaDatos.add(new Juego("Halo Reach","Bungie", R.drawable.haloreach));
        listaDatos.add(new Juego("Destiny","Bungie", R.drawable.destiny));
        listaDatos.add(new Juego("Destiny 2","Bungie", R.drawable.destiny2));
        listaDatos.add(new Juego("Halo Infinite", "343 Industries", R.drawable.haloinfinite));*/

        adaptador = new AdaptadorJuego(listaDatosAMostrar,getContext());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_juego, container, false);

        return view;
    }

    public void comunicarYMostrar(String desarrollador){
        this.desarrollador = desarrollador;
        for ( Juego item : listaDatos ) {
            if (item.getDesarrollador().equalsIgnoreCase(desarrollador)){
                listaDatosAMostrar.add(item);
            }

        }
        adaptador.notifyDataSetChanged();
    }

    public void guardarNuevoDato(Juego juego){
        //Juego nuevoJuego = new Juego(juego, desarrollador, publisher, genero, R.drawable.unknown);
        //listaDatos.add(nuevoJuego);

        Log.v("debug", "He entrado en la funcion");
        listaDatosAMostrar.add(juego);
        adaptador.notifyDataSetChanged();

        /*
        if (listaDatosAMostrar.isEmpty() == false && listaDatosAMostrar.get(0).getDesarrollador().matches(desarrollador)){
            Log.v("debug", "He entrado en el segundo condicional");
            listaDatosAMostrar.add(nuevoJuego);
            adaptador.notifyDataSetChanged();

        }*/
    }

    @Override
    public void onStart() {
        super.onStart();
        recycler = (RecyclerView) view.findViewById(R.id.recycler_juegos);
        LinearLayoutManager layoutRecycler = new LinearLayoutManager(getContext()); //RecyclerView.VERTICAL
        recycler.setLayoutManager(layoutRecycler);

        recycler.addItemDecoration(new DividerItemDecoration(getContext(), layoutRecycler.getOrientation()));

        recycler.setAdapter(adaptador);
    }
}
