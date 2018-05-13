import db.DBHelper;
import models.Actor;
import models.Director;
import models.Film;
import models.Studio;
import sun.security.pkcs11.Secmod;

public class Runner {

    public static void main(String[] args) {

        Director director1 = new Director("James", "Cameron", 10000, 3);
        DBHelper.saveOrUpdate(director1);

        Director director2 = new Director("Christopher", "Nolan", 20000, 5);
        DBHelper.saveOrUpdate(director2);

        Director director3 = new Director("Steven", "Spielberg", 30000, 10);
        DBHelper.saveOrUpdate(director3);

        Studio studio1 = new Studio("Paramount Pictures", 5000000.00);
        DBHelper.saveOrUpdate(studio1);

        Studio studio2 = new Studio("Walt Disney Studios", 7000000.00);
        DBHelper.saveOrUpdate(studio2);

        Studio studio3 = new Studio("Universal Pictures", 8000000.00);
        DBHelper.saveOrUpdate(studio3);

        Film film1 = new Film("Titanic", "Drama", 100000, studio1, director1);
        DBHelper.saveOrUpdate(film1);

        Studio updatedStudio1 = DBHelper.find(Studio.class, studio1.getId());

        Film film2 = new Film("Interstellar", "Sci-Fi", 90000, studio1, director2);
        DBHelper.saveOrUpdate(film2);

        Film film3 = new Film("Jurassic Park", "Action", 110000, studio3, director3);
        DBHelper.saveOrUpdate(film3);

        Actor actor1 = new Actor("Kate", "Winslet", 1000, 42, "Female");
        DBHelper.saveOrUpdate(actor1);
        DBHelper.addActorToFilm(actor1, film1);

        Actor actor2 = new Actor("Leonardo", "Dicaprio", 2000, 43, "Male");
        DBHelper.saveOrUpdate(actor2);
        DBHelper.addActorToFilm(actor2, film1);



    }
}
