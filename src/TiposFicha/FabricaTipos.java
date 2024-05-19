/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TiposFicha;

import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author nicol
 */
public class FabricaTipos {
    private static ArrayList<TipoFicha>  tipoFichas = new ArrayList<>();
    
    public static TipoFicha getTipoFicha(String nombre, ImageIcon icon){
        for (TipoFicha t : tipoFichas){
            if( t.getNombre().equals(nombre) ){
                return t;
            }
        }
        return new TipoFicha(nombre, icon) ;
    }
}
