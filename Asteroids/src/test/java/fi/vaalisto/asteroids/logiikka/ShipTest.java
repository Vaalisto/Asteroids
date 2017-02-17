/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.vaalisto.asteroids.logiikka;

import java.util.ArrayList;
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
        ship2.setAccelerating(false);
        ship1.xVelocity = 1.5;
        ship1.yVelocity = -1;
        ship1.move(800, 600);
        ship2.xVelocity = -2;
        ship2.move(800, 600);
        assertEquals(101.5, ship1.getX(), 0.0);
        assertEquals(99.0, ship1.getY(), 0.0);
        assertEquals(8, ship2.getX(), 0.0);
    }
    
    @Test
    public void shipShoots() {
        ArrayList<Shot> shotlist = new ArrayList<Shot>();
        shotlist.add(ship1.shoots());
        assertEquals(1, shotlist.size());
    }
}
