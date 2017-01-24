package fi.vaalisto.asteroids.logiikka;

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

    public boolean isActive() {
        return active;
    }
    
    
    
}
