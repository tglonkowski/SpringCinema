package pl.cinemaWeb.SpringCinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.cinemaWeb.SpringCinema.model.Movie;
import pl.cinemaWeb.SpringCinema.model.RoleEnum;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    Movie getMovieById(long movieId);
    Movie getMovieByTitle(String title);
}
