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
 * @author cesar
 */
public class ComandoPonerFicha extends Command {

    private int columna;
    private int tipo;
    private FactoryAmarillas facAmarillas;
    private FactoryRojas facRojas;

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

        for (Ficha[] row : tablero.getFichas()) {

            for (Ficha f : row) {
                if (f == null){
                    continue;
                }
                if (f.getColumna() == columna) {

                    if (fila > FILAS - 2) {
                        return -1;
                    }

                    fila++;
                }
            }
        }

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
