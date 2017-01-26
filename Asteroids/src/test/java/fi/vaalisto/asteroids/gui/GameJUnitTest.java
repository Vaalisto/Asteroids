package fi.vaalisto.asteroids.gui;

import javafx.scene.paint.Color;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ville Vaalisto
 */
public class GameJUnitTest {

    Game game;

    public GameJUnitTest() {
    }

    @Before
    public void setUp() throws Exception {
        game = new Game();
    }

    @Test
    public void frameSizeRight() {
        assertEquals(800, game.getWidth());
        assertEquals(600, game.getHeight());
    }

    @Test
    public void titleIsRight() {
        assertEquals("Asteroids", game.getTitle());
    }

    @Test
    public void defaultCloseOperationTest() {
        assertEquals(3, game.getDefaultCloseOperation());
    }
    
    @Test
    public void resizableTest() {
        assertFalse(game.isResizable());
    }
    
    @Test
    public void backgroundColorIsBlack() {
        assertEquals(java.awt.Color.BLACK, game.getContentPane().getBackground());
    }

}
