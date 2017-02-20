/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.vaalisto.asteroids.logiikka;

import java.util.ArrayList;

/**
 *
 * @author Ville Vaalisto
 */
public class EventHandler {

    private static final int NUMBER_OF_ASTEROIDS = 4; //asteroidien määrä alussa
    private static final int SHOT_LIMIT = 5; // yhtäaikaisten ammusten maksimimäärä

    public int x;
    public int y;
    public Ship ship;
    public ArrayList<Asteroid> asteroidlist;
    public ArrayList<Asteroid> deadasteroidlist;
    public ArrayList<Shot> shotlist;
    public ArrayList<Shot> deadshotlist;

    public EventHandler(int x, int y) {
        this.x = x;
        this.y = y;
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
            int randomX = (int) (Math.random() * x);
            int randomY = (int) (Math.random() * y);
            asteroidlist.add(new Asteroid(randomX, randomY));
        }
    }

    /**
     * Liikutetaan jokaista asteroidia ja tarkistetaan osumat muiden objektien kanssa.
     */
    public void updateAsteroids() {
        if (!asteroidlist.isEmpty()) {
            for (Asteroid a : asteroidlist) {
                a.checkShipCollision(ship);
                checkAsteroidAndShotCollision(a);
                if (a.isDestroyed()) {
                    deadasteroidlist.add(a);
                } else {
                    a.move(x, y);
                }
            }
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

    public void checkAsteroidAndShotCollisions() {

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

    public void cleanAsteroids() {
        if (!deadasteroidlist.isEmpty()) {
            asteroidlist.removeAll(deadasteroidlist);
        }
    }

}
