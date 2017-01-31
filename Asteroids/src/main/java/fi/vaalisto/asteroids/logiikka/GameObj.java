package fi.vaalisto.asteroids.logiikka;

import java.awt.*;
import java.net.URL;

/**
 * Pelissä esiintyvien objektien abstrakti luokka
 *
 * @author Ville Vaalisto
 */
abstract class GameObj {

    int x, y; //objektin sijainti x,y-koordinaatteina
    int angle; //objektin keulan suunta
    int xVelocity, yVelocity; // objektin nopeuden x-, ja y-komponentit
    double acceleration; // objektin kiihtyvyys
    boolean active; //totuusarvo, jota voidaan käyttää pelin tauottamiseksi
    Image img;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getAngle() {
        return angle;
    }

    public int getxVelocity() {
        return xVelocity;
    }

    public int getyVelocity() {
        return yVelocity;
    }

    public double getAcceleration() {
        return acceleration;
    }
    
    public Image getImage() {
        return img;
    }

    public boolean isActive() {
        return active;
    }

    public void setxVelocity(int xVelocity) {
        this.xVelocity = xVelocity;
    }

    public void setyVelocity(int yVelocity) {
        this.yVelocity = yVelocity;
    }

    public void move(int screenWidth, int screenHeight) {
        x += xVelocity;
        y += yVelocity;
        if (x < 0) {
            x += screenWidth;
        } else if (x > screenWidth) {
            x -= screenWidth;
        }
        if (y < 0) {
            y += screenHeight;
        } else if (y > screenHeight) {
            y -= screenHeight;
        }
    }

}
