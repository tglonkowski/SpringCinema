package pl.cinemaWeb.SpringCinema.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.cinemaWeb.SpringCinema.model.Screenings;
import pl.cinemaWeb.SpringCinema.repository.ScreeningRepository;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

@Service
public class ScreeningService {

    ScreeningRepository screeningRepository;

    @Autowired
    public ScreeningService(ScreeningRepository screeningRepository) {
        this.screeningRepository = screeningRepository;
    }


    public List<Screenings> screeningsByDate(Date date){

        List<Screenings> screeningsByDate = screeningRepository.getScreeningsByDate(date);

        return screeningsByDate;
    }

    public List<Screenings> todayScreenings(){
        return screeningRepository.getTodayScreenings();
    }

    public Date today(){
        return screeningRepository.currentDate();
    }

    public void save(Screenings screening){
        screeningRepository.save(screening);
    }

    public Date CalendarAddTime(Date date, String timeString){
        String timeTable[] = timeString.split(":");
        Calendar calcTime =  Calendar.getInstance();
        calcTime.setTime(date);
        calcTime.set(Calendar.HOUR, Integer.parseInt(timeTable[0]));
        calcTime.set(Calendar.MINUTE, Integer.parseInt(timeTable[1]));
        calcTime.set(Calendar.SECOND, 0);
        Date finalDate = new Date(calcTime.getTimeInMillis());
        return finalDate;
    }
}
