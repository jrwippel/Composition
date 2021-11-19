package entities;

import java.util.Date;

public class Dependents {
    private String name;
    private Genre genre;
    private Date birthDate;

    public Dependents() {

    }
    public Dependents(String name, Genre genre, Date birthDate) {
        this.name = name;
        this.genre = genre;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

}
