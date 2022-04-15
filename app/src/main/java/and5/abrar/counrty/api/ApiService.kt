package and5.abrar.counrty.api

import and5.abrar.counrty.model.Currency
import and5.abrar.counrty.model.GetCountryItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("all")
    fun getAllDuit(): Call<List<Currency>>
    @GET("all")
    fun getAllCountry(): Call<List<GetCountryItem>>
}