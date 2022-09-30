package com.example.squadmovies.usecase

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.squadmovies.projeto.model.MovieResponse
import com.example.squadmovies.respository.MovieRepository
import retrofit2.awaitResponse

class MovieUseCase(private val movieRepository: MovieRepository) {

    suspend fun getAllMovies(mutableLiveData: MutableLiveData<List<MovieResponse>?>) {
        movieRepository.getList().awaitResponse()?.let { response ->
            if (response.isSuccessful) {
                if (response.body()?.statusResponse == "False") {
                    Log.i("Script", response.body().toString())
                    response.body()!!.errorMessage
                } else {
                    response.body()?.movies
                }
            }
        }
    }
}
/*
            suspend fun getMoviesByTitle(title: String) {
                if (title.length < 3) {
                    val resultByTitle = movieRepository.getTitle(title).awaitResponse()
                    resultByTitle?.let { response ->
                        if (response.isSuccessful) {
                            if (response.body()?.statusResponse == "False") {
                                response.body()?.errorMessage
                            }
                            run { ->
                                (resultByTitle.body()?.movies)
                            }
                        }
                    }
                }
            }
        }
    }
}
*/
/*  override fun onFailure(call: Call<SearchMovieResponse>, t: Throwable) {
}
})
} else {
    // _errorMessage.postValue("Infome no minímo 3 letras para pesquisar")
}
}
}*/
