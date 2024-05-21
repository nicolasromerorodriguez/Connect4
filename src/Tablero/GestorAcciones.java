/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tablero;

import Fabricas.FactoryAmarillas;
import Fabricas.FactoryRojas;
import Observador.IObservado;
import Observador.IObservador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author cesar
 */
public class GestorAcciones implements ActionListener {

    private VentanaJuego vista;
    private Tablero tablero;

    public GestorAcciones() {

        vista = new VentanaJuego(this);
        tablero = Tablero.getInstance();
        tablero.agregar(vista);

        arrancarBotones();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().startsWith("poner")) {
            
            String index = e.getActionCommand().substring(5);
            
            int columna = Integer.parseInt(index);
            
            // Por el momento agrega solo rojas
            tablero.agregarFicha(columna, Tablero.ROJA);
        }
    }

    private void arrancarBotones() {
        for (JButton b : vista.botonesColumna) {
            b.addActionListener(this);
        }
    }

    public Tablero getTablero() {
        return tablero;
    }

}
