package pl.cinemaWeb.SpringCinema.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.cinemaWeb.SpringCinema.model.Movie;
import pl.cinemaWeb.SpringCinema.model.databaseviews.ListMovie;
import pl.cinemaWeb.SpringCinema.repository.ListMovieRepository;
import pl.cinemaWeb.SpringCinema.repository.MovieRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    MovieRepository movieRepository;
    ListMovieRepository listMovieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository, ListMovieRepository listMovieRepository) {
        this.movieRepository = movieRepository;
        this.listMovieRepository = listMovieRepository;
    }

    public Movie saveMovie(Movie movie){
        return movieRepository.save(movie);
    }

    public List<ListMovie> getAllMovie(){

        List<ListMovie> allMovies = listMovieRepository.findAll();

        return allMovies;
    }

    public Movie getMovieById(long movieId){
        Optional<Movie> optionalMovie = movieRepository.findById(movieId);

        if (optionalMovie.isPresent()) {
            return optionalMovie.get();
        }

        return null;

    }

    public Movie editMovie(Movie movie){


        Movie movieFromDB = getMovieById(movie.getId());

        movie.setCoverUrl(movieFromDB.getCoverUrl());
        movie.setCoverUrl(movieFromDB.getCoverUrl());

        Movie editMovie = movieRepository.save(movie);

        return editMovie;
    }

    public List<ListMovie> findMovie(String title, String director, String ageCategory){

        List<ListMovie> movieFind = listMovieRepository.getMoviesByTitleContainingOrDirectorContainingOrAgeCategoryContaining(title, director, ageCategory);

        return movieFind;
    }
}
