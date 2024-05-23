/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fabricas;

import Fichas.Ficha;
import Fichas.FichaAmarilla;

/**
 *
 * @author nicol
 */
public class FactoryAmarillas extends FactoryFichas {
    
    //Creador concreto de Fichas amarillas
    
    //Metodo heredado de Factory fichas para crear fichas amarillas
    @Override
    public Ficha crearFicha(int fila, int columna) {
        return new FichaAmarilla(fila, columna);
    }
    
}
