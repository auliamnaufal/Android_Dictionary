package com.auliamnaufal.dictionariesapi.network

import com.auliamnaufal.dictionariesapi.data.DictionaryResponseItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("en/{word}")
    fun searchWord(
        @Path("word") word: String
    ) : Call<List<DictionaryResponseItem>>
}