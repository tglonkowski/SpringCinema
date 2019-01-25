package pl.cinemaWeb.SpringCinema.model;

import javax.persistence.*;
import java.util.List;

@Table(name = "cinema_room")
@Entity
public class CinemaRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @ElementCollection(targetClass=Integer.class)
    private List<Integer> seats;

    public CinemaRoom() {
    }

    public CinemaRoom(String name, List<Integer> seats) {
        this.name = name;
        this.seats = seats;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getSeats() {
        return seats;
    }

    public void setSeats(List<Integer> seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "CinemaRoom{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", seats=" + seats +
                '}';
    }
}
