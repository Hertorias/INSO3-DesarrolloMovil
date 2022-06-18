package com.example.trabajofinaljuniov2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.example.trabajofinaljuniov2.adapters.AdaptadorJuego;
import com.example.trabajofinaljuniov2.database.GameHelper;
import com.example.trabajofinaljuniov2.database.SchemeDB;
import com.example.trabajofinaljuniov2.fragments.FragmentCarrito;
import com.example.trabajofinaljuniov2.fragments.FragmentJuegos;
import com.example.trabajofinaljuniov2.fragments.FragmentOfertas;
import com.example.trabajofinaljuniov2.fragments.FragmentWelcome;
import com.example.trabajofinaljuniov2.utils.Juego;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class PrincipalActivity extends AppCompatActivity implements AdaptadorJuego.OnRecyclerListener {

    private Toolbar toolbar;
    private ActionBar actionBar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private ActionBarDrawerToggle drawerToggle;


    private ArrayList<Juego> carrito;

    private SQLiteDatabase database;
    private GameHelper gameHelper;
    private SimpleCursorAdapter adapter;

    private TextView textHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        navigationView = findViewById(R.id.navigation);
        drawerLayout = findViewById(R.id.drawer);

        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();

        actionBar.setTitle("Inicio");

        if(getIntent().getExtras() != null) {
            textHeader = navigationView.getHeaderView(0).findViewById(R.id.tituloCabecera);
            textHeader.setText("Bienvenido, " + getIntent().getExtras()
                    .getString("usuario"));
        }

        drawerToggle = new ActionBarDrawerToggle(PrincipalActivity.this,drawerLayout,toolbar,0,0);
        drawerLayout.setDrawerListener(drawerToggle);
        drawerToggle.syncState();

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.sitio_fragments, new FragmentWelcome());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

        carrito = new ArrayList<>();

        gameHelper = new GameHelper(getApplicationContext(), SchemeDB.DB_NAME, null, SchemeDB.VERSION);
        database = gameHelper.getWritableDatabase();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();

                switch (item.getItemId()){

                    case R.id.menu_f1:
                        actionBar.setTitle("Juegos");
                        fragmentTransaction.replace(R.id.sitio_fragments,new FragmentJuegos());
                        fragmentTransaction.addToBackStack("f1");
                        break;
                    case R.id.menu_f2:
                        actionBar.setTitle("Ofertas");
                        fragmentTransaction.replace(R.id.sitio_fragments,new FragmentOfertas());
                        fragmentTransaction.addToBackStack("f2");
                        break;
                    case R.id.menu_f3:
                        actionBar.setTitle("Carrito de compra");
                        FragmentCarrito fragmentCarrito = new FragmentCarrito();
                        Bundle arguments = new Bundle();
                        arguments.putString("nombreUsuario", textHeader.getText().toString());
                        fragmentCarrito.setArguments(arguments);
                        fragmentTransaction.replace(R.id.sitio_fragments, fragmentCarrito);
                        fragmentTransaction.addToBackStack("f3");
                        break;
                }
                fragmentTransaction.commit();
                drawerLayout.closeDrawer(GravityCompat.START);

                return true;
            }
        });
    }

    @Override
    public void onJuegoSelected(Juego juego) {

        String user = textHeader.getText().toString().split(" ")[1];

        String queryPat = "INSERT into %s (%s,%s,%s,%s,%s) VALUES ('%s', %f, %d, '%s', '%s')" ;
        database.execSQL(String.format(queryPat, SchemeDB.TAB_CARRITO, SchemeDB.COL_GAMES_NAME,
                SchemeDB.COL_GAMES_PRICE, SchemeDB.COL_GAMES_IMAGE, SchemeDB.COL_GAMES_PLATFORM, SchemeDB.COL_SHOPPINGCART_USERNAME,
                juego.getNombre(), juego.getPrecio(), juego.getImagen(), juego.getPlataforma(), user));

    }
}