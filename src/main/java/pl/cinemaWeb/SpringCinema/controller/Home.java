package pl.cinemaWeb.SpringCinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.cinemaWeb.SpringCinema.service.UserService;

@Controller
public class Home {

    UserService userService;

    @Autowired
    public Home(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String home(){

        userService.showPassword("t@kropki.pl");

        return "home";
    }
}
