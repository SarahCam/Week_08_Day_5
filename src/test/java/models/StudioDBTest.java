package models;

import db.DBHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;

public class StudioDBTest {

    private Studio studio1;
    private Film film1;
    private Director director1;

    @Before
    public void setUp() throws Exception {
        director1 = new Director("James", "Cameron", 10000, 3);
        DBHelper.saveOrUpdate(director1);
        studio1 = new Studio("Paramount Pictures", 5000000.00);
        DBHelper.saveOrUpdate(studio1);
        film1 = new Film("Titanic", "Drama", 100000, studio1, director1);
        DBHelper.saveOrUpdate(film1);
    }

    @After
    public void tearDown() throws Exception {
        DBHelper.delete(film1);
        DBHelper.delete(studio1);
        DBHelper.delete(director1);
    }

    @Test
    public void canGetName() {
        Studio found = DBHelper.find(Studio.class, studio1.getId());
        assertEquals("Paramount Pictures", found.getName());
    }

    @Test
    public void canGetBudget() {
        Studio found = DBHelper.find(Studio.class, studio1.getId());
        assertEquals(5000000.00, found.getBudget(), 0.01);
    }

    @Test
    public void canSave() {
        List<Studio> results = DBHelper.getAll(Studio.class);
        assertEquals(1, results.size());
    }

    @Test
    public void canUpdate(){
        Studio found = DBHelper.find(Studio.class, studio1.getId());
        found.setBudget(6000000.00);
        DBHelper.saveOrUpdate(found);
        found = DBHelper.find(Studio.class, studio1.getId());
        assertEquals(6000000.00, found.getBudget(), 0.01);
    }

//    @Test
//    public void canDelete() {
//        Studio found = DBHelper.find(Studio.class, studio1.getId());
//        DBHelper.delete(found);
//        List<Studio> results = DBHelper.getAll(Studio.class);
//        assertEquals(0, results.size());
//    }
//
//    @Test
//    public void canAddFilmToStudio___IN_DATABASE() {
//        DBHelper.addFilmToStudio(film1, studio1);
//        Studio foundStudio = DBHelper.find(Studio.class, studio1.getId());
//        assertEquals(1, foundStudio.getFilms().size());
//    }
}
