package com.example.retrodaggerapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.retrodaggerapp.datamodels.Product
import com.example.retrodaggerapp.retrofit.FakerProductAPI
import javax.inject.Inject

class ProductRepository @Inject constructor(private val FakerProductAPI: FakerProductAPI) {

    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>>
        get() = _products

    suspend fun getProducts(){
        val result = FakerProductAPI.getProducts()
        if(result.isSuccessful && result.body() != null){
            _products.postValue(result.body())
        }
    }
}