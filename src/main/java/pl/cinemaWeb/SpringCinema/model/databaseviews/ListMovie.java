package pl.cinemaWeb.SpringCinema.model.databaseviews;

import org.springframework.data.annotation.Immutable;

import javax.persistence.*;

@Entity(name = "list_movie")
@Immutable
public class ListMovie {

    @Id
    private long id;

    private String title;

    private String ageCategory;

    private String director;

    public ListMovie() {
    }

    public ListMovie(long id, String title, String ageCategory, String director) {
        this.id = id;
        this.title = title;
        this.ageCategory = ageCategory;
        this.director = director;
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

    public String getAgeCategory() {
        return ageCategory;
    }

    public void setAgeCategory(String ageCategory) {
        this.ageCategory = ageCategory;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "ListMovie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", ageCategory='" + ageCategory + '\'' +
                ", director='" + director + '\'' +
                '}';
    }
}
