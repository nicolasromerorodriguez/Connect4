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
    private int contadorTurnos;

    public GestorJuegoContador(IGestorJuego gestorJuego) {
        super(gestorJuego);
        this.contadorTurnos = 0;
    }

     @Override
    public void actualizar() {
        super.gestorJuego.actualizar();
        contadorTurnos++;
    }

     @Override
    public void cambiarTurnoUI(JLabel label) {
        super.gestorJuego.cambiarTurnoUI(label);
    }

     @Override
    public void cambiarTurno() {
        super.gestorJuego.cambiarTurno();
    }

     @Override
    public String comprobarGanador(int fila, int columna, int tipo) {
        String mensaje = super.gestorJuego.comprobarGanador(fila, columna, tipo);
        
        if(mensaje == null){
            return null;
        }
        
        return  mensaje + " en un total de " + (int)Math.ceil((double)contadorTurnos/2) + " turnos";
    }

    
     @Override
    public int getTurnoActual() {
        return super.gestorJuego.getTurnoActual();
    }

    public int getContadorTurnos() {
        return contadorTurnos;
    }
    
    public void correctorTurnos(){
        contadorTurnos -=2;
    }
    
}
