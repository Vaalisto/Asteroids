package fi.vaalisto.asteroids.logiikka;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.net.URL;

/**
 * Pelissä esiintyvien objektien abstrakti luokka
 *
 * @author Ville Vaalisto
 */
abstract class GameObj {

    double x, y; //objektin sijainti x,y-koordinaatteina
    double angle; //objektin keulan suunta
    double xVelocity, yVelocity; // objektin nopeuden x-, ja y-komponentit
    double acceleration; // objektin kiihtyvyys    
    boolean active; //totuusarvo, jota voidaan käyttää pelin tauottamiseksi
    BufferedImage img;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getAngle() {
        return angle;
    }

    public double getxVelocity() {
        return xVelocity;
    }

    public double getyVelocity() {
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
        return img.getWidth() / 2;
    }

    public int imageHalfHeight() {
        return img.getHeight() / 2;
    }

    public void setxVelocity(double xVelocity) {
        this.xVelocity = xVelocity;
    }

    public void setyVelocity(double yVelocity) {
        this.yVelocity = yVelocity;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }
    
    public void angleCheck(double angle) {
        if (angle < 0) {
            angle += 2 * Math.PI;
        }
        if (angle > (2 * Math.PI)) {
            angle -= 2 * Math.PI;
        }
    }

    public void move(int screenWidth, int screenHeight) {
        x += xVelocity;
        y += yVelocity;
        x = borderCheck(x, screenWidth);
        y = borderCheck(y, screenHeight);
    }

    public double borderCheck(double point, int limit) {
        if (point < 0) {
            point += limit;
        } else if (point > limit) {
            point -= limit;
        }
        return point;
    }

    public void draw(Graphics g) {
        double xOffset = getX() - imageHalfWidth();
        double yOffset = getY() - imageHalfHeight();
        AffineTransform at = AffineTransform.getTranslateInstance(xOffset, yOffset);
        at.rotate(angle, imageHalfWidth(), imageHalfHeight());
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(img, at, null);

    }

}
