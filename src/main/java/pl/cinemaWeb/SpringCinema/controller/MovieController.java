package pl.cinemaWeb.SpringCinema.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.cinemaWeb.SpringCinema.model.Movie;
import pl.cinemaWeb.SpringCinema.model.databaseviews.ListMovie;
import pl.cinemaWeb.SpringCinema.service.FileStorageService;
import pl.cinemaWeb.SpringCinema.service.MovieService;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/dashboard")
public class MovieController {

    private static final Logger logger = LoggerFactory.getLogger(MovieController.class);
    FileStorageService fileStorageService;
    MovieService movieService;

    @Autowired
    public MovieController(FileStorageService fileStorageService, MovieService movieService) {
        this.fileStorageService = fileStorageService;
        this.movieService = movieService;
    }

    @GetMapping("/addmovie")
    public String addMovie(Model model){
        Movie movie = new Movie();
        model.addAttribute("movie", movie);
        return "dashboard/movie/addmovie";
    }

    @PostMapping("/addmovie")
    public String saveMovie(@Valid @ModelAttribute Movie movie, BindingResult bindingResult, @RequestParam("coverImage") MultipartFile file, Model model){
        if (bindingResult.hasErrors()) {
            return "dashboard/movie/addmovie";
        }
        String ext = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        String fileName = "image_" + movie.getTitle() + "_" + movie.getDirector() + "_" + movie.getReleaseDate() + ext;

        fileName = fileName.replaceAll("\\s", "-");
        fileStorageService.storeFile(file, fileName);
        String movieCover = "static/movieImages/" + fileName;
        movie.setCoverUrl(movieCover);
        Movie savedMovie = movieService.saveMovie(movie);
        model.addAttribute("success", "Film dodany do bazy.");
        model.addAttribute("movie", new Movie());
        return "dashboard/movie/addmovie";
    }

    @GetMapping("/listmovie")
    String listMovie(Model model){

        List<ListMovie> allMovies = movieService.getAllMovie();

        model.addAttribute("movies", allMovies);

        return "dashboard/movie/listmovie";
    }


    @PostMapping("/listmovie")
    String findMovie(@RequestParam("find") String title, @RequestParam("find") String director,
                     @RequestParam("find") String ageCategory, Model model){

        List<ListMovie>  getFindMovies = movieService.findMovie(title, director, ageCategory);

        model.addAttribute("movies",getFindMovies);

        return "dashboard/movie/listmovie";
    }

    @GetMapping("/{id}")
    String movie(@PathVariable(name = "id") long movieId, Model model){

        Movie movieById = movieService.getMovieById(movieId);
        model.addAttribute("movie", movieById);

        return "dashboard/movie/editmovie";
    }

    @PostMapping("/editmovie")
    String editmovie(@Valid @ModelAttribute Movie movie, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            return "dashboard/movie/editmovie";
        }

        movieService.editMovie(movie);

        return "redirect:/dashboard/listmovie";
    }

}
