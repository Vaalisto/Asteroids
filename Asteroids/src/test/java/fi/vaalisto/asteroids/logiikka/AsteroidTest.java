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
public class AsteroidTest {

    Asteroid asteroid;
    Shot shot;
    Ship ship;

    public AsteroidTest() {
    }

    @Before
    public void setUp() {
        asteroid = new Asteroid(100, 100);
    }
    
    @Test
    public void asteroidSpeedIsInRange() {
        assertTrue(Math.abs(asteroid.getxVelocity()) >= 0.75);
        assertTrue(Math.abs(asteroid.getyVelocity()) >= 0.75);
        assertTrue(Math.abs(asteroid.getxVelocity()) <= 1.5);
        assertTrue(Math.abs(asteroid.getyVelocity()) <= 1.5);
    }
    
    @Test
    public void trueShotCollisionTest() {
        shot = new Shot(95, 95, 0, 0, 0);
        asteroid.checkShotCollision(shot);
        assertTrue(shot.isDestroyed());
        assertTrue(asteroid.isDestroyed());
    }
    
    @Test
    public void falseShotCollisionTest() {
        shot = new Shot(80, 80, 0, 0, 0);
        asteroid.checkShotCollision(shot);
        assertFalse(shot.isDestroyed());
        assertFalse(asteroid.isDestroyed());
    }
    
    @Test
    public void trueShipCollisionTest() {
        ship = new Ship(95, 95);
        asteroid.checkShipCollision(ship);
        assertTrue(ship.isDestroyed());
    }
    
    @Test
    public void falseShipCollisionTest() {
        ship = new Ship(50, 50);
        asteroid.checkShipCollision(ship);
        assertFalse(ship.isDestroyed());
    }
   

}
