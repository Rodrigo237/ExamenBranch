package com.rodrigomoreno.examenbranch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.rodrigomoreno.examenbranch.Interface.JsonPlaceHolder;
import com.rodrigomoreno.examenbranch.servicios.Consumo;

import java.lang.ref.ReferenceQueue;
import java.util.List;

import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MisColaboradores extends AppCompatActivity {

    private TextView mJsonTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_colaboradores);
        mJsonTextView = findViewById(R.id.textViewJson);
       getConsumo();
    }

    private void getConsumo(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://dl.dropboxusercontent.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonPlaceHolder jsonPlaceHolder = retrofit.create(JsonPlaceHolder.class);

        Call<List<Consumo>> call = jsonPlaceHolder.getConsumos();

        call.enqueue(new Callback<List<Consumo>>() {
            @Override
            public void onResponse(Call<List<Consumo>> call, Response<List<Consumo>> response) {
                if (!response.isSuccessful()){
                        mJsonTextView.setText("Codigo: "+response.code());
                        return;
                }
                List<Consumo> listConsumo = response.body();

                for (Consumo consumo: listConsumo){
                    String content = "";
                    content += "data" + consumo.getData();
                    content += "file" + consumo.getFile();
                    content += "code" + consumo.getCode();
                    content += "success" + consumo.getSuccess();
                    mJsonTextView.append(content);


                }

            }

            @Override
            public void onFailure(Call<List<Consumo>> call, Throwable t) {
                    mJsonTextView.setText(t.getMessage());
                    Log.i("pro",""+call);
            }
        });
    }

 /*   RequestQueue queue = Volley.newRequestQueue(this);
    String url = "https://dl.dropboxusercontent.com/s/5u21281sca8gj94/getFile.json?dl=0";

    StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    // Display the first 500 characters of the response string.
                    mJsonTextView.setText("Response is: "+ response.substring(0,500));
                }
            }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            mJsonTextView.setText("That didn't work!");
        }
    });*/

}