package pl.cinemaWeb.SpringCinema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ScreeningsController{

    @GetMapping("/dashboard/screenings")
    public String screenings() {
        return "dashboard/screenings/timeline";
    }
}