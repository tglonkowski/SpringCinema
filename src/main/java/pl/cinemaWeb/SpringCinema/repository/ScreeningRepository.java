package pl.cinemaWeb.SpringCinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.cinemaWeb.SpringCinema.model.Screenings;

import java.util.Date;
import java.util.List;

public interface ScreeningRepository extends JpaRepository<Screenings, Long> {
    List<Screenings> getScreeningsByDate(Date date);
}
