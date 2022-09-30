package com.example.squadmovies.projeto.viewModel

import androidx.lifecycle.*
import com.bumptech.glide.load.HttpException
import com.example.squadmovies.projeto.model.MovieResponse
import com.example.squadmovies.usecase.MovieUseCase
import kotlinx.coroutines.launch

class MovieViewModel(private val movieUseCase: MovieUseCase) : ViewModel() {

    private val _listMovieMutableLiveData = MutableLiveData<List<MovieResponse>?>()
    val listMovieLiveData: MutableLiveData<List<MovieResponse>?> get() = _listMovieMutableLiveData

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage

    fun getMovies() {
        try {
            viewModelScope.launch {
                listMovieLiveData?.let {
                    (movieUseCase.getAllMovies(it))
                }
            }
        } catch (http: HttpException) {
            when {
                http.statusCode == 400 -> {
                    _errorMessage.postValue("There is something wrong with your request")
                }
            }
        }
    }
    class MovieViewModelFactory(private val movieUseCase: MovieUseCase) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return if (modelClass.isAssignableFrom(MovieViewModel::class.java)) {
                MovieViewModel(this.movieUseCase) as T
            } else {
                throw IllegalAccessException()
            }
        }
    }
}
