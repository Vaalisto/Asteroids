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
    private static final int FPS = 60;
    private static final double NANOS = 1000000000 / FPS;

    public int w;
    public int h;
    public Ship ship;
    public ArrayList<Asteroid> asteroidlist;

    private boolean running = true;
    private double delta = 0;

    public Screen(int w, int h) {
        this.w = w;
        this.h = h;
        this.asteroidlist = new ArrayList<Asteroid>();
        this.setBackground(Color.BLUE); //toistaiseksi sininen, jotta näkee objektit paremmin
        super.setSize(w, h);
        initShip();
        initAsteroids();
        setAsteroidSpeed();
    }

    public void initShip() {
        ship = new Ship(w / 2, h / 2);
//        ship.setxVelocity(0.00001);
    }

    public void initAsteroids() {
        for (int i = 0; i < NUMBER_OF_ASTEROIDS; i++) {
            int randomX = (int) (Math.random() * w);
            int randomY = (int) (Math.random() * h);
            asteroidlist.add(new Asteroid(randomX, randomY));
        }
    }
    
    public void setAsteroidSpeed() { // testataan, että peli pyörii
        for (Asteroid a : asteroidlist) {
            a.setxVelocity(0.000001);
            a.setyVelocity(-0.000001);
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
    
    public void updateAsteroids() {
        if (!asteroidlist.isEmpty()) {
            for (Asteroid a : asteroidlist) {
                a.move(w, h);
            }
        }
    }

    public void update() {
        ship.move(w, h);
        updateAsteroids();
    }

    public void run() {
        long lastTime = System.nanoTime();
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / NANOS;
            lastTime = now;
            while (delta >= 1) {
                update();
                this.repaint();
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
