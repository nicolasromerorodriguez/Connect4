/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tablero;

import Fichas.Ficha;
import Observador.IObservador;
import java.awt.Color;
import java.util.Random;
import javax.swing.JLabel;

/**
 *
 * @author cesar
 */
public class GestorJuego implements IObservador {
    
    //Parte de los observadores
    //Maneja el orden de los turnos, define ganador

    private int turnoActual;
    private GestorAcciones acciones;

    public GestorJuego(GestorAcciones acciones) {
        Random r = new Random();

        // Se elige al azar amarillo o rojo de quien empieza el juego
        this.turnoActual = r.nextInt(Tablero.AMARILLA, Tablero.ROJA + 1);
        this.acciones = acciones;

    }

    @Override
    public void actualizar() {
        
        cambiarTurno();
        cambiarTurnoUI(acciones.getVista().labTurno);
    }

    public void cambiarTurnoUI(JLabel label) {
        switch (turnoActual) {
            case Tablero.AMARILLA -> {
                label.setText("AMARILLAS");
                label.setForeground(new Color(252, 227, 136));
            }
            case Tablero.ROJA -> {
                label.setText("ROJAS");
                label.setForeground(new Color(252, 121, 121));
            }
        }
    }

    //Metodo para cambiar de turno
    public void cambiarTurno() {
        switch (turnoActual) {
            case Tablero.AMARILLA -> {
                turnoActual = Tablero.ROJA;
            }
            case Tablero.ROJA -> {
                turnoActual = Tablero.AMARILLA;
            }
        }
    }

    //Metodo para comprobar el ganador
    public boolean comprobarGanador(int fila, int columna, int tipo) {

        int[][] direcciones = {
            {-1, 0}, // Abajo
            {0, 1}, // Derecha
            {0, -1}, // Izquierda
            {1, 1}, // Arriba a la derecha
            {-1, -1}, // Abajo a la izquierda
            {-1, 1}, // Abajo a la derecha
            {1, -1} // Arriba a la izquierda
        };
        
        int totalLinea = 1;
        // Recorrer cada dirección
        for (int[] direccion : direcciones) {
            int factorFila = direccion[0];
            int factorColumna = direccion[1];
            totalLinea += comprobarDireccion(fila, columna, tipo, factorFila, factorColumna);
            
            if (totalLinea >= 4) {
                return true;
            }
            
            // Se reinicia cuando cambia de direccion principal
            if (direccion == direcciones[0] || direccion == direcciones[2] ||
                    direccion == direcciones[4]){
                totalLinea = 1;
            }
        }

        return false;
    }

    private int comprobarDireccion(int fila, int columna, int tipo, int factorFila, int factorColumna) {
        int fichasEnFila = 0;
        Ficha[][] fichas = acciones.getTablero().getFichas();
        String nombreTipo;
        if(tipo == Tablero.ROJA) nombreTipo = "ROJA";
        else { nombreTipo = "AMARILLA"; }

        // Comprobar del 1 al 3
        for (int i = 1; i < 4; i++) {
            try {
                
                // Cuando no hay ficha en la direccion
                if (fichas[fila + (factorFila * i)][columna + (factorColumna * i)] == null) {
                    break;
                }

                // Cuenta fichas en linea hasta llegar a 3
                if (fichas[fila + factorFila * i][columna + (factorColumna * i)]
                    .getTipo().getNombre().equals(nombreTipo)) {
                    
                    fichasEnFila++;
                } else {
                    break;
                }
            } catch (IndexOutOfBoundsException e) {
                
            }
            
        }

        return fichasEnFila;
    }

    public int getTurnoActual() {
        return turnoActual;
    }

}
