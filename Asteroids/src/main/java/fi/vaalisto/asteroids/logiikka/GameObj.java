package fi.vaalisto.asteroids.logiikka;

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
    
}
