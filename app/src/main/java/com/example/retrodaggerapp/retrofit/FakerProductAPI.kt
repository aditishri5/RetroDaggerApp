package com.example.retrodaggerapp.retrofit

import com.example.retrodaggerapp.datamodels.Product
import retrofit2.Response
import retrofit2.http.GET

interface FakerProductAPI {

    @GET("products")
    suspend fun getProducts() : Response<List<Product>>
}