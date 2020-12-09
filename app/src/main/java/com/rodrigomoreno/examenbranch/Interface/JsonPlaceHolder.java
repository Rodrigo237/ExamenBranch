package com.rodrigomoreno.examenbranch.Interface;

import android.util.Log;

import com.rodrigomoreno.examenbranch.servicios.Consumo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolder {
    String key = "0";

    @GET("s/5u21281sca8gj94/getFile.json?dl="+key)
    Call<List<Consumo>> getConsumos();

}
