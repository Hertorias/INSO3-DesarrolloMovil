package com.example.trabajofinaljuniov2.fragments;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trabajofinaljuniov2.R;
import com.example.trabajofinaljuniov2.adapters.AdaptadorCarrito;
import com.example.trabajofinaljuniov2.database.GameHelper;
import com.example.trabajofinaljuniov2.database.SchemeDB;
import com.example.trabajofinaljuniov2.utils.Juego;

import java.util.ArrayList;

public class FragmentCarrito extends Fragment {

    private View view;
    private RecyclerView recycler;
    private AdaptadorCarrito adaptador;

    private ArrayList<Juego> listaDatos;

    private SQLiteDatabase database;
    private GameHelper gameHelper;

    private Button botonLimpiar;
    private Button botonTramitar;
    private TextView textoTotal;
    private Double total;

    private String usuario;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        total = 0.0;
        listaDatos = new ArrayList<>();

        gameHelper = new GameHelper(context, SchemeDB.DB_NAME, null, SchemeDB.VERSION);
        database = gameHelper.getReadableDatabase();

        Bundle arguments = getArguments();
        String desired_string = arguments.getString("nombreUsuario");
        usuario = desired_string.split(" ")[1];
        Log.v("A", usuario);

        String queryPat = "SELECT * FROM %s WHERE %s == '%s'";
        Cursor cursor = database.rawQuery(String.format(queryPat, SchemeDB.TAB_CARRITO, SchemeDB.COL_SHOPPINGCART_USERNAME, usuario), null);

        while (cursor.moveToNext()){
            Juego juegoActual = new Juego(cursor.getString(1), cursor.getDouble(2), cursor.getInt(3), cursor.getString(4));
            Log.v("basedatos", cursor.getString(1));
            listaDatos.add(juegoActual);
            total = total + cursor.getDouble(2);
        }

        adaptador = new AdaptadorCarrito(listaDatos,getContext());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_carrito, container, false);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        recycler = (RecyclerView) view.findViewById(R.id.recycler_juegos);
        LinearLayoutManager layoutRecycler = new LinearLayoutManager(getContext());
        recycler.setLayoutManager(layoutRecycler);

        recycler.addItemDecoration(new DividerItemDecoration(getContext(), layoutRecycler.getOrientation()));

        recycler.setAdapter(adaptador);

        textoTotal = view.findViewById(R.id.totalText);
        botonLimpiar = view.findViewById(R.id.botonLimpiar);
        botonTramitar = view.findViewById(R.id.botonTramitar);

        textoTotal.setText("TOTAL: " + String.valueOf(total) + "€");

        if(listaDatos.isEmpty())
            botonTramitar.setEnabled(false);
        else
            botonTramitar.setEnabled(true);

        botonTramitar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("A", "He tramitado el pedido");
                String email = "prueba@prueba.com";
                String queryPat = "SELECT * FROM %s WHERE %s == '%s'";
                Cursor cursor = database.rawQuery(String.format(queryPat, SchemeDB.TAB_USUARIOS, SchemeDB.COL_USERS_USERNAME, usuario), null);
                while(cursor.moveToNext()){
                    email = cursor.getString(2);
                }
                Log.v("A", email);

                String Mensaje = "Gracias por su compra.\nEl pago deberá efectuarse en las próximas " +
                        "24 horas.\n" +
                        "Detalles del pedido:\n\n";

                for(Juego item:listaDatos){
                    Mensaje = Mensaje + item.getNombre() + ", " + String.valueOf(item.getPrecio()) + "€\n";
                }
                Mensaje = Mensaje + "\nTotal del pedido: " + String.valueOf(total) + "€";

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL,new
                        String[]{email});
                intent.putExtra(Intent.EXTRA_SUBJECT, "Detalles del pedido");
                intent.putExtra(Intent.EXTRA_TEXT, Mensaje);
                intent.setType("message/rfc822");
                startActivity(intent);

            }
        });

        botonLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String query = "DELETE FROM %s WHERE %s == '%s'";
                database.execSQL(String.format(query, SchemeDB.TAB_CARRITO, SchemeDB.COL_SHOPPINGCART_USERNAME, usuario));
                listaDatos.clear();
                adaptador.notifyDataSetChanged();
                botonTramitar.setEnabled(false);
                textoTotal.setText("TOTAL: 0.0€");
            }
        });
    }

}
