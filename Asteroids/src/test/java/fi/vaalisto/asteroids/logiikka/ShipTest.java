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

    Ship ship1;
    Ship ship2;

    public ShipTest() {
    }

    @Before
    public void setUp() {
        ship1 = new Ship(100, 100);
        ship2 = new Ship(10, 10);
    }

    @Test
    public void shipsGettersAndSettersWork() {
        ship1.setTurningLeft(true);
        ship2.setTurningLeft(false);
        ship2.setTurningRight(true);
        ship1.setAccelerating(true);
        ship2.setAccelerating(false);
        assertTrue(ship1.isTurningLeft());
        assertFalse(ship1.isTurningRight());
        assertTrue(ship2.isTurningRight());
        assertFalse(ship2.isTurningLeft());
        assertTrue(ship1.isAccelerating());
        assertFalse(ship2.isAccelerating());
    }

    @Test
    public void shipMoves() {
        ship1.setAccelerating(true);
        ship2.setTurningLeft(false);
        ship2.setTurningRight(true);
        ship2.setAccelerating(false);
        ship1.xVelocity = 0.00002;
        ship1.yVelocity = -0.00002;
        ship1.move(800, 600);
        ship2.xVelocity = -0.00003;
        ship2.move(800, 600);
        assertEquals(100.00002, ship1.getX(), 0.0);
        assertEquals(99.99998, ship1.getY(), 0.0);
        assertEquals(6.28, ship1.getAngle(), 0.01);
        assertEquals(9.99997, ship2.getX(), 0.0);
        assertEquals(0.000001, ship2.getAngle(), 0.0);
    }
}
