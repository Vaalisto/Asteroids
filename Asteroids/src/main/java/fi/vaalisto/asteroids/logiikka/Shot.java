/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.vaalisto.asteroids.logiikka;

import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Shot-luokka toteuttaa ammukset, joita pelaajan alus ampuu. 
 */
public class Shot extends GameObj {

    private static final double SHOT_SPEED = 4;
    private static final int INITIAL_LIFE = 100; // Ammuksen elinajan avulla saadaan niille tietty kantama.
    private static final String IMG_NAME = "shot.png";

    private int life;
    
    /**
     * Konstruktori luo ammuksen, jonka kulma ja nopeus riippuvat aluksen vastaavista
     * parametreista.
     * 
     * @param x ammuksen aloituspaikan x-koordinaatti
     * @param y ammuksen aloituspaikan y-koordinaatti
     * @param angle ammuksen lähtökulma
     * @param xVelocity ammuksen alukselta saaman nopeuden x-komponentti
     * @param yVelocity ammuksen alukselta saaman nopeuden y-komponentti
     */

    public Shot(double x, double y, double angle, double xVelocity, double yVelocity) {
        this.x = x;
        this.y = y;
        this.angle = angle;
        this.xVelocity = -SHOT_SPEED * Math.sin(angle) + xVelocity;
        this.yVelocity = SHOT_SPEED * Math.cos(angle) + yVelocity;
        this.life = INITIAL_LIFE;
        this.img = null;
        try {
            this.img = ImageIO.read(getClass().getClassLoader().getResourceAsStream(IMG_NAME));
        } catch (IOException e) {
            System.out.println("Shot picture missing!");
        }
    }

    public int getLife() {
        return life;
    }

    @Override
    public void move(int screenWidth, int screenHeight) {
        super.move(screenWidth, screenHeight);
        this.life--;
    }

}
