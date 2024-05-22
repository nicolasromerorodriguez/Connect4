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
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author cesar
 */
public class GestorAcciones implements ActionListener {

    private VentanaJuego vista;
    private Tablero tablero;
    private GestorJuego juego;

    public GestorAcciones() {

        vista = new VentanaJuego(this);
        tablero = Tablero.getInstance();
        tablero.agregarObservador(vista);
        
        juego = new GestorJuego(this);
        tablero.agregarObservador(juego);
        
        tablero.notificarObservadores();

        arrancarBotones();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().startsWith("poner")) {
            
            String index = e.getActionCommand().substring(5);
            
            int columna = Integer.parseInt(index);
            
            int actual = juego.getTurnoActual();
            
            int fila = tablero.agregarFicha(columna, juego.getTurnoActual());
            
            // Columna llena
            if (fila == -1){
                return;
            }
            
            if(juego.comprobarGanador(fila, columna, actual)){
                JOptionPane.showMessageDialog(null, "Ganó " + actual);
                System.exit(0);
            }
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

    public VentanaJuego getVista() {
        return vista;
    }

}
