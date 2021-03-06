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

    int radius; // objektin osumaalueen säde
    double x, y; //objektin sijainti x,y-koordinaatteina
    double angle; //objektin keulan suunta
    double xVelocity, yVelocity; // objektin nopeuden x-, ja y-komponentit     
    boolean destroyed; //totuusarvo, jota voidaan käyttää objektin tuhoamiseen
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

    public BufferedImage getImage() {
        return img;
    }

    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    /**
     * Laskee objektin osumalueen säteen käyttämällä kuvan pienintä mittaa.
     */
    public void calculateRadius() {
        this.radius = Math.min(imageHalfHeight(), imageHalfWidth());
    }

    /**
     * Lasketaan kuvan keskikohta leveyssuunnassa. Tarvitaan kuvan keskipisteen
     * laskemiseen.
     *
     * @return kuvan keskikohta leveyssuunnassa
     */
    public int imageHalfWidth() {
        return img.getWidth() / 2;
    }

    /**
     * Lasketaan kuvan keskikohta korkeussuunnassa. Tarvitaan kuvan keskipisteen
     * laskemiseen.
     *
     * @return kuvan keskikohta korkeussuunnassa
     */
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
        angleCheck();
    }

    public int getRadius() {
        return this.radius;
    }

    public boolean checkCollision(GameObj other) {
        double xDeltaSquared = Math.pow(this.getX() - other.getX(), 2);
        double yDeltaSquared = Math.pow(this.getY() - other.getY(), 2);
        double distance = Math.sqrt(xDeltaSquared + yDeltaSquared);
        return distance <= (this.getRadius() + other.getRadius());
    }

    /**
     * Metodin avulla olion kulma pysyy 0..2*PI rajoissa.
     *
     */
    public void angleCheck() {
        if (this.angle < 0) {
            this.angle += 2 * Math.PI;
        }
        if (this.angle > (2 * Math.PI)) {
            this.angle -= 2 * Math.PI;
        }
    }

    /**
     * Liikutetaan oliota sen nopeuden mukaan.
     *
     * @param screenWidth pelikentän leveys
     * @param screenHeight pelikentän korkeus
     */
    public void move(int screenWidth, int screenHeight) {
        x += xVelocity;
        y += yVelocity;
        x = borderCheck(x, screenWidth);
        y = borderCheck(y, screenHeight);
    }

    /**
     * Tarkistetaan liikkuuko olion pelikentän rajojen yli ja jos näin tapahtuu,
     * ilmestyy olio kentän vastakkaiselle puolelle
     *
     * @param point tarkastettava x- tai y- koordinaatti
     * @param limit x- tai y -koordinaattia, joka on suurempi kuin nolla
     * @return tarkastettu piste
     */
    public double borderCheck(double point, int limit) {
        if (point < 0) {
            point += limit;
        } else if (point > limit) {
            point -= limit;
        }
        return point;
    }

    /**
     * Piirretään olio ja käännetään sitä keskipisteensä ympäri riippuen olion
     * kulmasta.
     *
     * @param g grafiikkaan tarvittava luokka
     */
    public void draw(Graphics g) {
        double xOffset = getX() - imageHalfWidth();
        double yOffset = getY() - imageHalfHeight();
        AffineTransform at = AffineTransform.getTranslateInstance(xOffset, yOffset);
        at.rotate(angle, imageHalfWidth(), imageHalfHeight());
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(img, at, null);

    }

}
