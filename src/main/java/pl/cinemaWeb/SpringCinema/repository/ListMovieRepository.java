package pl.cinemaWeb.SpringCinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.cinemaWeb.SpringCinema.model.Movie;
import pl.cinemaWeb.SpringCinema.model.databaseviews.ListMovie;

import java.util.List;

public interface ListMovieRepository extends JpaRepository<ListMovie, Long> {

    List<ListMovie> getMoviesByTitleContainingOrDirectorContainingOrAgeCategoryContaining(String title, String director, String ageCategory);
}
 