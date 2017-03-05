package fi.vaalisto.asteroids.logiikka;

import java.awt.*;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Ship-luokka toteuttaa pelaajan ohjaaman aluksen.
 *
 */
public class Ship extends GameObj {

    private static final double TURN_RATE = 0.1; //aluksen kääntymisnopeus
    private static final double SPEED_LIMIT = 1.5; //aluksen maksiminopeus
    private static final double ACCELERATION = 0.1; //aluksen kiihtyvyys
    private static final double VELOCITY_DECAY = 0.98; //aluksen "kitka"
    private static final int SHOOT_DELAY_RESET = 30;
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
        this.destroyed = false;
        this.shootDelay = 0;        
        this.img = null;
        try {
            this.img = ImageIO.read(getClass().getClassLoader().getResourceAsStream(IMG_NAME));

        } catch (IOException e) {
            System.out.println("Ship picture missing!");
        }
        calculateRadius();

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

    /**
     * Aluksen ampuessa tehdään uusi Shot-olio.
     *
     * @return Shot-olio, joka näkyy pelissä ammusena.
     */
    public Shot shoots() {
        this.shootDelay = SHOOT_DELAY_RESET;
        return new Shot(this.x, this.y, this.angle, this.xVelocity, this.yVelocity);
    }

    /**
     * Aluksen liikkumismetodin kääntymismetodi.
     */
    private void turn() {
        if (turningLeft) {
            angle -= TURN_RATE;
        }
        if (turningRight) {
            angle += TURN_RATE;
        }
    }
    
    /**
     * Aluksen liikkumismetodin kiihdyttämismetodi.
     */

    private void accelerate() {
        if (accelerating) {
            xVelocity -= ACCELERATION * Math.sin(angle);
            yVelocity += ACCELERATION * Math.cos(angle);
        }
    }
    
    /**
     * Aluksen liikkumismetodin nopeutta vähentävä metodi.
     */

    private void decaySpeed() {
        xVelocity *= VELOCITY_DECAY;
        yVelocity *= VELOCITY_DECAY;
    }
    
    /**
     * Vähentää laskuria, jolla määritellään aluksen tulinopeus.
     */
    private void decreaseShotDelay() {
        if (shootDelay > 0) {
            shootDelay--;
        }
    }

    /**
     * Alukselle laajennettu liikkuminen. Alus on ainoa olio, joka voi kääntyä
     * ja kiihtyä. Metodi on jaettu useampaan metodiin.
     *
     * @param screenWidth pelikentän leveys
     * @param screenHeight peikentän korkeus
     */
    @Override
    public void move(int screenWidth, int screenHeight) {
        super.move(screenWidth, screenHeight);
        turn();
        angleCheck();
        accelerate();
        decaySpeed();
        decreaseShotDelay();
    }

}
