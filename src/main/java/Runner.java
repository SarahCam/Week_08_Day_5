import db.DBHelper;
import models.Actor;
import models.Film;
import models.Studio;
import sun.security.pkcs11.Secmod;

public class Runner {

    public static void main(String[] args) {

        Studio studio1 = new Studio("Paramount Pictures", 5000000.00);
        DBHelper.saveOrUpdate(studio1);

        Studio studio2 = new Studio("Walt Disney Studios", 7000000.00);
        DBHelper.saveOrUpdate(studio2);

        Studio studio3 = new Studio("Universal Pictures", 8000000.00);
        DBHelper.saveOrUpdate(studio3);

        Film film1 = new Film("Titanic", "Drama", 100000, studio1);
        DBHelper.saveOrUpdate(film1);

        Film film2 = new Film("Interstellar", "Sci-Fi", 90000, studio1);
        DBHelper.saveOrUpdate(film2);

        Film film3 = new Film("Jurassic Park", "Action", 110000, studio3);
        DBHelper.saveOrUpdate(film3);

        Actor actor1 = new Actor("Kate", "Winslet", 1000, 42, "Female");
        DBHelper.saveOrUpdate(actor1);
        DBHelper.addActorToFilm(actor1, film1);

    }
}
