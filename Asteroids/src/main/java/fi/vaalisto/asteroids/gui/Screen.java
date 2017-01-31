package fi.vaalisto.asteroids.gui;

import fi.vaalisto.asteroids.logiikka.Asteroid;
import fi.vaalisto.asteroids.logiikka.Ship;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;

/**
 *
 * @author Ville Vaalisto
 */
public class Screen extends JPanel {

    private Ship ship;
    private Asteroid rock;

    public Screen(int w, int h) {
        this.setBackground(Color.BLACK);
        super.setSize(w, h);
        ship = new Ship(w / 2, h / 2);
        rock = new Asteroid(w / 4, w / 4);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(ship.getImage(), ship.getX(), ship.getY(), this);
        g.drawImage(rock.getImage(), rock.getX(), rock.getY(), this);
    }
}
