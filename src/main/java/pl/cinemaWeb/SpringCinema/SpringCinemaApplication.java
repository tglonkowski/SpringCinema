package pl.cinemaWeb.SpringCinema;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import pl.cinemaWeb.SpringCinema.property.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({
		FileStorageProperties.class
})
public class SpringCinemaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCinemaApplication.class, args);
	}

}