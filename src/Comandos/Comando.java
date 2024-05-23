/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comandos;

/**
 *
 * @author cesar
 */
import Fichas.Ficha;
import Tablero.Tablero;
import static Tablero.Tablero.FILAS;
import java.util.ArrayList;

public abstract class Comando {
    
    
    
    public Tablero tablero;
    protected ArrayList<Ficha> backup;

    public Comando(Tablero tablero) {
        this.backup = new ArrayList<>();
        this.tablero = tablero;
    }

    public void backup() {
        
        
        // Almacenar en backup
        for (Ficha[] row : tablero.getFichas()) {

            for (Ficha f : row) {
                if (f == null){
                    continue;
                }
                backup.add(f);
                
            }
        }
        
    }

    public void undo() {
        tablero.setFichas(new Ficha[Tablero.FILAS][Tablero.COLUMNAS]);
        
        for(Ficha f : backup){
            tablero.getFichas()[f.getFila()][f.getColumna()] = f;
        }

        tablero.notificarObservadores();
    }

    public abstract int execute();
}
