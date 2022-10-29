package com.kaniasoft.petirsmvvm.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kaniasoft.petirsmvvm.api.RetrofitInstance
import com.kaniasoft.petirsmvvm.model.Pasien
import com.kaniasoft.petirsmvvm.model.Result
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PasienViewModel : ViewModel() {
    private var pasienLiveData = MutableLiveData<List<Result>>()
    fun getPopularMovies() {
        RetrofitInstance.api.getPasien().enqueue(object  : Callback<Pasien> {
            override fun onResponse(call: Call<Pasien>, response: Response<Pasien>) {
                if (response.body()!=null){
                    pasienLiveData.value = response.body()!!.result
                }
                else{
                    return
                }
            }
            override fun onFailure(call: Call<Pasien>, t: Throwable) {
                Log.d("TAG",t.message.toString())
            }
        })
    }
    fun observePasienLiveData() : LiveData<List<Result>> {
        return pasienLiveData
    }
}