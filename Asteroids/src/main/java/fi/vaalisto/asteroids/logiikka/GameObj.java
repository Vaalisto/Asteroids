package fi.vaalisto.asteroids.logiikka;

import java.awt.*;
import java.awt.geom.AffineTransform;
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

    public int imageHalfWidth() {
        return img.getWidth(null) / 2;
    }

    public int imageHalfHeight() {
        return img.getHeight(null) / 2;
    }

    public void setxVelocity(int xVelocity) {
        this.xVelocity = xVelocity;
    }

    public void setyVelocity(int yVelocity) {
        this.yVelocity = yVelocity;
    }

    public void setAngle(int angle) {
        this.angle = angle;
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

    public void draw(Graphics g) {
        int xOffset = getX() - imageHalfWidth();
        int yOffset = getY() - imageHalfHeight();
        AffineTransform at = AffineTransform.getTranslateInstance(xOffset, yOffset);
        at.rotate(Math.toRadians(angle));
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(img, at, null);
    }

}
