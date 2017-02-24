package fi.vaalisto.asteroids.logiikka;

import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;

/**
 * Asteroidi-luokka toteuttaa asteroidit, joita pelaaja yrittää väistellä ja
 * tuhota.
 *
 */
public class Asteroid extends GameObj {

    private static final String IMG_NAME = "asteroid.png";
    private static final double MIN_SPEED = 0.75;
    private static final double MAX_SPEED = 1.5;
    private static final double MIN_TURN_RATE = 0.01;
    private static final double MAX_TURN_RATE = 0.05;

    private double turnrate;

    /**
     * Asteroidin konstruktori, joka asettaa sen haluttiin pisteeseen, lataa
     * kuvan ja generoi sille satunnaisen nopeuden ja sen suunnan.
     *
     * @param x asteroidin aloituspaikan x-koordinaatti
     * @param y asteroidin aloituspaikan y-koordinaatti
     * @param multiplier asteroidin nopeuskerroin
     */
    public Asteroid(int x, int y, double multiplier) {
        this.x = x;
        this.y = y;
        this.angle = 0;
        this.img = null;
        try {
            this.img = ImageIO.read(getClass().getClassLoader().getResourceAsStream(IMG_NAME));
        } catch (IOException e) {
            System.out.println("Asteroid picture missing!");
        }
        calculateRadius();
        randomizeAsterdoid(multiplier);
    }

    /**
     * Tarkistaa törmääkö asteroidi alukseen.
     *
     * @param ship pelaajan alus
     */
    public void checkShipCollision(Ship ship) {
        if (checkCollision(ship)) {
            ship.setDestroyed(true);
        }
    }

    /**
     * Tarkistaa törmääkö asteroidi ammukseen.
     *
     * @param shot ammus
     */
    public void checkShotCollision(Shot shot) {
        if (checkCollision(shot)) {
            shot.setDestroyed(true);
            this.setDestroyed(true);
        }
    }

    private void turn() {
        this.angle += turnrate;
    }

    /**
     * Arvotaan asteroidille satunnaiset nopeusvektorit.
     */
    private void randomizeAsterdoid(double multiplier) {
        Random r = new Random();
        turnrate = (MIN_TURN_RATE + (MAX_TURN_RATE - MIN_TURN_RATE) * r.nextDouble()) * (r.nextBoolean() ? 1 : -1);
        xVelocity = multiplier * (MIN_SPEED + (MAX_SPEED - MIN_SPEED) * r.nextDouble()) * (r.nextBoolean() ? 1 : -1);
        yVelocity = multiplier * (MIN_SPEED + (MAX_SPEED - MIN_SPEED) * r.nextDouble()) * (r.nextBoolean() ? 1 : -1);
    }

    @Override
    public void move(int screenWidth, int screenHeight) {
        super.move(screenWidth, screenHeight);
        turn();
        angleCheck();
    }

}
