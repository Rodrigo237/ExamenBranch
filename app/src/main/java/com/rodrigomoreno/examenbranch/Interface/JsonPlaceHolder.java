package com.rodrigomoreno.examenbranch.Interface;

import android.util.Log;

import com.rodrigomoreno.examenbranch.servicios.Consumo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolder {

    @GET("getFile.json?dl=0")
    Call<List<Consumo>> getConsumos();

}
