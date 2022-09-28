package com.example.squadmovies.adapter.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.example.squadmovies.adapter.model.MovieResponse
import com.example.squadmovies.adapter.model.SearchMovieResponse
import com.example.squadmovies.adapter.network.RetrofitService

import retrofit2.Call
import retrofit2.Response

class MovieViewModel() : ViewModel() {
    val retrofitService = RetrofitService.getBaseUrl()

    private val _listMovieMutableLiveData = MutableLiveData<List<MovieResponse>>()
    val listMovieLiveData: LiveData<List<MovieResponse>> get() = _listMovieMutableLiveData

    private val _erroMessage = MutableLiveData<String>()
    val erroMessage: LiveData<String> get() = _erroMessage

    fun getAllMovies() {
        retrofitService.getListMovies().enqueue(object : retrofit2.Callback<MovieResponse> {

            override fun onResponse(
                call: Call<MovieResponse>,
                response: Response<MovieResponse>
            ) {
                if (response.isSuccessful){
                   if (response.code() != 200 ){
                       Log.i("Script",response.body().toString())
                       _erroMessage.postValue(response.body()?.movies.toString())

                    }
                }else{
                    _listMovieMutableLiveData.postValue(response.body()?.movies)
                }

            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.i("Scritp",t.message.toString())
            }
        })
    }

    fun getMoviesByTitle(title: String) {
        if (title.length > 3) {
            retrofitService.searchMovieByName(title = title).enqueue(object : retrofit2.Callback<SearchMovieResponse> {
                override fun onResponse(
                    call: Call<SearchMovieResponse>,
                    response: Response<SearchMovieResponse>
                ) {
                    if (response.isSuccessful) {
                        if (response.code() != 200) { _erroMessage.postValue(response.body()?.movies.toString())
                        } else {
                            _listMovieMutableLiveData.postValue(response.body()?.movies)
                        }
                    }
                }

                override fun onFailure(call: Call<SearchMovieResponse>, t: Throwable) {
                }
            })
        } else {
            // _errorMessage.postValue("Infome no minímo 3 letras para pesquisar")
        }
    }
}


