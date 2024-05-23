/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fabricas;

import Fichas.Ficha;
import Fichas.FichaRoja;

/**
 *
 * @author cesar
 */
public class FactoryRojas extends FactoryFichas {

    
    //Creador concreto de Fichas rojas
    
    //Metodo heredado de Factory fichas para crear fichas rojas
    @Override
    public Ficha crearFicha(int fila, int columna) {
        return new FichaRoja(fila, columna);
    }
    
}
