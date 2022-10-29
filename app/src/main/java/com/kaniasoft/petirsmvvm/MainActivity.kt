package com.kaniasoft.petirsmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.kaniasoft.petirsmvvm.adapter.PasienAdapter
import com.kaniasoft.petirsmvvm.databinding.ActivityMainBinding
import com.kaniasoft.petirsmvvm.viewmodel.PasienViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel: PasienViewModel
    private lateinit var pasienAdapter: PasienAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        prepareRecyclerView()
        viewModel = ViewModelProvider(this)[PasienViewModel::class.java]
        viewModel.getPopularMovies()
        viewModel.observePasienLiveData()LiveData().observe(this, Observer { pasienList ->
            pasienAdapter.setPasienList(pasienList)
        })
    }
    private fun prepareRecyclerView() {
        pasienAdapter = PasienAdapter()
        binding.rvPasien.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = pasienAdapter
        }
    }
}