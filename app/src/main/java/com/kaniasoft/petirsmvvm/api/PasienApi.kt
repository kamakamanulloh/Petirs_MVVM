package com.kaniasoft.petirsmvvm.api

import com.kaniasoft.petirsmvvm.model.Pasien
import retrofit2.Call
import retrofit2.http.GET

interface PasienApi {
    @GET("list_pasien.php")
    fun getPasien() : Call<Pasien>
}