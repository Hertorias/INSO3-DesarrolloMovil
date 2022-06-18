package com.example.proyecto1desmovil;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.proyecto1desmovil.adapters.AdaptadorDesarrollador;
import com.example.proyecto1desmovil.fragments.fragmentDesarrollador;
import com.example.proyecto1desmovil.utils.Desarrollador;

public class MainActivity extends AppCompatActivity implements AdaptadorDesarrollador.OnRecyclerListener {

    private fragmentDesarrollador fragmentDesarrollador;
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = this.getSupportFragmentManager();
        fragmentDesarrollador = (fragmentDesarrollador) manager.findFragmentById(R.id.fragment_estatica);
    }

    @Override
    public void onDesarrolladorSelected(Desarrollador desarrollador) {
        Log.v("AAAA", "Desarrollador seleccionado: " + desarrollador.getNombre());

        Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
        intent.putExtra("desarrollador", desarrollador.getNombre());
        startActivity(intent);
    }
}