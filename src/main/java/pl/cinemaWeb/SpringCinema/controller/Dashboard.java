package pl.cinemaWeb.SpringCinema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.cinemaWeb.SpringCinema.model.AgeCategoryEnum;
import pl.cinemaWeb.SpringCinema.model.Movie;

import java.util.Arrays;
import java.util.List;

@Controller
public class Dashboard {

    @GetMapping("/dashboard")
    public String dashboard(){
        return "dashboard/index";
    }

    @GetMapping("/dashboard/addmovie")
    public String addMovie(Model model){
        Movie movie = new Movie();
        model.addAttribute("movie", movie);
        return "dashboard/addmovie";
    }

    @PostMapping("/dashboard/addmovie")
    public String saveMovie(@ModelAttribute Movie movie, BindingResult bindingResult, Model model){
        return "dashboard/addmovie";
    }
}
