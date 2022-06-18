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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.TextView;
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

public class FragmentJuegos extends Fragment implements AdapterView.OnItemSelectedListener {

    private View view;
    private RecyclerView recycler;
    private AdaptadorJuego adaptador;

    private ArrayList<Juego> listaDatos;

    private Datos datos;

    private SQLiteDatabase database;
    private GameHelper gameHelper;
    private Cursor cursor;

    private Spinner spinner;
    private ArrayAdapter adapterSpinner;
    private ArrayList listaFiltros;

    private TextView texto;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        gameHelper = new GameHelper(context, SchemeDB.DB_NAME, null, SchemeDB.VERSION);
        database = gameHelper.getReadableDatabase();

        datos = new Datos();
        datos.instanciarJuegos();

        datos.instanciarTodo();

        //Introducir datos en BBDD

        database = gameHelper.getWritableDatabase();

        //Aquí empieza el relleno de datos en la BBDD

        database.execSQL("DELETE FROM GAMES");

        String queryPat = "INSERT into %s (%s,%s,%s,%s) VALUES ('%s', %f, %d, '%s')" ;

        ArrayList<Juego> listaDatosSQL = new ArrayList<>();
        listaDatosSQL = datos.getTodosLosJuegos();

        for(Juego item: listaDatosSQL){

            database.execSQL(String.format(queryPat, SchemeDB.TAB_GAMES, SchemeDB.COL_GAMES_NAME,
                    SchemeDB.COL_GAMES_PRICE, SchemeDB.COL_GAMES_IMAGE, SchemeDB.COL_GAMES_PLATFORM,
                    item.getNombre(), item.getPrecio(), item.getImagen(), item.getPlataforma()));
        }

        //Aquí termina la inclusión de juegos en BBDD

        //Coger datos de la base de datos y mostrarlos en el fragment
        listaDatos = new ArrayList<>();
        //listaDatosAMostrar = new ArrayList<>();
        queryPat = "SELECT * FROM %s";
        Cursor cursor = database.rawQuery(String.format(queryPat, SchemeDB.TAB_GAMES), null);

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
        view = inflater.inflate(R.layout.fragment_juegos, container, false);

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

        listaFiltros = new ArrayList<>();
        listaFiltros.add("Todos los juegos");
        listaFiltros.add("Juegos XBOX");
        listaFiltros.add("Juegos PS4");
        listaFiltros.add("Juegos Switch");

        texto = view.findViewById(R.id.titulo);

        spinner = view.findViewById(R.id.spinnerOpcion);
        adapterSpinner = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, listaFiltros);
        adapterSpinner.notifyDataSetChanged();
        spinner.setAdapter(adapterSpinner);

        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Log.v("elementos", spinner.getSelectedItem().toString());
        listaDatos.clear();
        String tituloAPoner = "";

        if(spinner.getSelectedItem().toString().equals("Todos los juegos")){
            String queryPat = "SELECT * FROM %s";
            cursor = database.rawQuery(String.format(queryPat, SchemeDB.TAB_GAMES), null);
            tituloAPoner = "TODOS LOS JUEGOS";
        }
        else if(spinner.getSelectedItem().toString().equals("Juegos XBOX")){
            String queryPat = "SELECT * FROM %s WHERE %s == 'XBOX'";
            cursor = database.rawQuery(String.format(queryPat, SchemeDB.TAB_GAMES, SchemeDB.COL_GAMES_PLATFORM), null);
            tituloAPoner = "JUEGOS XBOX";
        }
        else if(spinner.getSelectedItem().toString().equals("Juegos PS4")){
            String queryPat = "SELECT * FROM %s WHERE %s == 'PS4'";
            cursor = database.rawQuery(String.format(queryPat, SchemeDB.TAB_GAMES, SchemeDB.COL_GAMES_PLATFORM), null);
            tituloAPoner = "JUEGOS PS4";
        }
        else if(spinner.getSelectedItem().toString().equals("Juegos Switch")){
            String queryPat = "SELECT * FROM %s WHERE %s == 'Switch'";
            cursor = database.rawQuery(String.format(queryPat, SchemeDB.TAB_GAMES, SchemeDB.COL_GAMES_PLATFORM), null);
            tituloAPoner = "JUEGOS SWITCH";
        }

        while (cursor.moveToNext()){
            Juego juegoActual = new Juego(cursor.getString(1), cursor.getDouble(2), cursor.getInt(3), cursor.getString(4));
            Log.v("basedatos", cursor.getString(1));
            listaDatos.add(juegoActual);
            // String nombre = cursor.getString(1);
            // String company = cursor.getString(2);
        }
        adaptador.notifyDataSetChanged();
        texto.setText(tituloAPoner);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

}
