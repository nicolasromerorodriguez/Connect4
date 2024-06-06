/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tablero;

import Comandos.Comando;
import Comandos.HistorialComando;
import Fabricas.FactoryAmarillas;
import Fabricas.FactoryRojas;
import Fichas.Ficha;
import Observador.*;
import java.util.ArrayList;
import java.util.List;

import Decorador.*;
/**
 *
 * @author nicol
 */
public class Tablero implements IObservado {
    
    //Esta clase representa el tablero

    public static final int FILAS = 6;  //Constante que define el numero de filas del tablero
    public static final int COLUMNAS = 7; //Constante que define el numero de columnas del tablero
    public static final int AMARILLA = 1; //Establece el numero de jugador que epresentan las fichas amarillas
    public static final int ROJA = 2; //Establece el numero de jugador que epresentan las fichas rojas
    private Ficha[][] fichas; //Define una matriz de fichas para establecer el tableo
    private static Tablero instance; //Referencia a la unica innstancia del tablero
    private ArrayList<IObservador> observadores; //Declaracion de la lista de observadores
    
    private HistorialComando history;
    
    
   
    
    
    

    // Cada metodo que altere el tablero debe llamar a notificar()
    // Private constructor to prevent instantiation
    private Tablero() {
        
        //Instancias de las clases anteriores
        history = new HistorialComando();
        observadores = new ArrayList<>();
        fichas = new Ficha[FILAS][COLUMNAS];  //Define el tablero como un arreglo de 
        
    }

    // Metodo publico que da acceso a la instancia del tablero 
    public static Tablero getInstance() {
        if (instance == null) {
            instance = new Tablero();
        }
        return instance;
    }


    //Metodos implementados de IObservado para el patron observer
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
    
    //metodo que permite realizar jugadas
    public int executeCommand(Comando command) {
        int filaFicha = command.execute();
        if (filaFicha != -1) {
            history.push(command);
        }
        return filaFicha;
    }
    
    public void restaurarMovimiento() {
        if (history.isEmpty()) return;

        Comando command = history.pop();
        if (command != null) {
            command.undo();
            
        }
        
    }

    public Ficha[][] getFichas() {
        return fichas;
    }

    public void setFichas(Ficha[][] fichas) {
        this.fichas = fichas;
    }
    
    public void vaciar(){
        fichas = new Ficha[FILAS][COLUMNAS];
        notificarObservadores();
        history = new HistorialComando();
    }
    
    
}
