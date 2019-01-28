package pl.cinemaWeb.SpringCinema.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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

    @NotNull(message = "{movie.releaseDate.notempty}")
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

    @NotEmpty(message = "{movie.description.notempty}")
    private String description;

    @Column(name = "image_url")
    private String imageUrl;

    @NotEmpty(message = "{movie.coverUrl.notempty}")
    @Column(name = "cover_url")
    private String coverUrl;

    public Movie() {
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

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
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
                ", imageUrl='" + imageUrl + '\'' +
                ", coverUrl='" + coverUrl + '\'' +
                '}';
    }
}
