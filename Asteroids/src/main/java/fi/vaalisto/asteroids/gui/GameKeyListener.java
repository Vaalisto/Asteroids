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
    int shotlimit;

    public GameKeyListener(Ship ship, Screen screen, int shotlimit) {
        this.ship = ship;
        this.screen = screen;
        this.shotlimit = shotlimit;
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
            if (screen.shotlist.size() < shotlimit) {
                screen.shotlist.add(new Shot(ship.getX(), ship.getY(), ship.getAngle(), ship.getxVelocity(), ship.getyVelocity()));

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
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

}
