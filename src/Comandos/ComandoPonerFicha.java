/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comandos;

import Fabricas.FactoryAmarillas;
import Fabricas.FactoryRojas;
import Fichas.Ficha;
import Tablero.Tablero;
import static Tablero.Tablero.AMARILLA;
import static Tablero.Tablero.FILAS;
import static Tablero.Tablero.ROJA;

/**
 *
 * @author nicol
 */
public class ComandoPonerFicha extends Comando {

    private int columna;
    private int tipo;
    private FactoryAmarillas facAmarillas;
    private FactoryRojas facRojas;

    
    // Define columna en que se va a poner la ficha y su tipo
    public ComandoPonerFicha(int columna, int tipo, Tablero tablero) {
        super(tablero);
        this.columna = columna;
        this.tipo = tipo;
        this.facAmarillas = new FactoryAmarillas();
        this.facRojas = new FactoryRojas();
    }

    @Override
    public int execute() {

        backup();

        int fila = 0;

        for (Ficha[] fichasFila : tablero.getFichas()) {

            for (Ficha f : fichasFila) {
                
                if (f == null){
                    continue;
                }
                
                // Cuenta las fichas que ya hay en la columna en la que se va a colocar
                if (f.getColumna() == columna) {
                    
                    // Ya está llena la columna
                    if (fila > FILAS - 2) {
                        return -1;
                    }

                    fila++;
                }
            }
        }
        
        // Usa las factorías para crear la ficha a colocar en el tablero
        switch (tipo) {
            case ROJA -> {
                tablero.getFichas()[fila][columna] = facRojas.crearFicha(fila, columna);

            }
            case AMARILLA -> {
                tablero.getFichas()[fila][columna] = facAmarillas.crearFicha(fila, columna);
            }
            default -> {

            }
        }

        tablero.notificarObservadores();

        return fila;
    }

}
