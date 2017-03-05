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
    Asteroid asteroid;
    Ship ship;
    Shot shot;

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
    public void levelAndScoreStartFromOneAndZero() {
        assertEquals(1, eh.getLevel());
        assertEquals(0, eh.getScore());
    }

    @Test
    public void shipStartAtCenter() {
        double x = eh.ship.getX();
        double y = eh.ship.getY();
        assertEquals(x, eh.x / 2, 0.0);
        assertEquals(y, eh.y / 2, 0.0);
    }

    @Test
    public void shotIsGenerated() {
        eh.ship.setShooting(true);
        eh.generateShots();
        assertEquals(1, eh.shotlist.size());
    }

    @Test
    public void shotIsNotGeneratedWhenNotShooting() {
        eh.generateShots();
        assertEquals(0, eh.shotlist.size());
    }

    @Test
    public void tryToEmptyAsteroidList() {
        for (Asteroid a : eh.asteroidlist) {
            a.setDestroyed(true);
        }
        eh.updateAsteroids();
        eh.cleanAsteroids();
        assertEquals(0, eh.asteroidlist.size());
    }

    @Test
    public void emptyShotListWithMoves() {
        for (Asteroid a : eh.asteroidlist) { //poistetaan ensin alustetut asteroidit, ettei ammus osu niihin
            a.setDestroyed(true);
        }
        eh.updateAsteroids();
        eh.cleanAsteroids();
        eh.ship.setShooting(true);
        eh.generateShots();
        for (int i = 0; i < 100; i++) {
            eh.updateShots();
            eh.cleanShots();
        }
        assertEquals(0, eh.shotlist.size());
        assertEquals(1, eh.deadshotlist.size());
        eh.generateShots();
        for (int i = 0; i < 200; i++) {
            eh.updateShots();
        }
        assertEquals(0, eh.shotlist.size());
        assertEquals(1, eh.deadshotlist.size());
    }

    @Test
    public void shipMovesWithUpdate() {
        eh.ship.setxVelocity(1);
        double initialX = eh.ship.getX();
        eh.updateShip();
        double endX = eh.ship.getX();
        assertTrue(initialX < endX);
        assertFalse(eh.shipIsDead());
    }

    @Test
    public void shipDoesntMoveWhenDestroyed() {
        eh.ship.setxVelocity(1);
        double initialX = eh.ship.getX();
        eh.ship.setDestroyed(true);
        eh.updateShip();
        double endX = eh.ship.getX();
        assertTrue(initialX == endX);
        assertTrue(eh.shipIsDead());
    }

    @Test
    public void gameResets() {
        for (Asteroid a : eh.asteroidlist) {
            a.setDestroyed(true);
        }
        eh.updateAsteroids();
        eh.cleanAsteroids();
        assertEquals(0, eh.asteroidlist.size());
        eh.reset();
        assertEquals(4, eh.asteroidlist.size());

    }

}
