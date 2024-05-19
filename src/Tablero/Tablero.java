/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tablero;

import Fichas.Ficha;

/**
 *
 * @author nicol
 */
public class Tablero {
    private static final int FILAS = 6;
    private static final int COLUMNAS = 7;
    private Ficha[][] tablero;
    private static Tablero instance;

    // Private constructor to prevent instantiation
    private Tablero() {
        tablero = new Ficha[FILAS][COLUMNAS];
    }

    // Public method to provide access to the instance si
    public static Tablero getInstance() {
        if (instance == null) {
            instance = new Tablero();
        }
        return instance;
    }

    // Getter for the board
    public Ficha[][] getTablero() {
        return tablero;
    }

    public void limpiar() {
        tablero = new Ficha[FILAS][COLUMNAS];
    }

}

