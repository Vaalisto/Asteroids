package fi.vaalisto.asteroids.logiikka;

import java.awt.*;

/**
 *
 * @author Ville Vaalisto
 */
public class Ship extends GameObj {

    boolean accelerating; // totuusarvo siitä kiihdyttääkö alus. Alus on ainoa objekti, joka voi kiihdyttää.
    boolean turningLeft, turningRight; // totuusarvo siitä kääntyykö alus. Alus on ainoa objekti, joka voi kääntyä.

    /**
     * Ship-luokan konstruktori. Nämä jätetään muuttujiksi ja aluksen speksejä
     * voidaan muuttaa pelin toteuttavassa luokassa sen sijaan, että
     * kovakoodattaisiin tähän luokkaan.
     *
     * @param x aluksen aloituspaikan x-koordinaatti
     * @param y aluksen aloituspaikan y-koordinaatti
     * @param angle aluksen keulan kulma aluksi
     * @param xVelocity aluksen nopeuden x-komponentti alussa
     * @param yVelocity aluksen nopeuden y-komponentti alussa
     * @param acceleration aluksen kiihtyvyys
     */
    public Ship(double x, double y, double angle, double xVelocity, double yVelocity, double acceleration) {
        this.x = x;
        this.y = y;
        this.angle = angle;
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
        this.acceleration = acceleration;
        this.accelerating = false;
        this.turningLeft = false;
        this.turningRight = false;

    }

}
