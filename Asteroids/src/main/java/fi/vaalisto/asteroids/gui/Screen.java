package fi.vaalisto.asteroids.gui;

import fi.vaalisto.asteroids.logiikka.*;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;
import javax.swing.*;

/**
 * Screen-luokka toteuttaa pelikentän näkyvän osan ja myös aikasilmukan, joka
 * mahdollistaa pelin reaaliaikaisen toiminnan.
 *
 */
public class Screen extends JPanel {

    private static final int NUMBER_OF_ASTEROIDS = 4; //asteroidien määrä alussa
    private static final int FPS = 60; //pelin päivitysnopeus
    private static final double MILLIS = 1000 / FPS; //millisekunteja per kuvanpäivitys

    public int w;
    public int h;
    public Ship ship;
    public ArrayList<Asteroid> asteroidlist;
    public GameKeyListener keylistener;

    private boolean running = true;
    private double delta = 0;

    /**
     * Konstruktori asettaa pelikentän leveyden, taustavärin ja alustaa
     * asteroidit sekä pelaajan aluksen.
     *
     * @param w haluttu pelikentän leveys
     * @param h haluttu pelikentän korkeus
     */
    public Screen(int w, int h) {
        this.w = w;
        this.h = h;
        this.asteroidlist = new ArrayList<Asteroid>();
        this.setBackground(Color.BLUE); //toistaiseksi sininen, jotta näkee objektit paremmin
        super.setSize(w, h);
        this.setFocusable(true); //näppäimistökuuntelija ei toimi ilman tätä
        this.requestFocusInWindow(); //näppäimistökuuntelija ei toimi ilman tätä
        initShip();
        initAsteroids();
        initKeyListener();
    }

    /**
     * Asettaa pelaajan aluksen pelikentän keskelle.
     */
    public void initShip() {
        ship = new Ship(w / 2, h / 2);
    }

    /**
     * Alustaa halutun määrän uusia asteroideja ja satunnaisgeneroi niiden
     * sijainnit.
     */
    public void initAsteroids() {
        for (int i = 0; i < NUMBER_OF_ASTEROIDS; i++) {
            int randomX = (int) (Math.random() * w);
            int randomY = (int) (Math.random() * h);
            asteroidlist.add(new Asteroid(randomX, randomY));
        }
    }
    
    /**
     * Alustaa näppäimistökuuntelijan.
     */

    public void initKeyListener() {
        keylistener = new GameKeyListener(ship);
        this.addKeyListener(keylistener);
    }

    /**
     * Aluksen piirtämiseen mahdollistava metodi.
     *
     * @param g grafiikkaan tarvittava luokka
     */
    public void drawShip(Graphics g) {
        this.ship.draw(g);
    }

    /**
     * Käydään läpi kaikki asteroidit ja piirretään ne.
     *
     * @param g grafiikkaan tarvittava luokka
     */
    public void drawAsteroids(Graphics g) {
        if (!asteroidlist.isEmpty()) {
            for (Asteroid a : asteroidlist) {
                a.draw(g);
            }
        }
    }

    /**
     * Liikutetaan jokaista asteroidia.
     */
    public void updateAsteroids() {
        if (!asteroidlist.isEmpty()) {
            for (Asteroid a : asteroidlist) {
                a.move(w, h);
            }
        }
    }

    /**
     * Liikutetaan pelikentän kaikkia tarvittavia olioita
     */
    public void update() {
        ship.move(w, h);
        updateAsteroids();
    }

    /**
     * Pelin reaaliaikaisen toiminnan mahdollistava metodi.
     */
    public void run() {
        long lastTime = System.currentTimeMillis();
        while (running) {
            long now = System.currentTimeMillis();
            delta += (now - lastTime) / MILLIS;
            lastTime = now;
            while (delta >= 1) {
                update();
                this.repaint();
            }
        }
    }

    /**
     * JPanelilta peritty metodi, joka piirtää kaikki graafiset komponentit
     *
     * @param g grafiikkaan tarvittava luokka
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawShip(g);
        drawAsteroids(g);
    }
}
