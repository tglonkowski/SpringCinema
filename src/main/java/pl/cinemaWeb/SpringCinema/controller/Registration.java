package pl.cinemaWeb.SpringCinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.cinemaWeb.SpringCinema.model.User;
import pl.cinemaWeb.SpringCinema.service.MailService;
import pl.cinemaWeb.SpringCinema.service.PasswordService;
import pl.cinemaWeb.SpringCinema.service.UserService;

@Controller
public class Registration {

    UserService userService;
    MailService mailService;
    PasswordService passwordService;

    @Autowired
    public Registration(UserService userService, MailService mailService, PasswordService passwordService) {
        this.userService = userService;
        this.mailService = mailService;
        this.passwordService = passwordService;
    }

    @GetMapping("/register")
    public String registration(Model model){
        User user = new User();
        model.addAttribute("user", user);

        return "dashboard/register";
    }

    @PostMapping("/register")
    public String addNewUser(@ModelAttribute User user,
                             @RequestParam("confirmPassword") String confirmPassword, Model model){
        if(confirmPassword.equals(user.getPassword())){
            userService.saveUser(user);

            return "home";
        } else {
            model.addAttribute("passwdMismatch",true);
            return "dashboard/register";
        }
    }

    @GetMapping("/forgotpassword")
    public String forgotPassword(){
        return "dashboard/forgotpassword";
    }

    @PostMapping("/forgotpassword")
    public String getNewPassword(@RequestParam(value = "email") String email, Model model){
        User userByEmail = userService.getUserByEmail(email);
        String temporaryPassword = PasswordService.gPasswd(10);
        userService.saveUserByTemporaryPassword(userByEmail, temporaryPassword);
        mailService.sendMessage(userByEmail, email, temporaryPassword);
        model.addAttribute("reminder","Udało Ci się! Sprawdź skrzynkę pocztową.");
        return "dashboard/login";
    }

}
