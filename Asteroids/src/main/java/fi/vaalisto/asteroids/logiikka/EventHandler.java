/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.vaalisto.asteroids.logiikka;

import java.util.ArrayList;

/**
 * EventHandler-luokka huolehtii pelin olioista ja käy erilaiset pelissä olevat
 * tapahtumat läpi.
 *
 */
public class EventHandler {

    private static final int NUMBER_OF_ASTEROIDS = 4; //asteroidien määrä alussa
    private static final int SHOT_LIMIT = 5; // yhtäaikaisten ammusten maksimimäärä
    private static final int STARTING_LEVEL = 1; //aloitetaan ykköstasolta
    private static final int KILL_VALUE = 50;

    public int x;
    public int y;
    public int level;
    public int score;
    public Ship ship;
    public ArrayList<Asteroid> asteroidlist;
    public ArrayList<Asteroid> deadasteroidlist;
    public ArrayList<Shot> shotlist;
    public ArrayList<Shot> deadshotlist;

    /**
     * Luodaan pelin olioita ja niiden välistä logiikkaa hoitava
     * tapahtumakäsittelijä.
     *
     * @param x peliruudun leveys
     * @param y peliruudun korkeus
     */
    public EventHandler(int x, int y) {
        this.x = x;
        this.y = y;
        this.level = STARTING_LEVEL;
        this.score = 0;
        this.asteroidlist = new ArrayList<Asteroid>();
        this.deadasteroidlist = new ArrayList<Asteroid>();
        this.shotlist = new ArrayList<Shot>();
        this.deadshotlist = new ArrayList<Shot>();
        this.initShip();
        this.initAsteroids();
    }

    /**
     * Asettaa pelaajan aluksen pelikentän keskelle.
     */
    public void initShip() {
        ship = new Ship(x / 2, y / 2);
    }

    /**
     * Alustaa halutun määrän uusia asteroideja ja satunnaisgeneroi niiden
     * sijainnit.
     */
    public void initAsteroids() {
        for (int i = 0; i < NUMBER_OF_ASTEROIDS; i++) {
            asteroidlist.add(generateAsteroidSafely());
        }
    }

    /**
     * Generoidaan satunnaiset x- ja y-koordinaatit tarkistaen onko se
     * turvallisen matkan päässä pelaajan aluksesta ja luodaan asteroidi, jos
     * näin on.
     *
     * @return turvallisen matkan päässä oleva asteroidi
     */
    public Asteroid generateAsteroidSafely() {
        while (true) {
            int randomX = (int) (Math.random() * x);
            int randomY = (int) (Math.random() * y);
            if (!ship.checkCollision(new AsteroidSpawner(randomX, randomY))) {
                return new Asteroid(randomX, randomY, calculateMultiplier());
            }
        }
    }

    /**
     * Liikuttaa pelaajan alusta, jos se ei ole tuhoutunut.
     */
    public void updateShip() {
        if (!ship.isDestroyed()) {
            ship.move(x, y);
        }
    }
    
    /**
     * Palautetaan totuusarvo, onko alus tuhoutunut.
     * 
     * @return onko alus tuhoutunut
     */
    public boolean shipIsDead() {
        return ship.isDestroyed();
    }

    /**
     * Liikutetaan jokaista asteroidia ja tarkistetaan osumat muiden objektien
     * kanssa.
     */
    public void updateAsteroids() {
        if (!asteroidlist.isEmpty()) {
            for (Asteroid a : asteroidlist) {
                a.checkShipCollision(ship);
                checkAsteroidAndShotCollision(a);
                if (a.isDestroyed()) {
                    deadasteroidlist.add(a);
                    score += KILL_VALUE;
                } else {
                    a.move(x, y);
                }
            }
        } else {
            initAsteroids();
            this.level++;
        }
    }

    /**
     * Iteroidaan ammuslista läpi asteroidia kohden ja tarkistetaan osumat.
     *
     * @param asteroid tarkasteltava yksittäinen asteroidi
     */
    public void checkAsteroidAndShotCollision(Asteroid asteroid) {
        if (!shotlist.isEmpty()) {
            for (Shot s : shotlist) {
                asteroid.checkShotCollision(s);
            }
        }
    }

    /**
     * Tarkistetaan onko jokin asteroideista osunut alukseen.
     */
    public void checkAsteroindAndShipCollision() {
        if (!asteroidlist.isEmpty()) {
            for (Asteroid a : asteroidlist) {
                a.checkShipCollision(ship);
            }
        }
    }

    /**
     * Liikutetaan jokaista ammusta.
     */
    public void updateShots() {
        if (!shotlist.isEmpty()) {
            for (Shot s : shotlist) {
                s.move(x, y);
                if (s.getLife() <= 0 || s.isDestroyed()) {
                    deadshotlist.add(s);
                }
            }
        }
    }
    
    /**
     * Kutsuu jokaista päivitys- ja siivousmetodia.
     */

    public void updateAll() {
        updateShip();
        updateAsteroids();
        updateShots();
        generateShots();
        cleanAsteroids();
        cleanShots();
    }

    /**
     * Sallii ammuksen luomisen, jos täytetään ehdot. Ehtoina on aluksen
     * tulinopeus, ammuslistan koko ja että ampumispainike on painettuna.
     */
    public void generateShots() {
        if (ship.getShootDelay() <= 0 && ship.isShooting() && shotlist.size() <= SHOT_LIMIT) {
            shotlist.add(ship.shoots());
        }
    }

    /**
     * Poistaa ammukset, jotka on lisätty siivouslistalle.
     */
    public void cleanShots() {
        if (!deadshotlist.isEmpty()) {
            shotlist.removeAll(deadshotlist);
        }
    }

    /**
     * Poistaa asteroidit, jotka on lisätty siivouslistalle.
     */
    public void cleanAsteroids() {
        if (!deadasteroidlist.isEmpty()) {
            asteroidlist.removeAll(deadasteroidlist);
        }
    }
    
    /**
     * Alustetaan peli uutta pelikertaa varten.
     */

    public void reset() {
        level = STARTING_LEVEL;
        score = 0;
        asteroidlist = new ArrayList<Asteroid>();
        deadasteroidlist = new ArrayList<Asteroid>();
        shotlist = new ArrayList<Shot>();
        deadshotlist = new ArrayList<Shot>();
        initShip();
        initAsteroids();
    }

    public int getLevel() {
        return level;
    }

    public int getScore() {
        return score;
    }

    /**
     * Lasketaan nopeuskerroin asteroideille riippuen kuinka pitkälle peli on
     * edennyt.
     *
     * @return kerroin asteroidien nopeudelle
     */
    private double calculateMultiplier() {
        return this.level / 10 + 0.9;
    }

}
