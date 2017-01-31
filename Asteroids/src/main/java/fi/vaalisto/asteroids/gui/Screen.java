package fi.vaalisto.asteroids.gui;

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

    public Screen(int w, int h) {
        this.setBackground(Color.BLACK);
        super.setSize(w, h);
        ship = new Ship(w / 2, h / 2);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(ship.getImage(), ship.getX(), ship.getY(), this);
    }
}
