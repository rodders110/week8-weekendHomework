import models.Theatre;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

public class TestTheatre {

    private Theatre theatre;

    @Before
    public void before(){
        theatre = new Theatre("The Grand Ole Opry", "2-4 Govan Road, Glasgow");
    }


    @Test
    public void hasName(){
        assertEquals("The Grand Ole Opry", theatre.getName());
    }

    @Test
    public void hasAddress(){
        assertEquals("2-4 Govan Road, Glasgow", theatre.getAddress());
    }
}
