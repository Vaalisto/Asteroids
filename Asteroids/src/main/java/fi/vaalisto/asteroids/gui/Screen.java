package fi.vaalisto.asteroids.gui;

import fi.vaalisto.asteroids.logiikka.*;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;
import javax.swing.*;

/**
 *
 * @author Ville Vaalisto
 */
public class Screen extends JPanel {

    private static final int NUMBER_OF_ASTEROIDS = 4;
    private int w;
    private int h;
    private Ship ship;
    private Asteroid rock;
    private ArrayList<Asteroid> asteroidlist;

    public Screen(int w, int h) {
        this.w = w;
        this.h = h;
        this.asteroidlist = new ArrayList<Asteroid>();
        this.setBackground(Color.BLACK);
        super.setSize(w, h);
        initShip();
        initAsteroids();
        

    }

    public void initShip() {
        ship = new Ship(w / 2, h / 2);
    }

    public void initAsteroids() {
        for (int i = 0; i < NUMBER_OF_ASTEROIDS; i++) {
            int randomX = (int) (Math.random() * w);
            int randomY = (int) (Math.random() * h);
            rock = new Asteroid(randomX, randomY);
            asteroidlist.add(rock);
        }
    }

    public void drawShip(Graphics g) {
        this.ship.draw(g);
    }

    public void drawAsteroids(Graphics g) {
        if (!asteroidlist.isEmpty()) {
            for (Asteroid a : asteroidlist) {
                a.draw(g);
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawShip(g);
        drawAsteroids(g);
    }
}
