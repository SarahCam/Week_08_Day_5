package models;

import db.DBHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;

public class StudioTest {

    private Studio studio1;
    private Film film1;
    private Director director1;

    @Before
    public void setUp() throws Exception {
        director1 = new Director("James", "Cameron", 10000, 3);
        film1 = new Film("Titanic", "Drama", 100000, studio1, director1);
        studio1 = new Studio("Paramount Pictures", 5000000.00);
    }

    @Test
    public void canGetName() {
        assertEquals("Paramount Pictures", studio1.getName());
    }

    @Test
    public void canGetBudget() {
        assertEquals(5000000.00, studio1.getBudget(), 0.01);
    }

    @Test
    public void canUpdateName() {
        studio1.setName("Universal Studios");
        assertEquals("Universal Studios", studio1.getName());
    }

    @Test
    public void canUpdateBudget(){
        studio1.setBudget(6000000.00);
        assertEquals(6000000.00, studio1.getBudget(), 0.01);
    }

    @Test
    public void canAddFilm() {
        studio1.addFilm(film1);
        assertEquals(1, studio1.getFilms().size());
    }

}
