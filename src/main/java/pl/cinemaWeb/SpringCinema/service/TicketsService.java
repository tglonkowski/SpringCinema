package pl.cinemaWeb.SpringCinema.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.cinemaWeb.SpringCinema.model.Ticket;
import pl.cinemaWeb.SpringCinema.repository.TicketsRepository;

import java.util.List;

@Service
public class TicketsService {

    TicketsRepository ticketsRepository;

    @Autowired
    public TicketsService(TicketsRepository ticketsRepository) {
        this.ticketsRepository = ticketsRepository;
    }

    public List<Ticket> getTicketsList(){
        List<Ticket> ticketList = ticketsRepository.findAll();
        return ticketList;
    }

    public Ticket saveTicket(Ticket ticket){
        Ticket newTicket = ticketsRepository.save(ticket);
        return newTicket;
    }

    public Ticket getTicketById(Long idTicket){
        Ticket ticketById = ticketsRepository.getTicketById(idTicket);
        return ticketById;

    }
}
