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

 //Funciona como el decorador del patron decorator
public abstract class DecoradorGestorJuego implements IGestorJuego {
    protected IGestorJuego gestorJuego;

    public DecoradorGestorJuego(IGestorJuego gestorJuego) {
        this.gestorJuego = gestorJuego;
    }

    @Override
    public void actualizar() {
        gestorJuego.actualizar();
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
    public boolean comprobarGanador(int fila, int columna, int tipo) {
        return gestorJuego.comprobarGanador(fila, columna, tipo);
    }

    @Override
    public int getTurnoActual() {
        return gestorJuego.getTurnoActual();
    }
}
