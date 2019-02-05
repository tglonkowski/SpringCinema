package pl.cinemaWeb.SpringCinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.cinemaWeb.SpringCinema.model.Ticket;
import pl.cinemaWeb.SpringCinema.service.TicketsService;

import java.util.List;

@Controller
public class TicketsController {

    TicketsService ticketsService;

    @Autowired
    public TicketsController(TicketsService ticketsService) {
        this.ticketsService = ticketsService;
    }

    @GetMapping("/dashboard/tickets")
    public String ticketsList(Model model){
        List<Ticket> ticketsList = ticketsService.getTicketsList();
        model.addAttribute("allTickets", ticketsList);
        return "dashboard/ticket/tickets";
    }

    @GetMapping(value = "/dashboard/tickets", params = "action=add")
    public String addTicket(Model model){
        model.addAttribute("newTicket", new Ticket());
        List<Ticket> ticketsList = ticketsService.getTicketsList();
        model.addAttribute("allTickets", ticketsList);
        return "dashboard/ticket/tickets";
    }

    @PostMapping("/dashboard/tickets")
    public String saveTicket(@ModelAttribute Ticket ticket, Model model){
        ticketsService.saveTicket(ticket);
        model.addAttribute("added", "Bilet dodany!");
        return ticketsList(model);
    }

    @GetMapping("/dashboard/tickets/editTicket{id}")
    public String editTicket(@PathVariable(name = "id") Long idTicket, Model model){
        Ticket ticketById = ticketsService.getTicketById(idTicket);
        model.addAttribute("editTicket", ticketById);
        return "dashboard/ticket/editTicket";
    }

    @PostMapping("/dashboard/tickets/editTicket")
    public String saveEditedTicket(@ModelAttribute Ticket ticket, Model model){
        ticketsService.saveTicket(ticket);
        model.addAttribute("edited", "Bilet zmieniony!");
        return ticketsList(model);
    }



}
