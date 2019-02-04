package pl.cinemaWeb.SpringCinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.cinemaWeb.SpringCinema.model.CinemaRoom;
import pl.cinemaWeb.SpringCinema.service.CinemaRoomService;

import java.util.List;

@Controller
@RequestMapping("/dashboard")
public class CinemaRoomController {

    CinemaRoomService cinemaRoomService;

    @Autowired
    public CinemaRoomController(CinemaRoomService cinemaRoomService) {
        this.cinemaRoomService = cinemaRoomService;
    }

    @GetMapping("/cinemaroom")
    public String roomsList(Model model){
        List<CinemaRoom> roomList = cinemaRoomService.getAllRooms();
        model.addAttribute("allRooms", roomList);
        return "dashboard/cinemaroom/rooms";
    }

    @GetMapping("/cinemaroom/addroom")
    public String addRoom(Model model){
        model.addAttribute("cinemaRoom", new CinemaRoom());
        return "dashboard/cinemaroom/addroom";
    }

    @PostMapping("/cinemaroom/addroom")
    public String saveRoom(@ModelAttribute CinemaRoom cinemaRoom, @RequestParam("seatCount") int seatCount, Model model){
        cinemaRoomService.saveRoom(cinemaRoom, seatCount);
        return "redirect:/dashboard/cinemaroom/rooms";
    }



}
