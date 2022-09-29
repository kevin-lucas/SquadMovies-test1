package com.example.squadmovies.projeto.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.squadmovies.projeto.model.MovieDetailsResponse
import com.example.squadmovies.projeto.model.MovieResponse
import com.example.squadmovies.projeto.model.SearchMovieResponse
import com.example.squadmovies.projeto.network.RetrofitService
import retrofit2.Call
import retrofit2.Response


class MovieDetailsViewModel : ViewModel() {

    val retrofitService = RetrofitService.getBaseUrl()

    private val _listMovieMutableLiveData = MutableLiveData<List<MovieResponse>>()
    val listMovieLiveData: LiveData<List<MovieResponse>> get() = _listMovieMutableLiveData

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage

    fun getDetailsMovies() {
        retrofitService.getListDetailsMovies().enqueue(object : retrofit2.Callback<MovieResponse> {
            override fun onResponse(
                call: Call<MovieResponse>,
                response: Response<MovieResponse>
            ) {
                if (response.isSuccessful) {
                    if (response.body()?.statusResponse == "False") {
                        Log.i("Script", response.body().toString())
                        _errorMessage.postValue(response.body()?.errorMessage)
                    } else {
                        _listMovieMutableLiveData.postValue(response.body()?.movies)
                    }
                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.i("Script", t.message.toString())
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
                        if (response.body()?.statusResponse == "False") {
                            _errorMessage.postValue(response.body()?.errorMessage)
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
