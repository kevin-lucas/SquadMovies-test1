package com.example.squadmovies.projeto.viewModel

import androidx.lifecycle.*
import com.example.squadmovies.domain.entities.MovieDomainEntities
import com.example.squadmovies.domain.usecase.MovieByTitleUseCase
import com.example.squadmovies.domain.usecase.IAllMovieUseCase
import kotlinx.coroutines.launch
import retrofit2.HttpException

class MovieListViewModel(
    private val movieUseCase: IAllMovieUseCase,
    private val movieTitleUseCase:
        MovieByTitleUseCase
) :
    ViewModel() {

    private val _listMovieMutableLiveData = MutableLiveData<List<MovieDomainEntities>?>()
    val listMovieLiveData: MutableLiveData<List<MovieDomainEntities>?> get() = _listMovieMutableLiveData

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage

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
    fun getTitle(title: String) {
        _listMovieMutableLiveData.postValue(listOf())
        try {
            viewModelScope.launch {
                _listMovieMutableLiveData.postValue(movieTitleUseCase.getMovieByTitleRepository(title))
            }
        } catch (http: HttpException) {
            when {
                http.code() == 400 -> {
                    _errorMessage.postValue("There is something wrong with your request")
                }
            }
        }
    }

    class MovieViewModelFactory(
        private val movieUseCase: IAllMovieUseCase,
        private val movieTitleUseCase:
            MovieByTitleUseCase
    ) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return if (modelClass.isAssignableFrom(MovieListViewModel::class.java)) {
                MovieListViewModel(this.movieUseCase, movieTitleUseCase) as T
            } else {
                throw IllegalAccessException()
            }
        }
    }
}
