package fi.vaalisto.asteroids.gui;

import fi.vaalisto.asteroids.logiikka.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Random;
import javax.swing.*;

/**
 * Screen-luokka toteuttaa pelikentän näkyvän osan ja myös aikasilmukan, joka
 * mahdollistaa pelin reaaliaikaisen toiminnan.
 *
 */
public class Screen extends JPanel implements Runnable {

    private static final int FPS = 60; //pelin päivitysnopeus    
    private static final double MILLIS = 1000 / FPS; //millisekunteja per kuvanpäivitys    

    public int w;
    public int h;
    public Ship ship;
    public ArrayList<Asteroid> asteroidlist;
    public ArrayList<Shot> shotlist;
    public ArrayList<Shot> deadshotlist;
    public GameKeyListener keylistener;
    public EventHandler eventhandler;    

    private boolean running = true;
    private boolean paused = false;

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
        this.shotlist = new ArrayList<Shot>();
        this.deadshotlist = new ArrayList<Shot>();
        this.setBackground(Color.BLACK);
        super.setSize(w, h);        
        this.setFocusable(true); //näppäimistökuuntelija ei toimi ilman tätä
        this.requestFocusInWindow(); //näppäimistökuuntelija ei toimi ilman tätä   
        this.setDoubleBuffered(true);
        this.eventhandler = new EventHandler(w, h);
        initKeyListener();
    }

    /**
     * Alustaa näppäimistökuuntelijan.
     */
    public void initKeyListener() {
        keylistener = new GameKeyListener(this.eventhandler.ship, this);
        this.addKeyListener(keylistener);
    }

    /**
     * Aluksen piirtämiseen mahdollistava metodi.
     *
     * @param g grafiikkaan tarvittava luokka
     */
    public void drawShip(Graphics g) {
        this.eventhandler.ship.draw(g);
        Toolkit.getDefaultToolkit().sync();
    }

    /**
     * Käydään läpi kaikki asteroidit ja piirretään ne.
     *
     * @param g grafiikkaan tarvittava luokka
     */
    public void drawAsteroids(Graphics g) {
        if (!this.eventhandler.asteroidlist.isEmpty()) {
            for (Asteroid a : this.eventhandler.asteroidlist) {
                a.draw(g);
                Toolkit.getDefaultToolkit().sync();
            }
        }
    }

    /**
     * Käydään läpi kaikki ammukset ja piirretään ne.
     *
     * @param g grafiikkaan tarvittava luokka
     */
    public void drawShots(Graphics g) {
        if (!this.eventhandler.shotlist.isEmpty()) {
            for (Shot s : this.eventhandler.shotlist) {
                s.draw(g);
                Toolkit.getDefaultToolkit().sync();
            }
        }
    }

    public void changePause() {
        if (this.paused) {
            this.paused = false;
        } else {
            this.paused = true;
        }
    }

    /**
     * Liikutetaan tai poistetaan pelikentällä olevia objekteja.
     */
    public void update() {
        if (!this.paused) {
            this.eventhandler.ship.move(w, h);
            this.eventhandler.updateAsteroids();
            this.eventhandler.updateShots();
            this.eventhandler.generateShots();
            this.eventhandler.cleanShots();
            this.eventhandler.cleanAsteroids();
        }
    }

    /**
     * Pelin reaaliaikaisen toiminnan mahdollistava metodi.
     */
    @Override
    public void run() {
        while (running) {
            long start = System.currentTimeMillis();
            update();
            this.repaint();
            float deltaTime = (System.currentTimeMillis() - start);
            int sleepTime = (int) (MILLIS - deltaTime);
            if (sleepTime > 0) {
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                }
            }
        }
    }

    /**
     * JPanelilta peritty metodi, joka piirtää kaikki graafiset komponentit.
     *
     * @param g grafiikkaan tarvittava luokka
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawShip(g);
        drawAsteroids(g);
        drawShots(g);
    }
}
