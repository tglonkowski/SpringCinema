package pl.cinemaWeb.SpringCinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.cinemaWeb.SpringCinema.model.Screenings;

import java.sql.Date;
import java.util.List;

@Repository
public interface ScreeningRepository extends JpaRepository<Screenings, Long> {
    List<Screenings> getScreeningsByDate(Date date);

    @Query("SELECT s FROM Screenings s WHERE s.date=CURRENT_DATE")
    List<Screenings> getTodayScreenings();

    @Query(value = "SELECT CURRENT_DATE", nativeQuery = true)
    Date currentDate();
}
