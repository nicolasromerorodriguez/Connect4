/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tablero;

import Observador.*;
import java.util.List;

/**
 *
 * @author nicol
 */
public class Tablero implements IObservado {
    private static final int FILAS = 6;
    private static final int COLUMNAS = 7;
    private Ficha[][] tablero;
    private static Tablero instance;
    private List<IObservador> observadores; //Declaracion de la lista de observadores
    public char jugadorActual;
    
    //Cada metodo que altere el tablero debe llamar a notificar()

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

    
    //Metodos del observado
    @Override
    public void agregar(IObservador observador) {
        observadores.add(observador);
    }

    @Override
    public void eliminar(IObservador observador) {
        observadores.remove(observador);
    }

    @Override
    public void notificarObservadores() {
        for(IObservador observador : observadores){
            observador.actualizar();
        }
    }
}

