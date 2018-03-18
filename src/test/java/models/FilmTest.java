package models;

import db.DBHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;

public class FilmTest {

    private Studio studio1, studio2, studio3;
    private Film film1, film2, film3;
    private Director director1, director2, director3;

    @Before
    public void setUp() throws Exception {
        director1 = new Director("James", "Cameron", 10000, 3);
        director2 = new Director("Christopher", "Nolan", 20000, 5);
        director3 = new Director("Steven", "Spielberg", 30000, 10);

        studio1 = new Studio("Paramount Pictures", 5000000.00);
        DBHelper.saveOrUpdate(studio1);
        studio2 = new Studio("Walt Disney Studios", 7000000.00);
        DBHelper.saveOrUpdate(studio2);
        studio3 = new Studio("Universal Pictures", 8000000.00);
        DBHelper.saveOrUpdate(studio3);

        film1 = new Film("Titanic", "Drama", 100000, studio1, director1);
        DBHelper.saveOrUpdate(film1);
        film2 = new Film("Interstellar", "Sci-Fi", 90000, studio1, director2);
        DBHelper.saveOrUpdate(film2);
        film3 = new Film("Jurassic Park", "Action", 110000, studio3, director3);
        DBHelper.saveOrUpdate(film3);
    }

    @After
    public void tearDown() throws Exception {
        DBHelper.delete(film1);
        DBHelper.delete(film2);
        DBHelper.delete(film3);

        DBHelper.delete(studio1);
        DBHelper.delete(studio2);
        DBHelper.delete(studio3);

        DBHelper.delete(director1);
        DBHelper.delete(director2);
        DBHelper.delete(director3);
    }

    @Test
    public void canGetTitle() {
        Film found = DBHelper.find(Film.class, film1.getId());
        assertEquals("Titanic", found.getTitle());
    }

    @Test
    public void canGetBudget() {
        Film found = DBHelper.find(Film.class, film1.getId());
        assertEquals(100000.00, found.getBudget(), 0.01);
    }

    @Test
    public void canSave() {
        List<Film> results = DBHelper.getAll(Film.class);
        assertEquals(3, results.size());
    }

    @Test
    public void canUpdate(){
        Film found = DBHelper.find(Film.class, film1.getId());
        found.setBudget(5000.00);
        DBHelper.saveOrUpdate(found);
        found = DBHelper.find(Film.class, film1.getId());
        assertEquals(5000.00, found.getBudget(), 0.01);
    }

    @Test
    public void canDelete() {
        Film found = DBHelper.find(Film.class, film3.getId());
        DBHelper.delete(found);
        List<Film> results = DBHelper.getAll(Film.class);
        assertEquals(2, results.size());
    }
}
