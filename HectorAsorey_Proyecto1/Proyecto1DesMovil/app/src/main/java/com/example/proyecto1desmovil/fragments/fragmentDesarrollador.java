package com.example.proyecto1desmovil.fragments;

import android.app.ActionBar;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.example.proyecto1desmovil.datos.DatosLista;
import com.example.proyecto1desmovil.utils.Desarrollador;

import java.util.ArrayList;

public class fragmentDesarrollador extends Fragment {

    private View view;
    private RecyclerView recycler;
    private AdaptadorDesarrollador adaptador;
    private Toolbar toolbar;
    private ActionBar actionBar;

    private ArrayList<Desarrollador> listaDatos;
    private DatosLista datosLista;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        datosLista = new DatosLista();
        datosLista.instanciarDesarrolladores();

        listaDatos = new ArrayList<>();

        listaDatos = datosLista.getDesarrolladores();
        /*listaDatos.add(new Desarrollador("Bungie", R.drawable.bungie));
        listaDatos.add(new Desarrollador("343 Industries", R.drawable.a));*/

        adaptador = new AdaptadorDesarrollador(listaDatos,getContext());

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_desarrollador, container, false);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        recycler = (RecyclerView) view.findViewById(R.id.recycler_desarrollador);
        LinearLayoutManager layoutRecycler = new LinearLayoutManager(getContext());
        recycler.setLayoutManager(layoutRecycler);

        recycler.addItemDecoration(new DividerItemDecoration(getContext(), layoutRecycler.getOrientation()));

        recycler.setAdapter(adaptador);
    }
}
