package com.example.proyecto1desmovil;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.proyecto1desmovil.adapters.AdaptadorJuego;
import com.example.proyecto1desmovil.fragments.fragmentJuego;
import com.example.proyecto1desmovil.utils.Juego;

public class SecondActivity extends AppCompatActivity implements AdaptadorJuego.OnRecyclerListener {

    private String desarrollador;
    private FragmentManager fragmentManager;
    private fragmentJuego fragmentJuego;

    private Toolbar toolbar;
    private ActionBar actionBar;

    //private ImageView imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        toolbar.setTitle("");
        toolbar.setSubtitle("");

        actionBar.setDisplayHomeAsUpEnabled(true);

        if(getIntent().getExtras() != null) {
            desarrollador = getIntent().getExtras()
                    .getString("desarrollador");
            actionBar.setTitle(desarrollador);
        }

        fragmentManager = this.getSupportFragmentManager();
        fragmentJuego = (fragmentJuego) fragmentManager.findFragmentById(R.id.fragment_juegos);

        fragmentJuego.comunicarYMostrar(desarrollador);
    }

    @Override
    public void onJuegoSelected(Juego juego) {

        Log.v("AAA", "Juego: " + juego.getNombre());

        Intent intent = new Intent(getApplicationContext(), ThirdActivity.class);

        intent.putExtra("juego", juego);
        //intent.putExtra("imagen", desarrollador.getImagen());

        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar_juegos,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.menu_opcion1:
                Log.v("menus","Pulsado boton");

                AlertDialog.Builder builder = new AlertDialog.Builder(SecondActivity.this, R.style.Theme_Proyecto1DesMovil);
                final View miLayout = getLayoutInflater().inflate(R.layout.juego_popup, null);
                builder.setView(miLayout);

                builder.setTitle("Añadir juego");

                EditText editText1 = miLayout.findViewById(R.id.juego);
                EditText editText2 = miLayout.findViewById(R.id.publisher);
                EditText editText3 = miLayout.findViewById(R.id.genero);
                EditText editText4 = miLayout.findViewById(R.id.fecha);
                EditText editText5 = miLayout.findViewById(R.id.plataformas);

                //Button boton = miLayout.findViewById(R.id.a);
                /*imagen = miLayout.findViewById(R.id.b);

                boton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        intent.setType("image/");
                        startActivityForResult(intent.createChooser(intent, "Seleccione la aplicacion"), 10);
                    }
                });*/



                builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        if(editText1.getText().toString().matches("")){
                            Log.v("AA", editText1.getText().toString());
                            //Log.v("AA", editText2.getText().toString());
                        }
                        else{
                            Log.v("AA", editText1.getText().toString());
                            Juego juego = new Juego(editText1.getText().toString(), desarrollador, editText2.getText().toString(), editText3.getText().toString(), editText4.getText().toString(), editText5.getText().toString(), R.drawable.unknown);
                            //Log.v("AA", editText2.getText().toString());
                            //fragmentJuego.guardarNuevoDato(editText1.getText().toString(), editText2.getText().toString());
                            fragmentJuego.guardarNuevoDato(juego);
                            Log.v("debug", "He entrado en el condicional");
                        }

                    }
                });

                builder.setNegativeButton("Cancelar", (dialog, which) -> {
                   Log.v("Cancelar", "cancelar");
                });

                AlertDialog dialog = builder.create();
                dialog.show();


                break;
        }
        return super.onOptionsItemSelected(item);
    }
/*
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            Uri path = data.getData();
            imagen.setImageURI(path);
        }
    }*/
}