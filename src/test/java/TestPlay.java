import models.GenreType;
import models.Play;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class TestPlay {

   private Play play;

    @Before
    public void before(){
        play = new Play("The Cruicible", GenreType.TRAGEDY, 4);
    }

    @Test
    public void hasTitle(){
        assertEquals("The Cruicible", play.getTitle());
    }

    @Test
    public void hasGenre(){
        assertEquals(GenreType.TRAGEDY, play.getGenre());
    }

    @Test
    public void hasPop(){
        assertEquals(4, play.getPop());
    }


}
