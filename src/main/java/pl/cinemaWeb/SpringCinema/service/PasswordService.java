package pl.cinemaWeb.SpringCinema.service;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class PasswordService {

    private static final String SMALL_LETTERS = "qwertyuiopasdfghjklzxcvbnm";
    private static final String BIG_LETTERS = SMALL_LETTERS.toLowerCase();
    private static final String SPECIAL_SIGNS = "!@#$%^&*()_+?<>";
    private static final String NUMBERS = "123456789";

    public static int gNumberRange(int from, int to){
        return new Random().nextInt(to - from + 1) + from;
    }


    public static String gPasswd(int lenght){
        String result = "";
        String allStrings = SMALL_LETTERS + BIG_LETTERS + SPECIAL_SIGNS + NUMBERS;
        for(int i = 0; i < length; i++){
            result  += allStrings.charAt(gNumberRange(0, allStrings.length()-1));
        }
        return result;
    }
}
