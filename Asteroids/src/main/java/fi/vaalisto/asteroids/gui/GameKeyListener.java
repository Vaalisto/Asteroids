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
     * @param screen pelin ruutu
     */
    public GameKeyListener(Ship ship, Screen screen) {
        this.ship = ship;
        this.screen = screen;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (!screen.isInMenu()) {
                ship.setTurningLeft(true);
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (!screen.isInMenu()) {
                ship.setTurningRight(true);
            }

        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            if (!screen.isInMenu()) {
                ship.setAccelerating(true);
            }

        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if (screen.isInMenu()) {
                screen.startGame();
            } else {
                ship.setShooting(true);
            }

        }
        if (e.getKeyCode() == KeyEvent.VK_P) {
            if (!screen.isInMenu()) {
                screen.changePause();
            }

        }
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            if (!screen.isInMenu()) {
                screen.backToMenu();
            } else {
                System.exit(0);
            }
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
