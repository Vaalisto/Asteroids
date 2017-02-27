package fi.vaalisto.asteroids.gui;

import java.awt.*;
import javax.swing.*;

/**
 * Luokka on pelin ikkuna, jolle on määritelty tietty koko.
 */
public class Game extends JFrame {

    public Screen screen;
    public JLabel statusbar;

    /**
     * Konstruktori luo uuden JFramen, jonka sisällä pyörii itse peli.
     */
    public Game() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Asteroids");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        screen = new Screen(800, 600);
        this.add(screen);
        setVisible(true);        
        Thread gameThread = new Thread(screen);
        gameThread.start();
//            screen.run();
    }
    
    public JLabel getStatusBar() {
        return statusbar;
    }
}
