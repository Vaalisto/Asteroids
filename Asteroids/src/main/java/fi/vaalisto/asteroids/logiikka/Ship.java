package fi.vaalisto.asteroids.logiikka;

import java.awt.*;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Ship-luokka toteuttaa pelaajan ohjaaman aluksen.
 *
 */
public class Ship extends GameObj {

    private static final double TURN_RATE = 0.000001; //aluksen kääntymisnopeus
    private static final double SPEED_LIMIT = 0.00003; //aluksen maksiminopeus
    private static final double ACCELERATION = 0.000000000005; //aluksen kiihtyvyys
    private static final int SHOOT_DELAY_RESET = 10;
    private static final String IMG_NAME = "ship.png";

    public boolean accelerating; // totuusarvo siitä kiihdyttääkö alus. Alus on ainoa objekti, joka voi kiihdyttää.
    public boolean turningLeft, turningRight; // totuusarvo siitä kääntyykö alus. Alus on ainoa objekti, joka voi kääntyä.
    public boolean shooting;
    public int shootDelay;

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
        this.accelerating = false; //väliaikainen arvo testausta varten
        this.turningLeft = false; //väliaikainen arvo testausta varten
        this.turningRight = false;
        this.shooting = false;
        this.shootDelay = 0;
        this.img = null;
        try {
            this.img = ImageIO.read(getClass().getClassLoader().getResourceAsStream(IMG_NAME));

        } catch (IOException e) {
            System.out.println("Ship picture missing!");
        }

    }

    public boolean isAccelerating() {
        return accelerating;
    }

    public void setAccelerating(boolean accelerating) {
        this.accelerating = accelerating;
    }

    public boolean isTurningLeft() {
        return turningLeft;
    }

    public void setTurningLeft(boolean turningLeft) {
        this.turningLeft = turningLeft;
    }

    public boolean isTurningRight() {
        return turningRight;
    }

    public void setTurningRight(boolean turningRight) {
        this.turningRight = turningRight;
    }

    public boolean isShooting() {
        return shooting;
    }

    public void setShooting(boolean shooting) {
        this.shooting = shooting;
    }

    public int getShootDelay() {
        return shootDelay;
    }

    public Shot shoots() {
        this.shootDelay = SHOOT_DELAY_RESET;
        return new Shot(this.x, this.y, this.angle);
    }

    /**
     * Lasketaan nopeuskomponenttien summavektorin pituus, jotta voidaan pitää
     * se maksiminopeuden rajoissa.
     *
     * @param xComponent aluksen nopeuden x-komponentti
     * @param yComponent aluksen nopeuden y-komponentti
     * @return summavektorin pituus
     */
    private double sumSpeedVector(double xComponent, double yComponent) {
        return Math.sqrt((xComponent * xComponent) + (yComponent * yComponent));
    }

    /**
     * Alukselle laajennettu liikkuminen. Alus on aina olio, joka voi kääntyä ja
     * kiihtyä. *
     *
     * @param screenWidth pelikentän leveys
     * @param screenHeight peikentän korkeus
     */
    @Override
    public void move(int screenWidth, int screenHeight) {
        super.move(screenWidth, screenHeight);
        if (turningLeft) {
            angle -= TURN_RATE;
        }
        if (turningRight) {
            angle += TURN_RATE;
        }
        angleCheck();
        if (accelerating) {
            double deltaXVel = ACCELERATION * Math.sin(angle);
            double deltaYVel = ACCELERATION * Math.cos(angle);
            double newXVel = xVelocity + deltaXVel;
            double newYVel = yVelocity + deltaYVel;
            double newSpeed = sumSpeedVector(newXVel, newYVel);
            if (newSpeed < SPEED_LIMIT) {
                xVelocity -= deltaXVel;
                yVelocity += deltaYVel;
            }

        }
        if (shootDelay > 0) {
            shootDelay--;
        }
    }

}
