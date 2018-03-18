package models;

import db.DBHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;

public class FilmTest {

    private Studio studio1, studio2;
    private Film film1;
    private Director director1, director2;
    private Actor actor1;

    @Before
    public void setUp() throws Exception {
        director1 = new Director("James", "Cameron", 10000, 3);
        director2 = new Director("Christopher", "Nolan", 20000, 5);

        studio1 = new Studio("Paramount Pictures", 5000000.00);
        studio2 = new Studio("Walt Disney Studios", 7000000.00);

        film1 = new Film("Titanic", "Drama", 100000, studio1, director1);

        actor1 = new Actor("Kate", "Winslet", 1000, 42, "Female");
    }

    @Test
    public void canGetTitle() {
        assertEquals("Titanic", film1.getTitle());
    }

    @Test
    public void canGetGenre() {
        assertEquals("Drama", film1.getGenre());
    }

    @Test
    public void canGetBudget() {
        assertEquals(100000.00, film1.getBudget(), 0.01);
    }

    @Test
    public void canGetStudio() {
        assertEquals(studio1, film1.getStudio());
    }

    @Test
    public void canGetDirector() {
        assertEquals(director1, film1.getDirector());
    }

    @Test
    public void canUpdateTitle() {
        film1.setTitle("HMS Victory");
        assertEquals("HMS Victory", film1.getTitle());
    }

    @Test
    public void canUpdateGenre() {
        film1.setGenre("Disaster");
        assertEquals("Disaster", film1.getGenre());
    }

    @Test
    public void canUpdateBudget(){
        film1.setBudget(5000.00);
        assertEquals(5000.00, film1.getBudget(), 0.01);
    }

    @Test
    public void canUpdateStudio(){
        film1.setStudio(studio2);
        assertEquals(studio2, film1.getStudio());
    }

    @Test
    public void canUpdateDirector(){
        film1.setDirector(director2);
        assertEquals(director2, film1.getDirector());
    }

    @Test
    public void canAddActor() {
        film1.addActor(actor1);
        assertEquals(1, film1.getActors().size());
    }
}
