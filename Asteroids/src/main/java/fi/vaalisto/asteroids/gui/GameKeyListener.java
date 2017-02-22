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
    Screen screen;

    /**
     * Konstruktori luo näppäimistökuuntelijan, joka saa parametriksi pelin
     * aluksen.
     *
     * @param ship pelaajan ohjaama alus
     */
    public GameKeyListener(Ship ship, Screen screen) {
        this.ship = ship;
        this.screen = screen;
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
        if (e.getKeyCode() == KeyEvent.VK_P) {
            screen.changePause();
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
