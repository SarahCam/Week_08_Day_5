package models;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class DirectorTest {

    private Studio studio1;
    private Film film1;
    private Actor actor1;
    private Director director1;

    @Before
    public void setUp() throws Exception {
        director1 = new Director("James", "Cameron", 10000, 3);
        studio1 = new Studio("Paramount Pictures", 5000000.00);
        film1 = new Film("Titanic", "Drama", 100000, studio1, director1);
        actor1 = new Actor("Kate", "Winslet", 1000, 42, "Female");
    }

    @Test
    public void canGetFirstName() {
        assertEquals("James", director1.getFirstName());
    }

    @Test
    public void canGetLastName() {
        assertEquals("Cameron", director1.getLastName());
    }

    @Test
    public void canGetFee() {
        assertEquals(10000, director1.getFee());
    }

    @Test
    public void canGetAwardsCount() {
        assertEquals(3, director1.getAwardsCount());
    }

    @Test
    public void canUpdateFirstName(){
        director1.setFirstName("Donald");
        assertEquals("Donald", director1.getFirstName());
    }

    @Test
    public void canUpdateLastName(){
        director1.setLastName("Smith");
        assertEquals("Smith", director1.getLastName());
    }

    @Test
    public void canUpdateFee(){
        director1.setFee(5000);
        assertEquals(5000, director1.getFee());
    }

    @Test
    public void canUpdateAwardsCount(){
        director1.setAwardsCount(5);
        assertEquals(5, director1.getAwardsCount());
    }

    @Test
    public void canAddFilm() {
        director1.addFilm(film1);
        assertEquals(1, director1.getFilms().size());
    }
}
