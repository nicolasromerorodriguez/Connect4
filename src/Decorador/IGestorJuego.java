/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Decorador;

/**
 *
 * @author nicol
 */

import Observador.*;
import javax.swing.*;
// Clase que representa el componente del patron decorator
public interface IGestorJuego extends IObservador{
    
    
    public void cambiarTurnoUI(JLabel label);
    public void cambiarTurno();
    public String comprobarGanador(int fila, int columna, int tipo);
    public int getTurnoActual();
   
}
