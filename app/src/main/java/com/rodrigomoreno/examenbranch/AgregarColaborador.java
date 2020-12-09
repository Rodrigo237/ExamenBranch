package com.rodrigomoreno.examenbranch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AgregarColaborador extends AppCompatActivity {

    private EditText editTextId,editTextNombre;
    private EditText editTextlatitud, editTextlongitud;
    private EditText editTextEmail;

    private Button btnAgregarNuevo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_colaborador);

        editTextId = findViewById(R.id.editIdColaborador);
        editTextNombre = findViewById(R.id.editTextNombreColaborador);
        editTextlatitud = findViewById(R.id.editTextLatitud);
        editTextlongitud = findViewById(R.id.editTextLongitud);
        editTextEmail = findViewById(R.id.editTextTextEmailColaborador);


        btnAgregarNuevo = findViewById(R.id.btnAgregarNuevo);

        btnAgregarNuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}