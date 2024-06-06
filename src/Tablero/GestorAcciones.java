/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tablero;

import Decorador.GestorJuego;
import Comandos.ComandoPonerFicha;
import Decorador.DecoradorGestorJuego;
import Decorador.GestorJuegoContador;
import Decorador.IGestorJuego;
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
    private GestorJuegoContador juego;
    

    public GestorAcciones() {

        vista = new VentanaJuego(this);
        tablero = Tablero.getInstance();
        tablero.agregarObservador(vista);
        GestorJuego juegoPrincipal = new GestorJuego(this);
        juego = new GestorJuegoContador(juegoPrincipal);
        tablero.agregarObservador(juego);
        

        arrancarBotones();
    }

    //Acciones de los botones
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().startsWith("poner")) {

            String index = e.getActionCommand().substring(5);

            int columna = Integer.parseInt(index);

            int actual = juego.getTurnoActual();

            int fila = tablero.executeCommand(new ComandoPonerFicha(columna, actual, tablero));

            // Columna llena
            if (fila == -1) {
                return;
            }
            
            String mensaje = juego.comprobarGanador(fila, columna, actual);
            
            if (mensaje != null) {
                JOptionPane.showMessageDialog(vista, mensaje);
                System.exit(0);
            }

        }
        if (e.getActionCommand().equals("restaurar")) {
            tablero.restaurarMovimiento();
            juego.correctorTurnos();
        }
    }

    private void arrancarBotones() {
        for (JButton b : vista.botonesColumna) {
            b.addActionListener(this);
        }

        vista.btnRestaurar.addActionListener(this);
    }

    public Tablero getTablero() {
        return tablero;
    }

    public VentanaJuego getVista() {
        return vista;
    }

}
