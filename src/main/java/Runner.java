import db.DBHelper;
import models.*;
import models.Character;

public class Runner {

    public static void main(String[] args) {

        Character character1 = new Character("a Character");
        Play play = new Play("The Cruicible", GenreType.DRAMA, 4);
        Author author1 = new Author("Alan Miller");
        author1.addPlay(play);
        Theatre theatre1 = new Theatre("The Grand Ole Opry", "2-4 Govan Road, Glasgow");

        DBHelper.save(author1);
        play.setAuthor(author1);
        DBHelper.save(theatre1);
        DBHelper.save(play);
        DBHelper.save(character1);
        DBHelper.save(character1);
    }
}
