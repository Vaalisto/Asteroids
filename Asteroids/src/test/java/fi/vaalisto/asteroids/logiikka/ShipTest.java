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
        ship1.setShooting(true);
        assertTrue(ship1.isTurningLeft());
        assertFalse(ship1.isTurningRight());
        assertTrue(ship2.isTurningRight());
        assertFalse(ship2.isTurningLeft());
        assertTrue(ship1.isAccelerating());
        assertFalse(ship2.isAccelerating());
        assertTrue(ship1.isShooting());
        assertFalse(ship2.isShooting());
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
    public void shipTurns() {
        ship1.setAngle(Math.PI);
        double startAngle1 = ship1.getAngle();
        double startAngle2 = ship2.getAngle();
        ship1.setTurningLeft(true);
        ship2.setTurningRight(true);
        ship1.move(800, 600);
        ship2.move(800, 600);
        double endAngle1 = ship1.getAngle();
        double endAngle2 = ship2.getAngle();
        assertTrue(startAngle1 > endAngle1);
        assertTrue(startAngle2 < endAngle2);
    }

    @Test
    public void shipShoots() {
        Shot testshot = null;
        testshot = ship1.shoots();
        ArrayList<Shot> shotlist = new ArrayList<Shot>();
        shotlist.add(ship1.shoots());
        assertNotNull(testshot);
        assertEquals(1, shotlist.size());

    }

    @Test
    public void shotDelayWorks() {
        ship1.shoots();
        assertEquals(30, ship1.getShootDelay());
        ship1.move(800, 600);
        assertEquals(29, ship1.getShootDelay());
        for (int i = 0; i < 29; i++) {
            ship1.move(800, 600);
        }
        assertEquals(0, ship1.getShootDelay());
        ship1.move(800, 600);
        assertEquals(0, ship1.getShootDelay());
    }

    @Test
    public void accelerationWorks() {
        ship1.setAngle(-Math.PI / 4);
        ship1.setAccelerating(true);
        ship1.move(800, 600);
        double speedCalculationX = (0.1 * Math.sin(Math.PI / 4) * 0.98);
        double speedCalculationY = (0.1 * Math.cos(Math.PI / 4) * 0.98);
        assertEquals(speedCalculationX, ship1.getxVelocity(), 0.001);
        assertEquals(speedCalculationY, ship1.getyVelocity(), 0.001);
    }

}
