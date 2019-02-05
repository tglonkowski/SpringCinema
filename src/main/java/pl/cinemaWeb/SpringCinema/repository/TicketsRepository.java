package pl.cinemaWeb.SpringCinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.cinemaWeb.SpringCinema.model.Ticket;

public interface TicketsRepository extends JpaRepository<Ticket, Long> {

    public Ticket getTicketById(Long id);
}
