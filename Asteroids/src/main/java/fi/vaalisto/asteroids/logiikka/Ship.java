package fi.vaalisto.asteroids.logiikka;

import java.awt.*;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Ville Vaalisto
 */
public class Ship extends GameObj {

    private static final double TURN_RATE = 0.00005;

    boolean accelerating; // totuusarvo siitä kiihdyttääkö alus. Alus on ainoa objekti, joka voi kiihdyttää.
    boolean turningLeft, turningRight; // totuusarvo siitä kääntyykö alus. Alus on ainoa objekti, joka voi kääntyä.

    /**
     * Ship-luokan konstruktori. Nämä jätetään muuttujiksi ja aluksen speksejä
     * voidaan muuttaa pelin toteuttavassa luokassa sen sijaan, että
     * kovakoodattaisiin tähän luokkaan.
     *
     * @param x aluksen aloituspaikan x-koordinaatti
     * @param y aluksen aloituspaikan y-koordinaatti
     *
     */
    public Ship(int x, int y) {
        this.x = x;
        this.y = y;
        this.angle = 0;
        this.xVelocity = 0;
        this.yVelocity = 0;
        this.acceleration = 0.35; //mielivaltainen arvo tällä hetkellä.
        this.accelerating = false;
        this.turningLeft = false; //väliaikainen arvo testausta varten
        this.turningRight = true;
        this.img = null;
        try {
            this.img = ImageIO.read(getClass().getClassLoader().getResourceAsStream("ship.png"));

        } catch (IOException e) {
            System.out.println("Ship picture missing!");
        }

    }

    @Override
    public void move(int screenWidth, int screenHeight) {
        super.move(screenWidth, screenHeight);
        if (turningLeft) {
            angle -= TURN_RATE;
        }
        if (turningRight) {
            angle += TURN_RATE;
        }
    }

}
