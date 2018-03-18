package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="directors")
public class Director extends Employee {

    private int awardsCount;
    private List<Film> films;

    public Director() {
    }

    public Director(String firstName, String lastName, int fee, int awardsCount) {
        super(firstName, lastName, fee);
        this.awardsCount = awardsCount;
        this.films = new ArrayList<Film>();
    }

    @Column(name="awards_count")
    public int getAwardsCount() {
        return awardsCount;
    }

    public void setAwardsCount(int awardsCount) {
        this.awardsCount = awardsCount;
    }

    @OneToMany(mappedBy = "director")
    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }
}
