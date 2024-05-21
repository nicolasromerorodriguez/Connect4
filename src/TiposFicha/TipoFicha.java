/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TiposFicha;

import javax.swing.ImageIcon;

/**
 *
 * @author nicol
 */
public class TipoFicha {

    private String nombre;
    private ImageIcon textura;

    public TipoFicha(String nombre, ImageIcon textura) {
        this.nombre = nombre;
        this.textura = textura;
    }

    public String getNombre() {
        return this.nombre;
    }

    public ImageIcon getTextura() {
        return textura;
    }
    
    public void setTextura(ImageIcon textura) {
        this.textura = textura;
    }
    
    
}
