package fi.vaalisto.asteroids.gui;

import fi.vaalisto.asteroids.logiikka.Asteroid;
import fi.vaalisto.asteroids.logiikka.Ship;
import fi.vaalisto.asteroids.logiikka.Shot;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * GameKeyListener on luokka, jonka avulla rekisteröidään pelaajan näppäinten
 * painallukset. *
 */
public class GameKeyListener implements KeyListener {

    Ship ship;

    public GameKeyListener(Ship ship) {
        this.ship = ship;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            ship.setTurningLeft(true);
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            ship.setTurningRight(true);
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            ship.setAccelerating(true);
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            ship.setShooting(true);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            ship.setTurningLeft(false);
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            ship.setTurningRight(false);
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            ship.setAccelerating(false);
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            ship.setShooting(false);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

}
