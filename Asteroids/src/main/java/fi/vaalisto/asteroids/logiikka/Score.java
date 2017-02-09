/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.vaalisto.asteroids.logiikka;

/**
 * Pisteiden tallentamista varten käytettävä luokka, jotka ovat verrattavissa
 * toisiinsa.
 */
public class Score implements Comparable<Score> {

    public int score;
    public String name;

    /**
     * Konstruktorilla luodaan olio, jonka avulla voidaan tallentaa
     * pelisuorituksen pistemäärä ja antaa sille puumerkki
     *
     * @param score talletettava pistemäärä
     * @param name talletettava nimi
     */
    Score(int score, String name) {
        this.score = score;
        this.name = name;
    }

    /**
     * Palauttaa olion pistemäärän.
     *
     * @return pisteet
     */
    public int getScore() {
        return score;
    }

    /**
     * Palauttaa olion nimen.
     *
     * @return nimi
     */
    public String getName() {
        return name;
    }

    /**
     * Verrataan olioden pistemäärää ja saadaan
     *
     * @param o verrattava olio
     * @return -1, 0 tai 1 riippuen vertailun tuloksesta
     */
    @Override
    public int compareTo(Score o) {
        return this.score - o.score;
    }

}
