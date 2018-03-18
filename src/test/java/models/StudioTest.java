package models;

import db.DBHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;

public class StudioTest {

    private Studio studio1, studio2;

    @Before
    public void setUp() throws Exception {
        studio1 = new Studio("Paramount Pictures", 5000000.00);
        DBHelper.saveOrUpdate(studio1);
        studio2 = new Studio("Walt Disney Studios", 7000000.00);
        DBHelper.saveOrUpdate(studio2);
    }

    @After
    public void tearDown() throws Exception {
        DBHelper.delete(studio1);
        DBHelper.delete(studio2);
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
        assertEquals(2, results.size());
    }

    @Test
    public void canUpdate(){
        Studio found = DBHelper.find(Studio.class, studio1.getId());
        found.setBudget(6000000.00);
        DBHelper.saveOrUpdate(found);
        found = DBHelper.find(Studio.class, studio1.getId());
        assertEquals(6000000.00, found.getBudget(), 0.01);
    }

    @Test
    public void canDelete() {
        Studio found = DBHelper.find(Studio.class, studio1.getId());
        DBHelper.delete(found);
        List<Studio> results = DBHelper.getAll(Studio.class);
        assertEquals(1, results.size());
    }
}
