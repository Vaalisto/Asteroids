/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.vaalisto.asteroids.logiikka;

import java.awt.Image;
import javax.imageio.ImageIO;
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
public class GameObjTest {

    Ship ship1;
    Ship ship2;
    Asteroid asteroid;

    public GameObjTest() {
    }

    @Before
    public void setUp() {
        ship1 = new Ship(0, 0);
        asteroid = new Asteroid(100, 200, 1.0);
    }

    @Test
    public void getCoordinatesRight() {
        assertEquals(0, ship1.getX(), 0.0);
        assertEquals(0, ship1.getY(), 0.0);
        assertEquals(100, asteroid.getX(), 0.0);
        assertEquals(200, asteroid.getY(), 0.0);
    }

    @Test
    public void shipInNegativeSpace() {
        ship1 = new Ship(-100, -100);
        assertEquals(-100, ship1.getX(), 0.0);
        assertEquals(-100, ship1.getY(), 0.0);
    }

    @Test
    public void AngleRightInConstructor() {
        assertEquals(0, ship1.getAngle(), 0.0);
        assertEquals(0, asteroid.getAngle(), 0.0);
    }

    @Test
    public void AngleRightAfterSetter() {
        ship1.setAngle(0);
        asteroid.setAngle(2 * Math.PI);
        assertEquals(0, ship1.getAngle(), 0.0);
        assertEquals(2 * Math.PI, asteroid.getAngle(), 0.0);
    }

    @Test
    public void testAngleChecker() {
        ship2 = new Ship(0, 0);

        ship1.setAngle(-Math.PI);
        ship2.setAngle(3 * Math.PI);
        assertEquals(Math.PI, ship1.getAngle(), 0.0);
        assertEquals(Math.PI, ship2.getAngle(), 0.0);
    }

    @Test
    public void getActiveRightInConstructor() {
        assertFalse(ship1.isActive());
    }

    @Test
    public void getVelocitiesRight() {
        ship1.setxVelocity(10);
        ship1.setyVelocity(-10);
        asteroid.setxVelocity(1);
        asteroid.setyVelocity(66);
        assertEquals(10, ship1.getxVelocity(), 0.0);
        assertEquals(-10, ship1.getyVelocity(), 0.0);
        assertEquals(1, asteroid.getxVelocity(), 0.0);
        assertEquals(66, asteroid.getyVelocity(), 0.0);
    }

    @Test
    public void moveInsideScreen() {
        ship1.setxVelocity(200);
        ship1.setyVelocity(300);
        ship1.move(800, 600);
        assertEquals(ship1.getX(), 200, 0.0);
        assertEquals(ship1.getY(), 300, 0.0);
    }

    @Test
    public void moveCrossingScreenBorderHorizontaly() {
        ship1.setxVelocity(900);
        ship1.move(800, 600);        
        assertEquals(100, ship1.getX(), 0.0);
    }

    @Test
    public void moveCrossingScreenBorderVertically() {
        ship1.setyVelocity(-100);
        ship1.move(800, 600);
        assertEquals(500, ship1.getY(), 0.0);
    }

    @Test
    public void moveToBorder() {
        ship1.setxVelocity(800);
        ship1.setyVelocity(600);
        ship1.move(800, 600);
        assertEquals(800, ship1.getX(), 0.0);
        assertEquals(600, ship1.getY(), 0.0);
    }

    @Test
    public void shipMovesInNegativeSpace() {
        ship1 = new Ship(-100, -100);
        ship1.move(800, 600);
        assertEquals(700, ship1.getX(), 0.0);
        assertEquals(500, ship1.getY(), 0.0);
    }

    @Test
    public void shipMovesInPositiveSpace() {
        ship1 = new Ship(1000, 800);
        ship1.move(800, 600);
        assertEquals(200, ship1.getX(), 0.0);
        assertEquals(200, ship1.getY(), 0.0);
    }

    @Test
    public void shipInNegativeScreen() {
        ship1.move(-800, -600);
        assertEquals(800, ship1.getX(), 0.0);
        assertEquals(600, ship1.getY(), 0.0);
    }

    @Test
    public void imagesNotNullAtContructor() {
        assertNotNull(ship1.getImage());
        assertNotNull(asteroid.getImage());
    }
    
    @Test
    public void radiusIsCalculatedRight() {
        assertEquals(15, ship1.radius);
        assertEquals(26, asteroid.radius);
    }

}
