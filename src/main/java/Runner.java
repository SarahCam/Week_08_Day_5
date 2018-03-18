import db.DBHelper;
import models.Studio;

public class Runner {

    public static void main(String[] args) {

        Studio studio = new Studio("Paramount Pictures", 5000000.00);
        DBHelper.saveOrUpdate(studio);

    }
}
