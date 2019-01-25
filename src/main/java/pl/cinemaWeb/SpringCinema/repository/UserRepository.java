package pl.cinemaWeb.SpringCinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.cinemaWeb.SpringCinema.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User getUsersByEmail(String email);
}
