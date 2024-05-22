/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tablero;

import Fabricas.FactoryAmarillas;
import Fabricas.FactoryRojas;
import Fichas.Ficha;
import Observador.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nicol
 */
public class Tablero implements IObservado {

    public static final int FILAS = 6;
    public static final int COLUMNAS = 7;
    public static final int AMARILLA = 1;
    public static final int ROJA = 2;
    private ArrayList<Ficha> fichas;
    private static Tablero instance;
    private ArrayList<IObservador> observadores; //Declaracion de la lista de observadores
    private FactoryAmarillas facAmarillas;
    private FactoryRojas facRojas;

    //Cada metodo que altere el tablero debe llamar a notificar()
    // Private constructor to prevent instantiation
    private Tablero() {
        observadores = new ArrayList<>();
        fichas = new ArrayList<>();
        facAmarillas = new FactoryAmarillas();
        facRojas = new FactoryRojas();
    }

    // Public method to provide access to the instance si
    public static Tablero getInstance() {
        if (instance == null) {
            instance = new Tablero();
        }
        return instance;
    }

    public int agregarFicha(int columna, int tipo) {
        int fila = 0;

        for (Ficha f : fichas) {

            if (f.getColumna() == columna) {
                
                if (fila > FILAS - 2){ return -1; }
                
                fila++;    
            }
        }

        
        switch (tipo) {
            case ROJA -> {
                fichas.add(facRojas.crearFicha(fila, columna));

            }
            case AMARILLA -> {
                fichas.add(facAmarillas.crearFicha(fila, columna));
            }
            default -> {
                System.out.println("hijueputa");
            }
        }

        notificarObservadores();

        return fila;
    }

    public ArrayList<Ficha> getFichas() {
        return fichas;
    }

    @Override
    public void agregarObservador(IObservador observador) {
        observadores.add(observador);
    }

    @Override
    public void eliminarObservador(IObservador observador) {
        observadores.remove(observador);
    }

    @Override
    public void notificarObservadores() {
        for (IObservador observador : observadores) {
            observador.actualizar();
        }
    }
}
