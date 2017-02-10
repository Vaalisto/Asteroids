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

    public AsteroidTest() {
    }

    @Before
    public void setUp() {
        asteroid = new Asteroid(100, 100);
    }
    
    @Test
    public void asteroidSpeedIsInRange() {
        assertTrue(Math.abs(asteroid.getxVelocity()) >= 0.000001);
        assertTrue(Math.abs(asteroid.getyVelocity()) >= 0.000001);
        assertTrue(Math.abs(asteroid.getxVelocity()) <= 0.000002);
        assertTrue(Math.abs(asteroid.getyVelocity()) <= 0.000002);
    }
   

}
