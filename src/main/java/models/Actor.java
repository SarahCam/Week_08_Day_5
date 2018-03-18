package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="actors")
public class Actor extends Employee {

    private int age;
    private String gender;
    private List<Film> films;

    public Actor() {
    }

    public Actor(String firstName, String lastName, int fee, int age, String gender) {
        super(firstName, lastName, fee);
        this.age = age;
        this.gender = gender;
        this.films = new ArrayList<Film>();
    }

    @Column(name="age")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Column(name="gender")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @ManyToMany(mappedBy = "actors", fetch = FetchType.EAGER)
    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }
}
