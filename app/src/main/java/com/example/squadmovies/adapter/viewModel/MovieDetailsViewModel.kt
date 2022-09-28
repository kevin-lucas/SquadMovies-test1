package com.example.squadmovies.adapter.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.squadmovies.adapter.model.MovieDetailsResponse
import com.example.squadmovies.adapter.network.RetrofitService
import retrofit2.Call
import retrofit2.Response


class MovieDetailsViewModel : ViewModel() {
    val retrofitService = RetrofitService.getBaseUrl()

    private val _listMovieMutableLiveData = MutableLiveData<List<MovieDetailsResponse>>()
    val listMovieLiveData: LiveData<List<MovieDetailsResponse>> get() = _listMovieMutableLiveData

    private val _erroMessage = MutableLiveData<String>()
    val erroMessage: LiveData<String> get() = _erroMessage

    fun getDetailsVieModel() {
        retrofitService.getListDetailsMovies().enqueue(object : retrofit2.Callback<MovieDetailsResponse> {
            override fun onResponse(
                call: Call<MovieDetailsResponse>,
                response: Response<MovieDetailsResponse>
            ) {
                if (response.isSuccessful) {
                    if (response.code() != 200) {
                        Log.i("Script", response.body().toString())
                        _erroMessage.postValue(response.body()?.toString())
                    }
                } else {
                }
            }
            override fun onFailure(call: Call<MovieDetailsResponse>, t: Throwable) {
                Log.i("Scritp", t.message.toString())
            }
        })
    }
}
