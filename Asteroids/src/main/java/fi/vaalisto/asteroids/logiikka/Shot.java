/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.vaalisto.asteroids.logiikka;

import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Ville Vaalisto
 */
public class Shot extends GameObj {
    
    private static final int SHOT_SPEED = 8;
    private static final int INITIAL_LIFE = 40;

    private int life;

    public Shot(double x, double y, double angle, double xVelocity, double yVelocity) {
        this.x = x;
        this.y = y;
        this.angle = angle;
        this.xVelocity = SHOT_SPEED * xVelocity;
        this.yVelocity = SHOT_SPEED * yVelocity;
        this.life = INITIAL_LIFE;
        this.img = null;
        try {
            this.img = ImageIO.read(getClass().getClassLoader().getResourceAsStream("shot.png"));
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
