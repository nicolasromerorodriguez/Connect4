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

    public JButton[] botonesColumna;
    public JLabel[][] labImagenes;
    public JLabel labLogo;
    private JPanel panelUI;
    private JLabel labInfo;
    public JLabel labTurno;
    private GestorAcciones acciones;

    public VentanaJuego(GestorAcciones acciones) {
        botonesColumna = new JButton[Tablero.COLUMNAS];
        labImagenes = new JLabel[Tablero.FILAS][Tablero.COLUMNAS];
        panelUI = new JPanel(new GridLayout(Tablero.FILAS + 1, Tablero.COLUMNAS, 0, 0));
        this.acciones = acciones;

        CrearUI();
    }

    private void CrearUI() {
        setTitle("Connect 4");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);

        panelUI.setBounds(165, 55, 350, 350);

        // Create column buttons
        for (int j = 0; j < Tablero.COLUMNAS; j++) {

            botonesColumna[j] = new JButton("↓");
            botonesColumna[j].setFont(new Font("Arial", Font.PLAIN, 20));
            botonesColumna[j].setForeground(Color.WHITE);
            botonesColumna[j].setBackground(new Color(48, 32, 138));
            botonesColumna[j].setActionCommand("poner" + j);
            panelUI.add(botonesColumna[j]);

        }

        // Create grid buttons
        for (int i = 0; i < Tablero.FILAS; i++) {
            for (int j = 0; j < Tablero.COLUMNAS; j++) {
                labImagenes[i][j] = new JLabel(".");
                labImagenes[i][j].setFont(new Font("Arial", Font.PLAIN, 40));
                panelUI.add(labImagenes[i][j]);
            }
        }

        FondoTablero fondo = new FondoTablero();
        setContentPane(fondo);
        fondo.setLayout(null);

        labInfo = new JLabel("Turno Actual");
        labInfo.setFont(new Font("Dubai Medium", Font.BOLD, 16));
        labInfo.setForeground(Color.white);
        labInfo.setHorizontalAlignment(SwingConstants.CENTER);
        labInfo.setBounds(570, 180, 100, 20);
        
        labTurno = new JLabel("AMARILLAS");
        labTurno.setFont(new Font("Dubai Medium", Font.BOLD, 16));
        labTurno.setHorizontalAlignment(SwingConstants.CENTER);
        labTurno.setForeground(new Color(252, 227, 136));
        labTurno.setBounds(570, 200, 100, 20);
        
        labLogo = new JLabel(".");
        labLogo.setIcon(new ImageIcon(getClass().getResource("/imagenes/logo.jpg")));
        labLogo.setBounds(0,0,103,431);
        

        displayBoard();

        
        
        fondo.add(labInfo);
        fondo.add(labTurno);
        fondo.add(panelUI);
        fondo.add(labLogo);

        setVisible(true);
    }

    public void displayBoard() {
        for (int i = 0; i < Tablero.FILAS; i++) {
            for (int j = 0; j < Tablero.COLUMNAS; j++) {
                labImagenes[i][j].setIcon(new ImageIcon(getClass().getResource("/imagenes/vacia.png")));
            }
        }
    }

    //Metodos del Observador
    @Override
    public void actualizar() {
        ArrayList<Ficha> fichas = acciones.getTablero().getFichas();
        ImageIcon imagen = null;
        for (Ficha f : fichas) {
            imagen = f.getTipo().getTextura();
            labImagenes[5 - f.getFila()][f.getColumna()].setIcon(imagen);
        }
        
    }

}
