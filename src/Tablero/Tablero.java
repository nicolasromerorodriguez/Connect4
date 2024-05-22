/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tablero;

import Comandos.Command;
import Comandos.CommandHistory;
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
    
    private CommandHistory history;

    // Cada metodo que altere el tablero debe llamar a notificar()
    // Private constructor to prevent instantiation
    private Tablero() {
        history = new CommandHistory();
        observadores = new ArrayList<>();
        fichas = new ArrayList<>();
        
    }

    // Public method to provide access to the instance si
    public static Tablero getInstance() {
        if (instance == null) {
            instance = new Tablero();
        }
        return instance;
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
    
    public int executeCommand(Command command) {
        int filaFicha = command.execute();
        if (filaFicha != -1) {
            history.push(command);
        }
        return filaFicha;
    }
    
    public void restaurarMovimiento() {
        if (history.isEmpty()) return;

        Command command = history.pop();
        if (command != null) {
            command.undo();
            
        }
        
    }

    public void setFichas(ArrayList<Ficha> fichas) {
        this.fichas = fichas;
    }
    
    
    
}
