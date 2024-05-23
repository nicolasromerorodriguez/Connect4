/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fichas;

import TiposFicha.FabricaTipos;
import javax.swing.ImageIcon;

/**
 *
 * @author cesar
 */
public class FichaAmarilla extends Ficha {
    
    
    //Producto concreto de las fichas
    
    private static final String rutaTextura = "/imagenes/amarilla.png"; //Aplica la textura para la ficha

    public FichaAmarilla(int fila, int columna) {
        super(fila, columna);
        setTipo(FabricaTipos.getTipoFicha("AMARILLA", new ImageIcon(getClass().getResource(rutaTextura))));
    }
    
}
