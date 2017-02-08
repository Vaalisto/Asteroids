package fi.vaalisto.asteroids.logiikka;

import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;

/**
 *
 * @author Ville Vaalisto
 */
public class Asteroid extends GameObj {

    public Asteroid(int x, int y) {
        this.x = x;
        this.y = y;
        this.angle = 0;        
        this.img = null;
        try {
            this.img = ImageIO.read(getClass().getClassLoader().getResourceAsStream("asteroid.png"));
        } catch (IOException e) {
            System.out.println("Asteroid picture missing!");
        }
        randomizeAsterdoid();
    }

    private void randomizeAsterdoid() {
        Random r = new Random();

        xVelocity = (0.000001 + (0.000002 - 0.000001) * r.nextDouble()) * (r.nextBoolean() ? 1 : -1);
        yVelocity = (0.000001 + (0.000002 - 0.000001) * r.nextDouble()) * (r.nextBoolean() ? 1 : -1);
    }

}
