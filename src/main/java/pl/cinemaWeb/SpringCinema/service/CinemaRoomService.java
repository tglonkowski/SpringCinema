package pl.cinemaWeb.SpringCinema.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.cinemaWeb.SpringCinema.model.CinemaRoom;
import pl.cinemaWeb.SpringCinema.repository.CinemaRoomRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CinemaRoomService {

    CinemaRoomRepository cinemaRoomRepository;

    @Autowired
    public CinemaRoomService(CinemaRoomRepository cinemaRoomRepository) {
        this.cinemaRoomRepository = cinemaRoomRepository;
    }

    public void saveRoom(CinemaRoom cinemaRoom, int seatCount){
        List<Integer> seatList = new ArrayList<>();
        for(int i = 1; i<=seatCount; i++){
            seatList.add(i);
        }
        cinemaRoom.setSeats(seatList);
        cinemaRoomRepository.save(cinemaRoom);
    }

    public List<CinemaRoom> getAllRooms(){
        List<CinemaRoom> roomList = cinemaRoomRepository.findAll();
        return roomList;
    }
}
