package models;

import db.DBHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;

public class ActorTest {

    private Studio studio1, studio2, studio3;
    private Film film1, film2, film3;
    private Actor actor1, actor2;
    private Director director1, director2, director3;

    @Before
    public void setUp() throws Exception {
        director1 = new Director("James", "Cameron", 10000, 3);
        studio1 = new Studio("Paramount Pictures", 5000000.00);
        film1 = new Film("Titanic", "Drama", 100000, studio1, director1);
        actor1 = new Actor("Kate", "Winslet", 1000, 42, "Female");
    }

    @Test
    public void canGetFirstName() {
        assertEquals("Kate", actor1.getFirstName());
    }

    @Test
    public void canGetLastName() {
        assertEquals("Winslet", actor1.getLastName());
    }

    @Test
    public void canGetFee() {
        assertEquals(1000, actor1.getFee());
    }

    @Test
    public void canGetAge() {
        assertEquals(42, actor1.getAge());
    }

    @Test
    public void canGetGender() {
        assertEquals("Female", actor1.getGender());
    }

    @Test
    public void canUpdateFirstName(){
        actor1.setFirstName("Katherine");
        assertEquals("Katherine", actor1.getFirstName());
    }

    @Test
    public void canUpdateLastName(){
        actor1.setLastName("Smith");
        assertEquals("Smith", actor1.getLastName());
    }

    @Test
    public void canUpdateFee(){
        actor1.setFee(5000);
        assertEquals(5000, actor1.getFee());
    }

    @Test
    public void canUpdateAge(){
        actor1.setAge(50);
        assertEquals(50, actor1.getAge());
    }

    @Test
    public void canUpdateGender(){
        actor1.setGender("Male");
        assertEquals("Male", actor1.getGender());
    }

    @Test
    public void canAddFilm() {
        actor1.addFilm(film1);
        assertEquals(1, actor1.getFilms().size());
    }
}
