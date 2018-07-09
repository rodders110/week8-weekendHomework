package db;

import com.sun.xml.internal.ws.handler.HandlerException;
import models.Play;
import models.Theatre;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBTheatre {

    private static Session session;

    public static void addPlayToTheatre(Theatre theatre, Play play){
        play.addTheatre(theatre);
        theatre.addPlay(play);
        DBHelper.update(play);
    }

    public static List<Play> allPlays(Theatre theatre){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Play> results = null;

        try{
            Criteria cr = session.createCriteria(Play.class);
            cr.createAlias("theatres", "theatre");
            cr.add(Restrictions.eq("theatre.id", theatre.getId()));
            results = cr.list();
        } catch (HandlerException e){
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }
}
