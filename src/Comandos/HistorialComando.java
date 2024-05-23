/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comandos;

/**
 *
 * @author cesar
 */
import java.util.Stack;

public class HistorialComando {
    
    //Permite guardar las jugadas
    private Stack<Comando> history = new Stack<>();

    public void push(Comando c) {
        history.push(c);
    }

    public Comando pop() {
        return history.pop();
    }

    public boolean isEmpty() { return history.isEmpty(); }
}