package db;

import models.Play;
import models.Theatre;

public class DBTheatre {

    public static void addPlayToTheatre(Theatre theatre, Play play){
        play.addTheatre(theatre);
        theatre.addPlay(play);
        DBHelper.update(play);
    }


}
