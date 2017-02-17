package fi.vaalisto.asteroids.gui;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Ville Vaalisto
 */
public class Game extends JFrame {

    public Screen screen;

    public Game() throws Exception {
        initComponents();

    }

    private void initComponents() {
        setTitle("Asteroids");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
//        getContentPane().setBackground(Color.BLACK);
        screen = new Screen(800, 600);
        this.add(screen);
        setVisible(true);
        Thread gameThread = new Thread(screen);
        gameThread.start();
//            screen.run();
    }
}
