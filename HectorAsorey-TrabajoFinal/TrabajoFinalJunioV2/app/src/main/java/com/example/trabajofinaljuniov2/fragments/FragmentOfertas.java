package com.example.trabajofinaljuniov2.fragments;

import android.app.ActionBar;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleCursorAdapter;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trabajofinaljuniov2.R;
import com.example.trabajofinaljuniov2.adapters.AdaptadorJuego;
import com.example.trabajofinaljuniov2.database.GameHelper;
import com.example.trabajofinaljuniov2.database.SchemeDB;
import com.example.trabajofinaljuniov2.utils.Datos;
import com.example.trabajofinaljuniov2.utils.Juego;

import java.util.ArrayList;

public class FragmentOfertas extends Fragment {

    private View view;
    private RecyclerView recycler;
    private AdaptadorJuego adaptador;

    private ArrayList<Juego> listaDatos;

    private Datos datos;

    private SQLiteDatabase database;
    private GameHelper gameHelper;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        datos = new Datos();
        datos.instanciarJuegosPS4();

        listaDatos = new ArrayList<>();

        gameHelper = new GameHelper(context, SchemeDB.DB_NAME, null, SchemeDB.VERSION);
        database = gameHelper.getReadableDatabase();

        String queryPat = "SELECT * FROM %s WHERE %s <= 30.00";
        Cursor cursor = database.rawQuery(String.format(queryPat, SchemeDB.TAB_GAMES, SchemeDB.COL_GAMES_PRICE), null);

        while (cursor.moveToNext()){
            Juego juegoActual = new Juego(cursor.getString(1), cursor.getDouble(2), cursor.getInt(3), cursor.getString(4));
            Log.v("basedatos", cursor.getString(1));
            listaDatos.add(juegoActual);
            // String nombre = cursor.getString(1);
            // String company = cursor.getString(2);
        }

        /*

        listaDatos.add(new Juego("Halo 3: ODST","Bungie", R.drawable.haloodst));
        listaDatos.add(new Juego("Halo Reach","Bungie", R.drawable.haloreach));
        listaDatos.add(new Juego("Destiny","Bungie", R.drawable.destiny));
        listaDatos.add(new Juego("Destiny 2","Bungie", R.drawable.destiny2));
        listaDatos.add(new Juego("Halo Infinite", "343 Industries", R.drawable.haloinfinite));*/

        adaptador = new AdaptadorJuego(listaDatos,getContext());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_ofertas, container, false);

        return view;
    }


    @Override
    public void onResume(){
        super.onResume();
        recycler = view.findViewById(R.id.recycler_juegos);
        GridLayoutManager layoutRecycler = new GridLayoutManager(getContext(), 2); //RecyclerView.VERTICAL
        recycler.setLayoutManager(layoutRecycler);

        //recycler.addItemDecoration(new DividerItemDecoration(getContext(), layoutRecycler.getOrientation()));

        recycler.setAdapter(adaptador);
    }

}
