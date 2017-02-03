package fi.vaalisto.asteroids.logiikka;

import java.io.IOException;
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
        this.xVelocity = 0;
        this.yVelocity = 0;
        this.img = null;
        try {
            this.img = ImageIO.read(getClass().getClassLoader().getResourceAsStream("asteroid.png"));
        } catch (IOException e) {
            System.out.println("Asteroid picture missing!");
        }
    }

}
