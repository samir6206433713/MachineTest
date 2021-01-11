package com.tutorial.machinetest.model;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

import retrofit2.http.GET;

public interface CountriesApi {
    @GET("photos")
    Single<List<Country>> getCountries();
}
