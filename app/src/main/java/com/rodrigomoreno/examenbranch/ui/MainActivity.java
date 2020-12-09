package com.rodrigomoreno.examenbranch.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.rodrigomoreno.examenbranch.Colaboradores;
import com.rodrigomoreno.examenbranch.R;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNombre;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button btnRegistro;

    //Variables Registro
    private String nombre = "";
    private  String email = "";
    private String password = "";

    FirebaseAuth mAuth;
    DatabaseReference mDataBase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        mDataBase = FirebaseDatabase.getInstance().getReference();

        editTextNombre = findViewById(R.id.editTextNombreUsuario);
        editTextEmail = findViewById(R.id.editTextEmailUsuario);
        editTextPassword = findViewById(R.id.editTextPasswordUsuario);
        btnRegistro = findViewById(R.id.btn_registrar);

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nombre = editTextNombre.getText().toString();
                email = editTextEmail.getText().toString();
                password = editTextPassword.getText().toString();
                Intent intentRegistro = new Intent(MainActivity.this, Colaboradores.class);
                startActivity(intentRegistro);


                if(!nombre.isEmpty()  && !email.isEmpty() && !password.isEmpty()){
                    if(password.length() >= 6) {


                        registroUsuario();
                    }else{
                        Toast.makeText(MainActivity.this,"El password debe tener minimo 6 caracteres", Toast.LENGTH_LONG).show();
                    }
                }else
                {
                    Toast.makeText(MainActivity.this, "Debe llenar todos los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void registroUsuario() {
        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){

                    Map<String,Object> map = new HashMap<>();
                    map.put("Nombre",nombre);
                    map.put("Email",email);
                    map.put("password",password);

                    String id = mAuth.getCurrentUser().getUid();

                    mDataBase.child("Users").child(id).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task2) {
                            if (task2.isSuccessful()){
                                Intent intentRegistro = new Intent(MainActivity.this, Colaboradores.class);
                                startActivity(intentRegistro);
                               finish();
                            }else
                            {
                                Toast.makeText(MainActivity.this, "No se pudieron agregar los datos correctamente", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }else{
                    Toast.makeText(MainActivity.this, "No se pudo registrar el usuario", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}