import com.example.squadmovies.domain.entities.MovieDomainEntities

interface IClickItemMovieListener {
    fun onItemClikListener(movie: MovieDomainEntities)
}
