package pl.cinemaWeb.SpringCinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.cinemaWeb.SpringCinema.model.CinemaRoom;
import pl.cinemaWeb.SpringCinema.model.Movie;
import pl.cinemaWeb.SpringCinema.model.Screenings;
import pl.cinemaWeb.SpringCinema.service.CinemaRoomService;
import pl.cinemaWeb.SpringCinema.service.MovieService;
import pl.cinemaWeb.SpringCinema.service.ScreeningService;

import java.sql.Date;
import java.util.*;

@Controller
@RequestMapping("/dashboard")
public class ScreeningsController{

    ScreeningService screeningService;
    MovieService movieService;
    CinemaRoomService cinemaRoomService;

    @Autowired
    public ScreeningsController(ScreeningService screeningService, MovieService movieService, CinemaRoomService cinemaRoomService) {
        this.screeningService = screeningService;
        this.movieService = movieService;
        this.cinemaRoomService = cinemaRoomService;
    }

    @GetMapping("/screenings")
    public String screenings(Model model) {

        List<Screenings> screenings = screeningService.todayScreenings();
        model.addAttribute("screenings", screenings);
        model.addAttribute("timelineDate", screeningService.today());
        return "dashboard/screenings/timeline";
    }

    @PostMapping("/screenings")
    public String showByDay(@RequestParam("timelineDate") Date timelineDate, Model model){
        List<Screenings> screenings = screeningService.screeningsByDate(timelineDate);
        model.addAttribute("screenings", screenings);
        model.addAttribute("timelineDate", timelineDate);
        return "dashboard/screenings/timeline";
    }

    @PostMapping(value = "/screenings", params = "action=add")
    public String addScreening(@RequestParam("timelineDate") Date timelineDate, Model model){
        List<Screenings> screenings = screeningService.screeningsByDate(timelineDate);
        List<String> movieTitles = movieService.getAllTitles();
        List<CinemaRoom> cinemaRooms = cinemaRoomService.getAllRooms();
        System.out.println(movieTitles);
        System.out.println(cinemaRooms);
        System.out.println(screenings);
        model.addAttribute("screenings", screenings);
        model.addAttribute("movieTitles", movieTitles);
        model.addAttribute("cinemaRooms", cinemaRooms);
        model.addAttribute("timelineDate", timelineDate);
        return "dashboard/screenings/timeline";
    }

    @PostMapping(value = "/screenings", params = "action=save")
    public String saveScreening(@RequestParam("titleLoad") String movieTitle, @RequestParam("timelineDate") Date timelineDate, @RequestParam("roomLoad") long roomID, @RequestParam("timeString") String timeString, Model model) {
        Date screeningDate = screeningService.CalendarAddTime(timelineDate, timeString);
        Screenings screening = new Screenings();
        Movie movieByTitle = movieService.movieByTitle(movieTitle);

        CinemaRoom cinemaRoom = cinemaRoomService.getRoomById(roomID);
        List<Integer> freeSeats = new ArrayList<>(cinemaRoom.getSeats());

        screening.setDate(screeningDate);
        screening.setTime(timeString);
        screening.setMovie(movieByTitle);
        screening.setDuration(movieByTitle.getDuration());
        screening.setCinemaRoom(cinemaRoom);
        screening.setDate(timelineDate);
        screening.setFreeSeats(freeSeats);
        screeningService.save(screening);
        model.addAttribute("added", "Seans dodany.");

        return showByDay(timelineDate, model);
    }

    @PostMapping(value = "/screenings", params = "action=delete")
    public String deleteScreening(@RequestParam("deleteID") long deleteID, @RequestParam("timelineDate") Date timelineDate, Model model){
        Screenings deleteScreening = screeningService.getByID(deleteID);
        if (deleteScreening.getFreeSeats().size() == deleteScreening.getCinemaRoom().getSeats().size()){
            screeningService.deleteScreeningByID(deleteID);
            model.addAttribute("deleted", "Seans usunięty.");
        } else {
            model.addAttribute("error", "Nie można usunąć seansu na który zostały sprzedane bilety!");
        }
        return showByDay(timelineDate, model);
    }
}