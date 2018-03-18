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

    @Before
    public void setUp() throws Exception {
        studio1 = new Studio("Paramount Pictures", 5000000.00);
        DBHelper.saveOrUpdate(studio1);
        studio2 = new Studio("Walt Disney Studios", 7000000.00);
        DBHelper.saveOrUpdate(studio2);
        studio3 = new Studio("Universal Pictures", 8000000.00);
        DBHelper.saveOrUpdate(studio3);

        film1 = new Film("Titanic", "Drama", 100000, studio1);
        DBHelper.saveOrUpdate(film1);
        film2 = new Film("Interstellar", "Sci-Fi", 90000, studio1);
        DBHelper.saveOrUpdate(film2);
        film3 = new Film("Jurassic Park", "Action", 110000, studio3);
        DBHelper.saveOrUpdate(film3);

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
        DBHelper.delete(film2);
        DBHelper.delete(film3);

        DBHelper.delete(studio1);
        DBHelper.delete(studio2);
        DBHelper.delete(studio3);
    }

    @Test
    public void canGetFirstName() {
        Actor found = DBHelper.find(Actor.class, actor1.getId());
        assertEquals("Kate", found.getFirstName());
    }

    @Test
    public void canGetFee() {
        Actor found = DBHelper.find(Actor.class, actor1.getId());
        assertEquals(1000, found.getFee());
    }

    @Test
    public void canSave() {
        List<Actor> results = DBHelper.getAll(Actor.class);
        assertEquals(2, results.size());
    }

    @Test
    public void canUpdate(){
        Actor found = DBHelper.find(Actor.class, actor1.getId());
        found.setFee(5000);
        DBHelper.saveOrUpdate(found);
        found = DBHelper.find(Actor.class, actor1.getId());
        assertEquals(5000, found.getFee());
    }

    @Test
    public void canDelete() {
        Actor found = DBHelper.find(Actor.class, actor1.getId());
        DBHelper.delete(found);
        List<Film> results = DBHelper.getAll(Actor.class);
        assertEquals(1, results.size());
    }
}
