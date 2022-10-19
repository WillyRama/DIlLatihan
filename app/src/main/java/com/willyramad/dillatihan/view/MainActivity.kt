package com.willyramad.dillatihan.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.willyramad.dillatihan.databinding.ActivityMainBinding
import com.willyramad.dillatihan.viewmodel.ViewModelProduk
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var  binding : ActivityMainBinding
    lateinit var adapterProduk: AdapterProduk
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setVmtoAdapter()
    }

    fun setVmtoAdapter(){
        val viewModel = ViewModelProvider(this).get(ViewModelProduk::class.java)
        viewModel.callApiPro()
        viewModel.getLiveDataPro().observe(this, Observer {
            adapterProduk = AdapterProduk(it)
            if (it != null){
                binding.rvPro.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                binding.rvPro.adapter = AdapterProduk(it)
            }
        })
    }
}