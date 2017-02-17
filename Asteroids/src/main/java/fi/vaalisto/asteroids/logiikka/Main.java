package fi.vaalisto.asteroids.logiikka;

import fi.vaalisto.asteroids.gui.Game;

/**
 * Main-luokka käynnistää ohjelman.
 */
public class Main {

    /**
     * Käynnistää ohjelman.
     *
     * @param args ei käytetä
     * @throws Exception poikkeus ohjelman aikana
     */
    public static void main(String[] args) throws Exception {
        Game game = new Game();
        game.setVisible(true);
    }

}
