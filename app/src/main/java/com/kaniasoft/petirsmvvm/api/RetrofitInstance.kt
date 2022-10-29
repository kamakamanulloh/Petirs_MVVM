package com.kaniasoft.petirsmvvm.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    val api : PasienApi by lazy {
        Retrofit.Builder()
            .baseUrl("http://simrs.rsiamuslimat.com/api_regonline_test/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PasienApi::class.java)
    }
}