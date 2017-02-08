package fi.vaalisto.asteroids.logiikka;

import java.awt.*;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Ville Vaalisto
 */
public class Ship extends GameObj {

    private static final double TURN_RATE = 0.000001;
    private static final double SPEED_LIMIT = 0.00003;

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
        this.angle = Math.PI/6;
        this.xVelocity = 0;
        this.yVelocity = 0;
        this.acceleration = 0.000000000005; //mielivaltainen arvo tällä hetkellä.
        this.accelerating = true;
        this.turningLeft = true; //väliaikainen arvo testausta varten
        this.turningRight = false;
        this.img = null;
        try {
            this.img = ImageIO.read(getClass().getClassLoader().getResourceAsStream("ship.png"));

        } catch (IOException e) {
            System.out.println("Ship picture missing!");
        }

    }

    private double sumSpeedVector(double xComponent, double yComponent) {
        return Math.sqrt((xComponent * xComponent) + (yComponent * yComponent));
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
        this.angleCheck(angle);
        if (accelerating) {
            double deltaXVel = acceleration * Math.sin(angle);
            double deltaYVel = acceleration * Math.cos(angle);
            double newXVel = xVelocity + deltaXVel;
            double newYVel = yVelocity + deltaYVel;
            double newSpeed = sumSpeedVector(newXVel, newYVel);
            if (newSpeed < SPEED_LIMIT) {
                xVelocity -= deltaXVel;
                yVelocity += deltaYVel;
            }
            
        }
    }

}
