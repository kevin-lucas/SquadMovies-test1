package com.example.squadmovies.view.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.squadmovies.view.network.RetrofitService
import retrofit2.Call
import retrofit2.Response

class MovieDetailsViewModel : ViewModel() {
    val retrofitService = RetrofitService.getBaseUrl()

    private val _listMovieMutableLiveData = MutableLiveData<List<MovieDetailsViewModel>>()
    val listMovieLiveData: LiveData<List<MovieDetailsViewModel>> get() = _listMovieMutableLiveData

    private val _erroMessage = MutableLiveData<String>()
    val erroMessage: LiveData<String> get() = _erroMessage

    fun getDetailsVieModel() {
        retrofitService.getListDetailsMovies().enqueue(object : retrofit2.Callback<MovieDetailsViewModel> {
            override fun onResponse(
                call: Call<MovieDetailsViewModel>,
                response: Response<MovieDetailsViewModel>
            ) {
                if (response.isSuccessful) {
                    if (response.code() != 200) {
                        Log.i("Script", response.body().toString())
                        _erroMessage.postValue(response.body()?.toString())
                    }
                } else {
                }
            }
            override fun onFailure(call: Call<MovieDetailsViewModel>, t: Throwable) {
                Log.i("Scritp", t.message.toString())
            }
        })
    }
}
