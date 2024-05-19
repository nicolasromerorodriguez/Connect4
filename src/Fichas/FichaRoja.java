/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fichas;

import TiposFicha.FabricaTipos;
import TiposFicha.TipoFicha;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author cesar
 */
public class FichaRoja extends Ficha {
    
    private static final String rutaTextura = "/imagenes/roja.png";

    public FichaRoja(int fila, int columna) {
        super(fila, columna);
        setTipo(FabricaTipos.getTipoFicha("ROJO", new ImageIcon(getClass().getResource(rutaTextura))));
    }
    
}
