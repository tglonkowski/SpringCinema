package pl.cinemaWeb.SpringCinema.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import java.sql.Date;

@Table
@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "{movie.title.notempty}")
    @Column(unique = true)
    private String title;

    @Column(name = "release_date")
    private Date releaseDate;

    @NotNull(message = "{movie.duration.notempty}")
    @Column(nullable = false)
    private int duration;

    @Enumerated(EnumType.STRING)
    @Column(name = "age_category")
    private AgeCategoryEnum ageCategory;

    @NotEmpty(message = "{movie.director.notempty}")
    private String director;

    @Column(length = 1000)
    @NotEmpty(message = "{movie.description.notempty}")
    @Length(max = 1000, message = "{movie.description.max}")
    private String description;

    private String coverUrl;

    public Movie() {
    }

    public Movie(@NotEmpty(message = "{movie.title.notempty}") String title, @NotEmpty(message = "{movie.releaseDate.notempty}") Date releaseDate, @NotNull(message = "{movie.duration.notempty}") int duration, AgeCategoryEnum ageCategory, @NotEmpty(message = "{movie.director.notempty}") String director, @NotEmpty(message = "{movie.description.notempty}") String description, @NotEmpty(message = "{movie.coverUrl.notempty}") String coverUrl) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.duration = duration;
        this.ageCategory = ageCategory;
        this.director = director;
        this.description = description;
        this.coverUrl = coverUrl;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public AgeCategoryEnum getAgeCategory() {
        return ageCategory;
    }

    public void setAgeCategory(AgeCategoryEnum ageCategory) {
        this.ageCategory = ageCategory;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public int parseDuration(@Pattern(regexp = "[0-9]+", message ="{movie.duration.onlyNumbers") String minutes){
        int duration = Integer.parseInt(minutes);
        return duration;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", releaseDate=" + releaseDate +
                ", duration=" + duration +
                ", ageCategory=" + ageCategory +
                ", director='" + director + '\'' +
                ", description='" + description + '\'' +
                ", coverUrl='" + coverUrl + '\'' +
                '}';
    }
}
