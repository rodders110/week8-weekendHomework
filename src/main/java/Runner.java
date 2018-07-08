import db.DBHelper;
import db.DBTheatre;
import models.*;
import models.Character;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Character character1 = new Character("a Character");
        DBHelper.save(character1);

        Author author1 = new Author("Alan Miller");
        DBHelper.save(author1);

        Play play = new Play("The Cruicible", GenreType.DRAMA, 4);
        play.setAuthor(author1);
        DBHelper.save(play);

        Theatre theatre1 = new Theatre("The Grand Ole Opry", "2-4 Govan Road, Glasgow");
        theatre1.addPlay(play);
        DBHelper.save(theatre1);
    }
}
