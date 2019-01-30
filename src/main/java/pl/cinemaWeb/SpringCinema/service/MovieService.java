package pl.cinemaWeb.SpringCinema.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.cinemaWeb.SpringCinema.model.Movie;
import pl.cinemaWeb.SpringCinema.model.databaseviews.ListMovie;
import pl.cinemaWeb.SpringCinema.repository.ListMovieRepository;
import pl.cinemaWeb.SpringCinema.repository.MovieRepository;

import java.util.List;

@Service
public class MovieService {
    MovieRepository movieRepository;
    ListMovieRepository listMovieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository, ListMovieRepository listMovieRepository) {
        this.movieRepository = movieRepository;
        this.listMovieRepository = listMovieRepository;
    }

    public void saveMovie(Movie movie){
        movieRepository.save(movie);
    }

    public List<ListMovie> getAllMovie(){

        List<ListMovie> allMovies = listMovieRepository.findAll();

        return allMovies;
    }
}
