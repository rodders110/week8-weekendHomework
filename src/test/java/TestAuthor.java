import models.Author;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class TestAuthor {

    private Author author;

    @Before
    public void before(){
        author = new Author("Arthur Miller");
    }


    @Test
    public void hasName(){
        assertEquals("Arthur Miller", author.getName());
    }
}
