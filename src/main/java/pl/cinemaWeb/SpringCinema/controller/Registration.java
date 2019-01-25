package pl.cinemaWeb.SpringCinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.cinemaWeb.SpringCinema.model.RoleEnum;
import pl.cinemaWeb.SpringCinema.model.User;
import pl.cinemaWeb.SpringCinema.service.UserService;

@Controller
public class Registration {

    UserService userService;

    @Autowired
    public Registration(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String registration(Model model){
        User user = new User();
        model.addAttribute("user", user);

        return "dashboard/register";
    }

    @PostMapping("/register")
    public String addNewUser(@ModelAttribute User user){

        user.setActive(Boolean.TRUE);
        user.setRole(RoleEnum.Administrator);

        userService.saveUser(user);

        return "home";

    }
}
