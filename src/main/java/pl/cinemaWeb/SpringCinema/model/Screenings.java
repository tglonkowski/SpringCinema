package pl.cinemaWeb.SpringCinema.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class Screenings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long sid;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    private int duration;
    private Date date;
    private String time;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private CinemaRoom cinemaRoom;

    @ElementCollection(targetClass=Integer.class)
    @Column(name ="free_seats")
    private List<Integer> freeSeats;

    public Screenings() {
    }

    public Screenings(Movie movie, int duration, Date date, String time, CinemaRoom cinemaRoom, List<Integer> freeSeats) {
        this.movie = movie;
        this.duration = duration;
        this.date = date;
        this.time = time;
        this.cinemaRoom = cinemaRoom;
        this.freeSeats = freeSeats;
    }

    public long getSid() {
        return sid;
    }

    public void setSid(long sid) {
        this.sid = sid;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public CinemaRoom getCinemaRoom() {
        return cinemaRoom;
    }

    public void setCinemaRoom(CinemaRoom cinemaRoom) {
        this.cinemaRoom = cinemaRoom;
    }

    public List<Integer> getFreeSeats() {
        return freeSeats;
    }

    public void setFreeSeats(List<Integer> freeSeats) {
        this.freeSeats = freeSeats;
    }

    @Override
    public String toString() {
        return "Screenings{" +
                "sid=" + sid +
                ", movie=" + movie +
                ", duration=" + duration +
                ", date=" + date +
                ", time=" + time +
                ", cinemaRoom=" + cinemaRoom +
                ", freeSeats=" + freeSeats +
                '}';
    }
}
