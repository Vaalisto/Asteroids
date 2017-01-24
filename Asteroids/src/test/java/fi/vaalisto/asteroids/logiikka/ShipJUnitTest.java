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
public class ShipJUnitTest {

    Ship ship;

    public ShipJUnitTest() {
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
    public void AngleRight() {
        assertEquals(0, ship.getAngle());
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
    public void moveCrossingScreenBorder() {
        ship.setxVelocity(300);
        ship.move(800, 600);
        ship.move(800, 600);
        ship.move(800, 600);
        assertEquals(ship.getX(), 100);
        
    }
}
