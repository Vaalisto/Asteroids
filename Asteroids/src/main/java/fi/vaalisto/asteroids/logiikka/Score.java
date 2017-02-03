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
    String name;

    Score(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Score o) {
        return this.score - o.score;
    }

}
