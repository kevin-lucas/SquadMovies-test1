package com.example.squadmovies.projeto.viewModel

import androidx.lifecycle.*
import com.example.squadmovies.domain.usecase.MovieUseCase
import com.example.squadmovies.projeto.model.MovieResponse

class MovieDetailsViewModel(private val movieUseCase: MovieUseCase) : ViewModel() {

    private val _listMovieMutableLiveData = MutableLiveData<List<MovieResponse>?>()
    val listMovieLiveData: MutableLiveData<List<MovieResponse>?> get() = _listMovieMutableLiveData

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage

    fun getMovie(imdbID: String) {
        val movies = listOf(
            MovieResponse(
                "Everything Everywhere All at Once",
                "2021",
                "https://m.media-amazon.com/images/M/MV5BYTdiOTIyZTQtNmQ1OS00NjZlLWIyMTgtYzk5Y2M3ZDVmMDk1XkEyXkFqcGdeQXVyMTAzMDg4NzU0._V1_SX300.jpg",
                "Plot",
                "English",
                "imdbID"
            ),
            MovieResponse(
                "e",
                "2021",
                "https://m.media-amazon.com/images/M/MV5BYTdiOTIyZTQtNmQ1OS00NjZlLWIyMTgtYzk5Y2M3ZDVmMDk1XkEyXkFqcGdeQXVyMTAzMDg4NzU0._V1_SX300.jpg",
                "Plot",
                "English",
                "imdbID"
            ),
            MovieResponse(
                "be",
                "2021",
                "https://m.media-amazon.com/images/M/MV5BYTdiOTIyZTQtNmQ1OS00NjZlLWIyMTgtYzk5Y2M3ZDVmMDk1XkEyXkFqcGdeQXVyMTAzMDg4NzU0._V1_SX300.jpg",
                "Plot",
                "English",
                "imdbID"
            )
        )

        _listMovieMutableLiveData.postValue(movies)
    }

    class MovieViewModelFactory(private val movieUseCase: MovieUseCase) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return if (modelClass.isAssignableFrom(MovieDetailsViewModel::class.java)) {
                MovieDetailsViewModel(this.movieUseCase) as T
            } else {
                throw IllegalAccessException()
            }
        }
    }
}
