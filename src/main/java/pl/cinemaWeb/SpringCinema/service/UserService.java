package pl.cinemaWeb.SpringCinema.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.cinemaWeb.SpringCinema.model.RoleEnum;
import pl.cinemaWeb.SpringCinema.model.User;
import pl.cinemaWeb.SpringCinema.repository.UserRepository;

@Service
public class UserService {

    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(User user){
        user.setActive(Boolean.TRUE);
        user.setRole(RoleEnum.Administrator);

        PasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        userRepository.save(user);

    }

    public User getUserByEmail(String email){
        User userByEmail = userRepository.getUserByEmail(email);
        return userByEmail;
    }

    public void saveUserByTemporaryPassword(User user, String temporaryPassword){
        System.out.println("Zapisywanie tymczasowego hasła do bazy!");

        PasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setPassword(bCryptPasswordEncoder.encode(temporaryPassword));

        userRepository.save(user);

    }
}
