/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fabricas;

import Fichas.Ficha;
import Fichas.FichaAmarilla;

/**
 *
 * @author cesar
 */
public class FactoryAmarillas extends FactoryFichas {

    @Override
    public Ficha crearFicha(int fila, int columna) {
        return new FichaAmarilla(fila, columna);
    }
    
}
