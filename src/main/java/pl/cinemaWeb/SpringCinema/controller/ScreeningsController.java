package pl.cinemaWeb.SpringCinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.cinemaWeb.SpringCinema.model.Screenings;
import pl.cinemaWeb.SpringCinema.service.ScreeningService;
import pl.cinemaWeb.SpringCinema.service.UtilitiesService;

import java.sql.Date;
import java.util.List;

@Controller
public class ScreeningsController{

    ScreeningService screeningService;
    UtilitiesService utilitiesService;

    @Autowired
    public ScreeningsController(ScreeningService screeningService, UtilitiesService utilitiesService) {
        this.screeningService = screeningService;
        this.utilitiesService = utilitiesService;
    }

    @GetMapping("/dashboard/screenings")
    public String screenings(Model model) {

        List<Screenings> screenings = screeningService.todayScreenings();
        model.addAttribute("screenings", screenings);
        model.addAttribute("timelineDate", screeningService.today());
        return "dashboard/screenings/timeline";
    }

    @PostMapping("/dashborad/screenings")
    public String showDay(@RequestParam("timelineDate") Date date, Model model){

        return "dashboard/screenings/timeline";
    }
}