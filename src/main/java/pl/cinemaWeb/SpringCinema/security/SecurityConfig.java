package pl.cinemaWeb.SpringCinema.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        PasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        auth
                .jdbcAuthentication()
                //sprawdzenie i pobranie loginu i hasła oraz czy jest aktywny użytkownika po adresie email
                //który jest loginem
                .usersByUsernameQuery("SELECT email, password, active FROM user WHERE email=?")
                //pobranie roli uzytkownika z bazy danych po podanym loginie(email)
                .authoritiesByUsernameQuery("SELECT email, role FROM user WHERE email=?")
                //ustawienie klasy odpowiedzialnej za nawiązanie połączenia do bazy danych
                .dataSource(dataSource)
                //ustawienie sposobu kodowania hasła w bazie danych
                .passwordEncoder(bCryptPasswordEncoder);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                //ponizsze linki sa dostepne tylko dla roli user i admin
                //.antMatchers("/article/*", "/article").hasAnyAuthority("user","admin")
                //ponizsze linki sa dostepne dla wszystkich zalogowanych uzytkownikow bez wzgledu na roele
                //.antMatchers("/article/*", "/article").authenticated()
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/login")//adres strony z naszym formularzem
                .defaultSuccessUrl("/")//domyślne przekierowane po poprawnym zalogowaniu
                .failureUrl("/login?error=true")//adres gdy mamy błąd logowania
                .usernameParameter("email")
                .passwordParameter("password")
                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/");
    }
}
