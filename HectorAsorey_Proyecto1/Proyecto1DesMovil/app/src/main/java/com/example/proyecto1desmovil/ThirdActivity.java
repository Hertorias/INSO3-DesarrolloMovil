package com.example.proyecto1desmovil;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.proyecto1desmovil.fragments.fragmentDetalles;
import com.example.proyecto1desmovil.fragments.fragmentJuego;
import com.example.proyecto1desmovil.utils.Juego;

public class ThirdActivity extends AppCompatActivity {

    /*private ImageView image;
    private TextView nombre;
    private TextView desarrollador;
    private TextView publisher;
    private TextView genero;
    private TextView fecha;
    private TextView plataformas;
*/
    private Juego juegoAMostrar;

    private Toolbar toolbar;
    private ActionBar actionBar;

    private FragmentManager fragmentManager;
    private com.example.proyecto1desmovil.fragments.fragmentDetalles fragmentDetalles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        fragmentManager = this.getSupportFragmentManager();
        fragmentDetalles = (fragmentDetalles) fragmentManager.findFragmentById(R.id.fragment_detalles);

        /*
        image = findViewById(R.id.imagenDetalle);
        nombre = findViewById(R.id.nombreDetalle);
        desarrollador = findViewById(R.id.desarolladorDetalle);
        publisher = findViewById(R.id.publisherDetalle);
        genero = findViewById(R.id.generoDetalle);
        fecha = findViewById(R.id.fechaDetalle);
        plataformas = findViewById(R.id.plataformasDetalle);*/

        juegoAMostrar = (Juego) getIntent().getExtras().getSerializable("juego");

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(juegoAMostrar.getNombre());

        fragmentDetalles.mostrarJuego(juegoAMostrar);

        /*
        image.setImageResource(juegoAMostrar.getImagen());
        nombre.setText("Titulo: " + juegoAMostrar.getNombre());
        desarrollador.setText("Desarrollador: " + juegoAMostrar.getDesarrollador());
        publisher.setText("Publisher: " + juegoAMostrar.getPublisher());
        genero.setText("Genero: " + juegoAMostrar.getGenero());
        fecha.setText("Fecha de lanzamiento: " + juegoAMostrar.getFecha());
        plataformas.setText("Disponible en: " + juegoAMostrar.getPlataformas());*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menutoolbardetalles,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.menu_opcion1:
                Log.v("menus","Pulsado boton");

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL, new
                        String[]{"direccion@ext.live.u-tad.es"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "Mira este juego");
                intent.putExtra(Intent.EXTRA_TEXT, "Juego: " + juegoAMostrar.getNombre()
                        + "\nDesarrollador: " + juegoAMostrar.getDesarrollador()
                        + "\nPublisher: " + juegoAMostrar.getPublisher()
                        + "\nGenero: " + juegoAMostrar.getGenero()
                        + "\nFecha de lanzamiento: " + juegoAMostrar.getFecha()
                        + "\nDisponible en: " + juegoAMostrar.getPlataformas()
                );
                intent.setType("message/rfc822");
                startActivity(intent);

                break;
            case android.R.id.home:
                intent = new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra("desarrollador", juegoAMostrar.getDesarrollador());
                startActivity(intent);

        }
        return super.onOptionsItemSelected(item);
    }
}