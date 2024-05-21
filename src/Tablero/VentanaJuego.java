/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tablero;

/**
 *
 * @author nicol
 */
import Fichas.Ficha;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Observador.*;
import java.util.ArrayList;

public class VentanaJuego extends JFrame implements IObservador {

    private static final int FILAS = 6;
    private static final int COLUMNAS = 7;
    public JButton[] botonesColumna;
    public JLabel[][] labImagenes;
    private JPanel panelUI;
    private GestorAcciones acciones;

    public VentanaJuego(GestorAcciones acciones) {
        botonesColumna = new JButton[COLUMNAS];
        labImagenes = new JLabel[FILAS][COLUMNAS];
        panelUI = new JPanel(new GridLayout(FILAS + 1, COLUMNAS, 0, 0));
        this.acciones = acciones;

        CrearUI();
    }

    private void CrearUI() {
        setTitle("Connect 4");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        panelUI.setSize(new Dimension(490, 490));

        // Create column buttons
        for (int j = 0; j < COLUMNAS; j++) {

            botonesColumna[j] = new JButton("↓");
            botonesColumna[j].setFont(new Font("Arial", Font.PLAIN, 20));
            botonesColumna[j].setForeground(Color.WHITE);
            botonesColumna[j].setBackground(new Color(48, 32, 138));
            botonesColumna[j].setActionCommand("poner" + j);
            panelUI.add(botonesColumna[j]);

        }

        // Create grid buttons
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                labImagenes[i][j] = new JLabel(".");
                labImagenes[i][j].setFont(new Font("Arial", Font.PLAIN, 40));
                panelUI.add(labImagenes[i][j]);
            }
        }

        FondoTablero fondo = new FondoTablero();
        setContentPane(fondo);
        fondo.setLayout(null);

        displayBoard();

        panelUI.setBounds(165, 55, 350, 350);
        fondo.add(panelUI);

        setVisible(true);
    }

    public void displayBoard() {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                labImagenes[i][j].setIcon(new ImageIcon(getClass().getResource("/imagenes/vacia.png")));
            }
        }
    }

    public void ponerFicha(int columna, Ficha ficha) {

    }

    //Metodos del Observador
    @Override
    public void actualizar() {
        ArrayList<Ficha> fichas = acciones.getTablero().getFichas();
        ImageIcon imagen = null;
        for(Ficha f : fichas){
            imagen = f.getTipo().getTextura();
            labImagenes[5-f.getFila()][f.getColumna()].setIcon(imagen);
        }
    }

}
