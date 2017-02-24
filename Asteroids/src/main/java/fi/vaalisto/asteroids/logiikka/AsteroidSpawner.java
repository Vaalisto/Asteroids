package fi.vaalisto.asteroids.logiikka;

/**
 * AsteroidSpawneria käytetään tarkistamaan, että generoitava asteroidia on
 * turvallisen matkan päässä aluksesta.
 *
 */
public class AsteroidSpawner extends GameObj {

    /**
     * Konstruktori luo "ympyrän", jonka avulla tarkistetaan onko alus sen
     * sisällä. Jos ei ole, niin ympyrän keskipisteeseen voidaan luoda
     * asteroidi.
     *
     * @param x x-koordinaatti
     * @param y y-koordinaatti
     */
    public AsteroidSpawner(int x, int y) {
        this.x = x;
        this.y = y;
        this.radius = 75;
    }

}
