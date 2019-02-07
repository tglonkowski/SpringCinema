package pl.cinemaWeb.SpringCinema.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import pl.cinemaWeb.SpringCinema.model.User;


@Component
public class MailService {

    private static final String SUBJECT = "Przypomnienie hasła";
    private static final String MESSAGE = "Twoje hasło to: ";

    @Autowired
    public JavaMailSender mailSender;

    public void sendMessage(User user, String email, String newPassword){

        System.out.println("Send message: " + user.toString());
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject(SUBJECT);
        message.setText(MESSAGE + newPassword);

        try {
            mailSender.send(message);
        }catch (MailException e){
            e.printStackTrace();
        }
    }


}
