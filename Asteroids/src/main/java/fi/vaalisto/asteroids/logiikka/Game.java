/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.vaalisto.asteroids.logiikka;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Ville Vaalisto
 */
public class Game extends JFrame {
    
    Graphics g;
    
    public Game() throws Exception {
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setBackground(Color.BLACK);
        
    }
}
