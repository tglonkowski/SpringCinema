package pl.cinemaWeb.SpringCinema.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
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

    @NotEmpty(message = "{movie.releaseDate.notempty}")
    @Column(name = "release_date")
    private Date releaseDate;

    @NotEmpty(message = "{movie.duration.notempty}")
    @Column(nullable = false)
    private int duration;

    @NotEmpty(message = "{movie.ageCategory.notempty}")
    @Enumerated(EnumType.STRING)
    @Column(name = "age_category")
    private AgeCategoryEnum ageCategory;

    @NotEmpty(message = "{movie.director.notempty}")
    private String director;

    @NotEmpty(message = "{movie.description.notempty}")
    private String description;

    @NotEmpty(message = "{movie.imageUrl.notempty}")
    @Column(name = "image_url")
    private String imageUrl;

    public Movie() {
    }

    public Movie(@NotEmpty(message = "{movie.title.notempty}") String title, @NotEmpty(message = "{movie.releaseDate.notempty}") Date releaseDate, @NotEmpty(message = "{movie.duration.notempty}") int duration, @NotEmpty(message = "{movie.ageCategory.notempty}") AgeCategoryEnum ageCategory, @NotEmpty(message = "{movie.director.notempty}") String director, @NotEmpty(message = "{movie.description.notempty}") String description, @NotEmpty(message = "{movie.imageUrl.notempty}") String imageUrl) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.duration = duration;
        this.ageCategory = ageCategory;
        this.director = director;
        this.description = description;
        this.imageUrl = imageUrl;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
