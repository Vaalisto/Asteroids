/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.vaalisto.asteroids.logiikka;

/**
 *
 * @author Ville Vaalisto
 */
public class Score implements Comparable<Score> {

    int score;

    Score(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    @Override
    public int compareTo(Score o) {
        return this.score - o.score;
    }

}
