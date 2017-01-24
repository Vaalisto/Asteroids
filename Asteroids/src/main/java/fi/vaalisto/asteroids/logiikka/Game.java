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

    public Game() throws Exception {
        initComponents();

    }
    
    private void initComponents() {
        setTitle("Asteroids");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setBackground(Color.BLACK);
    }
}
