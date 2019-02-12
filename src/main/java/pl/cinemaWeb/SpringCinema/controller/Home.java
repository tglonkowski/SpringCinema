package pl.cinemaWeb.SpringCinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.cinemaWeb.SpringCinema.model.RoleEnum;
import pl.cinemaWeb.SpringCinema.model.User;
import pl.cinemaWeb.SpringCinema.service.MailService;
import pl.cinemaWeb.SpringCinema.service.PasswordService;
import pl.cinemaWeb.SpringCinema.service.UserService;

import java.util.Random;

@Controller
public class Home {

    UserService userService;

    @Autowired
    public Home(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String home(){
        return "home";
    }

}
