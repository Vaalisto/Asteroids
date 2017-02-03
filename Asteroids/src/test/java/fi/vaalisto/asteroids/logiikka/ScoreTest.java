package fi.vaalisto.asteroids.logiikka;

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
public class ScoreTest {
    
    Score score1;
    Score score2;
    Score score3;

    public ScoreTest() {
    }

    @Before
    public void setUp() {
        score1 = new Score(100, "Matti");
        score2 = new Score(200, "Teppo");
        score3 = new Score(200, "Jari");
    }
    
    @Test
    public void GettersWorks() {
        assertEquals(100, score1.getScore());
        assertEquals(200, score2.getScore());
        assertEquals(200, score3.getScore());
        assertEquals("Matti", score1.getName());
        assertEquals("Teppo", score2.getName());
        assertEquals("Jari", score3.getName());
    }
    
    @Test
    public void compareWorks() {
        int result1 = score1.compareTo(score2);
        int result2 = score2.compareTo(score1);
        int result3 = score2.compareTo(score3);
        assertTrue(result1 <= -1);
        assertTrue(result2 >= 1);
        assertTrue(result3 == 0);
    }

}
