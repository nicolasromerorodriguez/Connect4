/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fichas;
import TiposFicha.TipoFicha;

/**
 *
 * @author nicol
 */
public abstract class Ficha {
    protected int fila;
    protected int columna;
    protected TipoFicha tipo;

    protected Ficha(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    public void setTipo(TipoFicha tipo) {
        this.tipo = tipo;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }
    
}
