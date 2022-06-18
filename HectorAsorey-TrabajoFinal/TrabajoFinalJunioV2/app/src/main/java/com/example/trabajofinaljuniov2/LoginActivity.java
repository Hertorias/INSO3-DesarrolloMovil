package com.example.trabajofinaljuniov2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.trabajofinaljuniov2.database.GameHelper;
import com.example.trabajofinaljuniov2.database.SchemeDB;

public class LoginActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private TextView error;
    private Button boton;

    private SQLiteDatabase database;
    private GameHelper gameHelper;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.enterUsername);
        password = findViewById(R.id.enterPassword);
        error = findViewById(R.id.error);
        boton = findViewById(R.id.Login);

        gameHelper = new GameHelper(getApplicationContext(), SchemeDB.DB_NAME, null, SchemeDB.VERSION);
        database = gameHelper.getReadableDatabase();

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String queryPat = "SELECT * FROM %s WHERE %s == '%s'";
                Cursor cursor = database.rawQuery(String.format(queryPat, SchemeDB.TAB_USUARIOS, SchemeDB.COL_USERS_USERNAME, username.getText().toString()), null);

                if(cursor.getCount() == 0) {
                    error.setText("Error: Usuario no encontrado");
                    error.setTextColor(Color.RED);
                }

                while (cursor.moveToNext()){
                    if(password.getText().toString().equals(cursor.getString(3))){
                        Log.v("Registro","Registro con exito");

                        Intent intent = new Intent(getApplicationContext(), PrincipalActivity.class);
                        intent.putExtra("usuario", username.getText().toString());
                        startActivity(intent);
                    }
                    else{
                        error.setText("Error: Contraseña incorrecta");
                        error.setTextColor(Color.RED);
                    }
                }
            }
        });
    }
}