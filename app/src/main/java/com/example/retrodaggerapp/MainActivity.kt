package com.example.retrodaggerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrodaggerapp.viewmodels.MainViewModel
import com.example.retrodaggerapp.viewmodels.MainViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel

    lateinit var productAdapter: ProductAdapter

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory

    //private val products: TextView
    //get() = findViewById(R.id.products)

    private val productList:RecyclerView
        get() = findViewById(R.id.productList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as MainApplication).applicationComponent.inject(this)
        mainViewModel =ViewModelProvider(this,mainViewModelFactory).get(MainViewModel::class.java)

        mainViewModel.productsLiveData.observe(this, Observer {
            //products.text =  it.joinToString { x -> x.title + "\n\n" }
            productAdapter = ProductAdapter(this,it.toList())
            productList.adapter = productAdapter
            productList.layoutManager = LinearLayoutManager(this)
        })



    }
}