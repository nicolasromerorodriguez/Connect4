/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Observador;

/**
 *
 * @author nicol
 */
public interface IObservado {
    void agregarObservador(IObservador observador);
    void eliminarObservador(IObservador observador);
    void notificarObservadores();
}
