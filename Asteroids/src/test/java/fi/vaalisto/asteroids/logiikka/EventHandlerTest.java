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
public class EventHandlerTest {

    EventHandler eh;

    public EventHandlerTest() {
    }

    @Before
    public void setUp() {
        eh = new EventHandler(800, 600);
    }

    @Test
    public void shipIsInitalized() {
        assertNotNull(eh.ship);
    }
    
    @Test
    public void asteroidsAreInitalized() {
        assertEquals(4, eh.asteroidlist.size());
    }
    
    @Test
    public void shotIsGenerated() {
        eh.ship.setShooting(true);
        eh.generateShots();
        assertEquals(1, eh.shotlist.size());
    }
    
}
