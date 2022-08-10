package com.auliamnaufal.dictionariesapi

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.auliamnaufal.dictionariesapi.data.DictionaryResponseItem
import com.auliamnaufal.dictionariesapi.network.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel: ViewModel() {
    val data = MutableLiveData<List<DictionaryResponseItem>>()

    fun getApiSearch(query: String?) {
        if (query != null) {
            ApiConfig.getApiService().searchWord(query).enqueue(object : Callback<List<DictionaryResponseItem>> {
                override fun onResponse(
                    call: Call<List<DictionaryResponseItem>>,
                    response: Response<List<DictionaryResponseItem>>
                ) {
                    data.value = response.body()
                }

                override fun onFailure(call: Call<List<DictionaryResponseItem>>, t: Throwable) {
                    Log.e("MainViewModel", "onFailure: $t", )
                }

            })
        }
    }
}