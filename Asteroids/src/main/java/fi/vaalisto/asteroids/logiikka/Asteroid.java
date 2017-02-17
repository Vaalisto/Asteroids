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
        randomizeAsterdoid();
    }

    /**
     * Arvotaan asteroidille satunnaiset nopeusvektorit.
     */
    private void randomizeAsterdoid() {
        Random r = new Random();

        xVelocity = (0.000001 + (0.000002 - 0.000001) * r.nextDouble()) * (r.nextBoolean() ? 1 : -1);
        yVelocity = (0.000001 + (0.000002 - 0.000001) * r.nextDouble()) * (r.nextBoolean() ? 1 : -1);
    }

}
