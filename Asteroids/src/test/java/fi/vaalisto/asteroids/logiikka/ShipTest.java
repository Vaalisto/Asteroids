/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class ShipTest {

    Ship ship;

    public ShipTest() {
    }

    @Before
    public void setUp() {
        ship = new Ship(0, 0);
    }

    @Test
    public void getCoordinatesRight() {
        assertEquals(0, ship.getX());
        assertEquals(0, ship.getY());
    }

    @Test
    public void shipInNegativeSpace() {
        ship = new Ship(-100, -100);
        assertEquals(-100, ship.getX());
        assertEquals(-100, ship.getY());
    }

    @Test
    public void AngleRightInConstructor() {
        assertEquals(0, ship.getAngle());
    }
    
    @Test
    public void getActiveRightInConstructor() {
        assertFalse(ship.isActive());
    }

    @Test
    public void getVelocitiesRight() {
        ship.setxVelocity(10);
        ship.setyVelocity(-10);
        assertEquals(10, ship.getxVelocity());
        assertEquals(-10, ship.getyVelocity());
    }

    @Test
    public void moveInsideScreen() {
        ship.setxVelocity(200);
        ship.setyVelocity(300);
        ship.move(800, 600);
        assertEquals(ship.getX(), 200);
        assertEquals(ship.getY(), 300);
    }

    @Test
    public void moveCrossingScreenBorderHorizontaly() {
        ship.setxVelocity(300);
        ship.move(800, 600);
        ship.move(800, 600);
        ship.move(800, 600);
        assertEquals(100, ship.getX());
    }

    @Test
    public void moveCrossingScreenBorderVertically() {
        ship.setyVelocity(-100);
        ship.move(800, 600);
        assertEquals(500, ship.getY());
    }
    
    @Test
    public void moveToBorder() {
        ship.setxVelocity(800);
        ship.setyVelocity(600);
        ship.move(800, 600);
        assertEquals(800, ship.getX());
        assertEquals(600, ship.getY());
    }

    @Test
    public void shipMovesInNegativeSpace() {
        ship = new Ship(-100, -100);
        ship.move(800, 600);
        assertEquals(700, ship.getX());
        assertEquals(500, ship.getY());
    }

    @Test
    public void shipMovesInPositiveSpace() {
        ship = new Ship(1000, 800);
        ship.move(800, 600);
        assertEquals(200, ship.getX());
        assertEquals(200, ship.getY());
    }

    @Test
    public void shipInNegativeScreen() {
        ship.move(-800, -600);
        assertEquals(800, ship.getX());
        assertEquals(600, ship.getY());
    }

    @Test
    public void getAccelerationRight() {
        assertEquals(0.35, ship.getAcceleration(), 0.0);
    }
}
