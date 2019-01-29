package pl.cinemaWeb.SpringCinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.cinemaWeb.SpringCinema.model.databaseviews.ListMovie;

public interface ListMovieRepository extends JpaRepository<ListMovie, Long> {
}
