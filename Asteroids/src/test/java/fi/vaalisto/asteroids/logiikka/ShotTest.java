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
    
    Shot shot1;
    
    @Before
    public void setUp() {
        shot1 = new Shot(10, 20, 0, 0, 5);
    }
    
    @Test
    public void velocitiesRightAtContructor() {
        assertEquals(0, shot1.getxVelocity(), 0.0);
        assertEquals(9, shot1.getyVelocity(), 0.0);
    }
    
    @Test
    public void lifeDrains(){
        assertEquals(100, shot1.getLife());
        shot1.move(800, 600);
        assertEquals(99, shot1.getLife());
        
    }
}
