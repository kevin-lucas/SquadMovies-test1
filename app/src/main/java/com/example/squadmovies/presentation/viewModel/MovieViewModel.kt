package com.example.squadmovies.projeto.viewModel

import androidx.lifecycle.*
import com.example.squadmovies.domain.entities.Movie
import com.example.squadmovies.domain.usecase.MovieUseCase
import kotlinx.coroutines.launch
import retrofit2.HttpException

class MovieViewModel(private val movieUseCase: MovieUseCase) : ViewModel() {

    private val _listMovieMutableLiveData = MutableLiveData<List<Movie>?>()
    val listMovieLiveData: MutableLiveData<List<Movie>?> get() = _listMovieMutableLiveData

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage

    fun getMovies() {
        fun getMovies() {
            _listMovieMutableLiveData.postValue(listOf())
            try {
                viewModelScope.launch {
                    _listMovieMutableLiveData.postValue(movieUseCase.getAllMoviesRepository())
                }
            } catch (http: HttpException) {
                when {
                    http.code() == 400 -> {
                        _errorMessage.postValue("There is something wrong with your request")
                    }
                }
            }
        }

        class MovieViewModelFactory(private val movieUseCase: MovieUseCase) :
            ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return if (modelClass.isAssignableFrom(MovieViewModel::class.java)) {
                    MovieViewModel(this.movieUseCase) as T
                } else {
                    throw IllegalAccessException()
                }
            }
        }
    }
}
