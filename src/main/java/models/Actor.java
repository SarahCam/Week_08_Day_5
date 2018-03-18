package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="actors")
public class Actor extends Employee {

    private int age;
    private String gender;

    public Actor() {
    }

    public Actor(String firstName, String lastName, int fee, int age, String gender) {
        super(firstName, lastName, fee);
        this.age = age;
        this.gender = gender;
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
}
