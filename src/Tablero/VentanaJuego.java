/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tablero;

/**
 *
 * @author nicol
 */



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class VentanaJuego extends JFrame {
    
    
    private static final int FILAS = 6;
    private static final int COLUMNAS = 7;
    private JButton[][] botones;
    private char[][] tablero;
    private char jugadorActual; //Probablemente inutil rn
    
    
    
    public VentanaJuego(){
         Tablero singletonBoard = Tablero.getInstance();
        tablero = singletonBoard.getTablero();
        botones = new JButton[FILAS][COLUMNAS];
        jugadorActual = 'X';  // Starting player

        CrearUI();
    }
     private void CrearUI() {
        setTitle("Connect 4");
        setSize(700, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(FILAS + 1, COLUMNAS));  // Additional row for column buttons

        


        // Create column buttons
        
        for (int j = 0; j < COLUMNAS; j++) {
            JButton columnButton = new JButton("Poner");
            final int col = j;
            columnButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //makeMove(col);
                }
            });
            add(columnButton);
        }


          
        // Create grid buttons
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                botones[i][j] = new JButton("");
                botones[i][j].setEnabled(false);
                botones[i][j].setFont(new Font("Arial", Font.PLAIN, 40));
                add(botones[i][j]);
            }
        }

        setVisible(true);
    }
    
    
}
