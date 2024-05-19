/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tablero;

/**
 *
 * @author nicol
 */
public class Tablero {
    private static final int FILAS = 6;
    private static final int COLUMNAS = 7;
    private char[][] tablero;
    private static Tablero instance;

    // Private constructor to prevent instantiation
    private Tablero() {
        tablero = new char[FILAS][COLUMNAS];
        inicializarTablero();
    }

    // Public method to provide access to the instance si
    public static Tablero getInstance() {
        if (instance == null) {
            instance = new Tablero();
        }
        return instance;
    }

    // Method to initialize the board
    private void inicializarTablero() {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                tablero[i][j] = ' ';
            }
        }
    }

    // Getter for the board
    public char[][] getTablero() {
        return tablero;
    }

    // Method to reset the board
   /* public void reiniciar() {
        inicializarTablero();
    }*/

    // Method to display the board (optional for console debugging)
    /*public void displayBoard() {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                System.out.print("|" + tablero[i][j]);
            }
            System.out.println("|");
        }
        for (int j = 0; j < COLUMNAS; j++) {
            System.out.print(" " + j);
        }
        System.out.println();
    }*/
}

