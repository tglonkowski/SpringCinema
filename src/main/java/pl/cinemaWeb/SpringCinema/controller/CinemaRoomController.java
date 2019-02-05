package pl.cinemaWeb.SpringCinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.cinemaWeb.SpringCinema.model.CinemaRoom;
import pl.cinemaWeb.SpringCinema.service.CinemaRoomService;

import javax.websocket.server.PathParam;
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

    @GetMapping(value = "/cinemaroom", params = "action=add")
    public String addRoom(Model model){
        int newSeatsCount;
        model.addAttribute("newRoom", new CinemaRoom());
        List<CinemaRoom> roomList = cinemaRoomService.getAllRooms();
        model.addAttribute("allRooms", roomList);
        return "dashboard/cinemaroom/rooms";
    }

    @PostMapping("/cinemaroom")
    public String saveRoom(@ModelAttribute CinemaRoom cinemaRoom, @RequestParam("newSeatCount") int newSeatCount, Model model){
        cinemaRoomService.saveRoom(cinemaRoom, newSeatCount);
        model.addAttribute("added","Sala dodana :)");
        return roomsList(model);
    }

    @GetMapping("/cinemaroom/editRoom{id}")
    public String editRoom(@PathVariable("id") Long id, Model model){
        CinemaRoom editRoom = cinemaRoomService.getRoomById(id);
        model.addAttribute("editRoom", editRoom);
        model.addAttribute("newSeatCount", editRoom.getSeats().size());
        return "dashboard/cinemaroom/editRoom";
    }

    @PostMapping("/cinemaroom/editRoom")
    public String saveEditedRoom(@ModelAttribute CinemaRoom cinemaRoom, @RequestParam("newSeatCount") int newSeatCount, Model model){
        cinemaRoomService.saveRoom(cinemaRoom, newSeatCount);
        model.addAttribute("edited","Sala zmieniona :)");
        return roomsList(model);
    }
}
