package pl.cinemaWeb.SpringCinema.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
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
        PasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        userRepository.save(user);

    }



    public void showPassword(String email){

        PasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        User user = userRepository.getUsersByEmail(email);

        if (user.getPassword() == bCryptPasswordEncoder.encode("hp")){
            System.out.println("DZIAŁA");
        }else{
            System.out.println("NIE DZIAŁA");
        }
    }
}
