import models.Character;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class TestCharacter {

    private Character character;

    @Before
    public void before(){
        character = new Character("Judge Thomas Danforth");
    }

    @Test
    public void hasName(){
        assertEquals("Judge Thomas Danforth", character.getName());
    }
}
