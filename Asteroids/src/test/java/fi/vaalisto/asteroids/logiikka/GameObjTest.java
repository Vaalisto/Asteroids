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

    Ship ship;
    Asteroid asteroid;

    public GameObjTest() {
    }

    @Before
    public void setUp() {
        ship = new Ship(0, 0);
        asteroid = new Asteroid(100, 200);
    }

    @Test
    public void getCoordinatesRight() {
        assertEquals(0, ship.getX(), 0.0);
        assertEquals(0, ship.getY(), 0.0);
        assertEquals(100, asteroid.getX(), 0.0);
        assertEquals(200, asteroid.getY(), 0.0);

    }

    @Test
    public void shipInNegativeSpace() {
        ship = new Ship(-100, -100);
        assertEquals(-100, ship.getX(), 0.0);
        assertEquals(-100, ship.getY(), 0.0);
    }

    @Test
    public void AngleRightInConstructor() {
        assertEquals(0, ship.getAngle(), 0.0);
        assertEquals(0, asteroid.getAngle(), 0.0);
    }

    @Test
    public void AngleRightAfterSetter() {
        ship.setAngle(45);
        asteroid.setAngle(-270);
        assertEquals(45, ship.getAngle(), 0.0);
        assertEquals(-270, asteroid.getAngle(), 0.0);
    }

    @Test
    public void getActiveRightInConstructor() {
        assertFalse(ship.isActive());
    }

    @Test
    public void getVelocitiesRight() {
        ship.setxVelocity(10);
        ship.setyVelocity(-10);
        asteroid.setxVelocity(1);
        asteroid.setyVelocity(66);
        assertEquals(10, ship.getxVelocity(), 0.0);
        assertEquals(-10, ship.getyVelocity(), 0.0);
        assertEquals(1, asteroid.getxVelocity(), 0.0);
        assertEquals(66, asteroid.getyVelocity(), 0.0);
    }

    @Test
    public void moveInsideScreen() {
        ship.setxVelocity(200);
        ship.setyVelocity(300);
        ship.move(800, 600);
        assertEquals(ship.getX(), 200, 0.0);
        assertEquals(ship.getY(), 300, 0.0);
    }

    @Test
    public void moveCrossingScreenBorderHorizontaly() {
        ship.setxVelocity(300);
        ship.move(800, 600);
        ship.move(800, 600);
        ship.move(800, 600);
        assertEquals(100, ship.getX(), 0.0);
    }

    @Test
    public void moveCrossingScreenBorderVertically() {
        ship.setyVelocity(-100);
        ship.move(800, 600);
        assertEquals(500, ship.getY(), 0.0);
    }

    @Test
    public void moveToBorder() {
        ship.setxVelocity(800);
        ship.setyVelocity(600);
        ship.move(800, 600);
        assertEquals(800, ship.getX(), 0.0);
        assertEquals(600, ship.getY(), 0.0);
    }

    @Test
    public void shipMovesInNegativeSpace() {
        ship = new Ship(-100, -100);
        ship.move(800, 600);
        assertEquals(700, ship.getX(), 0.0);
        assertEquals(500, ship.getY(), 0.0);
    }

    @Test
    public void shipMovesInPositiveSpace() {
        ship = new Ship(1000, 800);
        ship.move(800, 600);
        assertEquals(200, ship.getX(), 0.0);
        assertEquals(200, ship.getY(), 0.0);
    }

    @Test
    public void shipInNegativeScreen() {
        ship.move(-800, -600);
        assertEquals(800, ship.getX(), 0.0);
        assertEquals(600, ship.getY(), 0.0);
    }

    @Test
    public void getAccelerationRight() {
        assertEquals(0.35, ship.getAcceleration(), 0.0);
    }

    @Test
    public void imagesNotNullAtContructor() {
        assertNotNull(ship.getImage());
        assertNotNull(asteroid.getImage());
    }

}
