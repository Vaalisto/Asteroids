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
abstract class GameObj {
    double x, y; //objektin sijainti x,y-koordinaatteina
    double angle; //objektin keulan suunta
    double xVelocity, yVelocity; // objektin nopeuden x-, ja y-komponentit
    double acceleration; // objektin kiihtyvyys
    
}
