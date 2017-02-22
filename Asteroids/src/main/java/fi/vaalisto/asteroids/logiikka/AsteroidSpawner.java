package fi.vaalisto.asteroids.logiikka;

/**
 * AsteroidSpawneria käytetään tarkistamaan, että generoitava asteroidia on
 * turvallisen matkan päässä aluksesta.
 *
 */
public class AsteroidSpawner extends GameObj {

    public AsteroidSpawner(int x, int y) {
        this.x = x;
        this.y = y;
        this.radius = 75;
    }

}
