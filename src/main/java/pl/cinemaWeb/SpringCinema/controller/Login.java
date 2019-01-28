package pl.cinemaWeb.SpringCinema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Login {

    @GetMapping("/login")
    public String login(){
        return "dashboard/login";
    }
}
