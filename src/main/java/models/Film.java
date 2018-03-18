package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="films")
public class Film {

    private int id;
    private String title;
    private String genre;
    private double budget;
    private Studio studio;
    private List<Actor> actors;

    public Film() {
    }

    public Film(String title, String genre, double budget, Studio studio) {
        this.title = title;
        this.genre = genre;
        this.budget = budget;
        this.studio = studio;
        this.actors = new ArrayList<Actor>();
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name="genre")
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Column(name="budget")
    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    @ManyToOne
    @JoinColumn(name = "studio_id", nullable = false)
    public Studio getStudio() {
        return studio;
    }

    public void setStudio(Studio studio) {
        this.studio = studio;
    }

    @ManyToMany
    @JoinTable(name = "actor_film",
            joinColumns = {@JoinColumn(name = "film_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "actor_id", nullable = false, updatable = false)}
    )
    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }
}
