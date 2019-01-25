package pl.cinemaWeb.SpringCinema.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table
public class Reservations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private User client;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "screening_id")
    private Screenings screening;

    @ElementCollection(targetClass=Ticket.class)
    private List<Ticket> tickets;

    @ElementCollection(targetClass=Integer.class)
    @Column(name ="sold_seats")
    private List<Integer> soldSeats;

    @Column(name = "buy_time", columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP")
    private Timestamp buyTime;

    public Reservations() {
    }

    public Reservations(User client, Screenings screening, List<Ticket> tickets, List<Integer> soldSeats, Timestamp buyTime) {
        this.client = client;
        this.screening = screening;
        this.tickets = tickets;
        this.soldSeats = soldSeats;
        this.buyTime = buyTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public Screenings getScreening() {
        return screening;
    }

    public void setScreening(Screenings screening) {
        this.screening = screening;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public List<Integer> getSoldSeats() {
        return soldSeats;
    }

    public void setSoldSeats(List<Integer> soldSeats) {
        this.soldSeats = soldSeats;
    }

    public Timestamp getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(Timestamp buyTime) {
        this.buyTime = buyTime;
    }

    @Override
    public String toString() {
        return "Reservations{" +
                "id=" + id +
                ", clientId=" + client.getId() +
                ", screening=" + screening +
                ", tickets=" + tickets +
                ", soldSeats=" + soldSeats +
                ", buyTime=" + buyTime +
                '}';
    }
}
