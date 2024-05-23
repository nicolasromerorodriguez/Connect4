/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fabricas;

import Fichas.Ficha;

/**
 *
 * @author cesar
 */
public abstract class FactoryFichas {
    
    //Establece la interfaz para aplicar factory method en las fichas rojas y amarillas
    public abstract Ficha crearFicha(int fila, int columna);
    
}
