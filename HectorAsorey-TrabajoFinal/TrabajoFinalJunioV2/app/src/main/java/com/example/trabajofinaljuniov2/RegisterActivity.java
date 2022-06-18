package com.example.trabajofinaljuniov2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.trabajofinaljuniov2.database.GameHelper;
import com.example.trabajofinaljuniov2.database.SchemeDB;

public class RegisterActivity extends AppCompatActivity {

    private EditText username;
    private EditText email;
    private EditText password;
    private Button boton;

    private SQLiteDatabase database;
    private GameHelper gameHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = findViewById(R.id.Username);
        email = findViewById(R.id.Email);
        password = findViewById(R.id.Password);
        boton = findViewById(R.id.register);

        gameHelper = new GameHelper(getApplicationContext(), SchemeDB.DB_NAME, null, SchemeDB.VERSION);
        database = gameHelper.getWritableDatabase();

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String queryPat = "INSERT into %s (%s,%s,%s) VALUES ('%s', '%s', '%s')" ;
                database.execSQL(String.format(queryPat, SchemeDB.TAB_USUARIOS, SchemeDB.COL_USERS_USERNAME,
                        SchemeDB.COL_USERS_EMAIL, SchemeDB.COL_USERS_PASSWORD,
                        username.getText().toString(), email.getText().toString(), password.getText().toString()));

                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });


    }
}