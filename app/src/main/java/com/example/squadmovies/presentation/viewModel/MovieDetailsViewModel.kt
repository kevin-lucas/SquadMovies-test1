package com.example.squadmovies.presentation.viewModel

import androidx.lifecycle.*
import com.example.squadmovies.data.dao.MovieEntity
import com.example.squadmovies.domain.interactor.IMovieGetIdUseCase
import kotlinx.coroutines.launch
import retrofit2.HttpException

class MovieDetailsViewModel(
    private val iMovieGetIdUseCase:
        IMovieGetIdUseCase
) : ViewModel() {

    private val _movieLiveData = MutableLiveData<MovieEntity?>()
    val movieLiveData: MutableLiveData<MovieEntity?> get() = _movieLiveData

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage

    fun getResultDetailsMovie(imdbID: String) {
        try {
            viewModelScope.launch {
                _movieLiveData.postValue(iMovieGetIdUseCase.getIdMovie(imdbID))
            }
        } catch (http: HttpException) {
            when {
                http.code() == 400 -> {
                    _errorMessage.postValue("There is something wrong with your request")
                }
            }
        }
    }

    class MovieDetailsViewModelFactory(
        private val iMovieGetIdUseCase: IMovieGetIdUseCase

    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return if (modelClass.isAssignableFrom(MovieDetailsViewModel::class.java)) {
                return MovieDetailsViewModel(this.iMovieGetIdUseCase) as T
            } else {
                throw IllegalAccessException()
            }
        }
    }
}
