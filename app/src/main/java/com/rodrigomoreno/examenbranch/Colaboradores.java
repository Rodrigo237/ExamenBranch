package com.rodrigomoreno.examenbranch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.rodrigomoreno.examenbranch.Interface.JsonPlaceHolder;
import com.rodrigomoreno.examenbranch.servicios.Consumo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Colaboradores extends AppCompatActivity {

    private  Button btnMisColaboradores;
    private Button btnAgregarColab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colaboradores);

        btnMisColaboradores = findViewById(R.id.btnMisColaboradores);
        btnAgregarColab = findViewById(R.id.btnAgregarColaborador);

        btnMisColaboradores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentMisColab = new Intent(Colaboradores.this,MisColaboradores.class);
                    startActivity(intentMisColab);
            }
        });
    }



}