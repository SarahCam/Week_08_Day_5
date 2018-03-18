import db.DBHelper;
import models.Film;
import models.Studio;

public class Runner {

    public static void main(String[] args) {

        Studio studio1 = new Studio("Paramount Pictures", 5000000.00);
        DBHelper.saveOrUpdate(studio1);

        Studio studio2 = new Studio("Walt Disney Studios", 7000000.00);
        DBHelper.saveOrUpdate(studio2);

        Film film1 = new Film("GGG", "XXX", 10000, studio1);
        DBHelper.saveOrUpdate(film1);



    }
}
