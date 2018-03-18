package models;

import db.DBHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;

public class ActorDBTest {

    private Studio studio1;
    private Film film1;
    private Actor actor1, actor2;
    private Director director1;

    @Before
    public void setUp() throws Exception {
        director1 = new Director("James", "Cameron", 10000, 3);
        DBHelper.saveOrUpdate(director1);

        studio1 = new Studio("Paramount Pictures", 5000000.00);
        DBHelper.saveOrUpdate(studio1);

        film1 = new Film("Titanic", "Drama", 100000, studio1, director1);
        DBHelper.saveOrUpdate(film1);

        actor1 = new Actor("Kate", "Winslet", 1000, 42, "Female");
        DBHelper.saveOrUpdate(actor1);
        actor2 = new Actor("Leonardo", "Dicaprio", 2000, 43, "Male");
        DBHelper.saveOrUpdate(actor2);
    }

    @After
    public void tearDown() throws Exception {
        DBHelper.delete(actor1);
        DBHelper.delete(actor2);

        DBHelper.delete(film1);

        DBHelper.delete(studio1);

        DBHelper.delete(director1);
    }

    @Test
    public void canGetFirstName___FROM_DATABASE() {
        Actor found = DBHelper.find(Actor.class, actor1.getId());
        assertEquals("Kate", found.getFirstName());
    }


    @Test
    public void canGetFee___FROM_DATABASE() {
        Actor found = DBHelper.find(Actor.class, actor1.getId());
        assertEquals(1000, found.getFee());
    }

    @Test
    public void canGetWages___FROM_DATABASE() {
        Actor found = DBHelper.find(Actor.class, actor1.getId());
        assertEquals(0.00, found.getWages(), 0.01);
        found.setWages(200.00);
        DBHelper.saveOrUpdate(found);
        found = DBHelper.find(Actor.class, actor1.getId());
        assertEquals(200.00, found.getWages(), 0.01);
        found.setWages(100.00);
        DBHelper.saveOrUpdate(found);
        found = DBHelper.find(Actor.class, actor1.getId());
        assertEquals(300.00, found.getWages(), 0.01);
    }

    @Test
    public void canSave___Actor___TO_DATABASE() {
        List<Actor> results = DBHelper.getAll(Actor.class);
        assertEquals(2, results.size());
    }

    @Test
    public void canUpdate___Actor_Fee___IN_DATABASE(){
        Actor found = DBHelper.find(Actor.class, actor1.getId());
        found.setFee(5000);
        DBHelper.saveOrUpdate(found);
        found = DBHelper.find(Actor.class, actor1.getId());
        assertEquals(5000, found.getFee());
    }

    @Test
    public void canDelete___Actor___FROM_DATABASE() {
        Actor found = DBHelper.find(Actor.class, actor1.getId());
        DBHelper.delete(found);
        List<Film> results = DBHelper.getAll(Actor.class);
        assertEquals(1, results.size());
    }

    @Test
    public void canAddActorToFilm___IN_DATABASE() {
        DBHelper.addActorToFilm(actor1, film1);
        Actor foundActor = DBHelper.find(Actor.class, actor1.getId());
        Film foundFilm = DBHelper.find(Film.class, film1.getId());
        assertEquals(1, foundActor.getFilms().size());
        assertEquals(1, foundFilm.getActors().size());
    }
}
