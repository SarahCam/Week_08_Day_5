package models;

import javax.persistence.*;

@Entity
@Table(name="studios")
public class Studio {

    private int id;
    private String name;
    private double budget;

    public Studio() {
    }

    public Studio(String name, double budget) {
        this.name = name;
        this.budget = budget;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="budget")
    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }
}
