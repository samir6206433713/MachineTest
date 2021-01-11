package com.tutorial.machinetest.model

import com.tutorial.machinetest.pojoclass.HomeScreenModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.HeaderMap

interface ApiInterface {
    @GET("photos")
    fun gethome(@HeaderMap map: Map<String?, String?>?): Call<HomeScreenModel?>?
}