package pl.cinemaWeb.SpringCinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.cinemaWeb.SpringCinema.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
