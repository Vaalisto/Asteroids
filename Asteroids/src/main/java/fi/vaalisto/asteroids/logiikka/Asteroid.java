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

    /**
     * Asteroidin konstruktori, joka asettaa sen haluttiin pisteeseen, lataa
     * kuvan ja generoi sille satunnaisen nopeuden ja sen suunnan.
     *
     * @param x asteroidin aloituspaikan x-koordinaatti
     * @param y asteroidin aloituspaikan y-koordinaatti
     */
    public Asteroid(int x, int y) {
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
        randomizeAsterdoid();
    }

    /**
     * Arvotaan asteroidille satunnaiset nopeusvektorit.
     */
    private void randomizeAsterdoid() {
        Random r = new Random();
        
        xVelocity = (MIN_SPEED + (MAX_SPEED - MIN_SPEED) * r.nextDouble()) * (r.nextBoolean() ? 1 : -1);
        yVelocity = (MIN_SPEED + (MAX_SPEED - MIN_SPEED) * r.nextDouble()) * (r.nextBoolean() ? 1 : -1);
    }

}
