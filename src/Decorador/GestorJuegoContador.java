/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Decorador;

import javax.swing.JLabel;

/**
 *
 * @author nicol
 */

//Funciona como el decrador concreto del patron decorator
public class GestorJuegoContador extends DecoradorGestorJuego {
     private IGestorJuego gestorJuego;
    private int contadorTurnos;

    public GestorJuegoContador(IGestorJuego gestorJuego) {
        super(gestorJuego);
        this.contadorTurnos = 0;
    }

     @Override
    public void actualizar() {
        gestorJuego.actualizar();
        contadorTurnos++;
    }

     @Override
    public void cambiarTurnoUI(JLabel label) {
        gestorJuego.cambiarTurnoUI(label);
    }

     @Override
    public void cambiarTurno() {
        gestorJuego.cambiarTurno();
    }

     @Override
    public String comprobarGanador(int fila, int columna, int tipo) {
        return gestorJuego.comprobarGanador(fila, columna, tipo) +
                " en un total de " + ((contadorTurnos/2) + 1) + " turnos";
    }

    
     @Override
    public int getTurnoActual() {
        return gestorJuego.getTurnoActual();
    }

    public int getContadorTurnos() {
        return contadorTurnos;
    }
    
    public void correctorTurnos(){
        contadorTurnos -=2;
    }
    
}
