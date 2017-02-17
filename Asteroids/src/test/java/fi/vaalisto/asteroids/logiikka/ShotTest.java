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
public class ShotTest {
    
    Ship ship1;
    Shot shot1;
    
    @Before
    public void setUp() {
        shot1 = new Shot(10, 20, 0, 0, 5);
    }
    
    @Test
    public void velocitiesRightAtContructor() {
        ship1 = new Ship(0, 0);
        ship1.setyVelocity(5);
        double shotSpeedX = ship1.getxVelocity() + 4 * Math.sin(shot1.getAngle());
        double shotSpeedY = ship1.getyVelocity() + 4 * Math.cos(shot1.getAngle());
        assertEquals(shotSpeedX, shot1.getxVelocity(), 0.0);
        assertEquals(shotSpeedY, shot1.getyVelocity(), 0.0);
    }
    
    @Test
    public void lifeDrains(){
        assertEquals(100, shot1.getLife());
        shot1.move(800, 600);
        assertEquals(99, shot1.getLife());        
    }
    
    @Test
    public void shotMoves() {
        
    }
}
