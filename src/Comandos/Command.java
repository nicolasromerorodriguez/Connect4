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
import java.util.ArrayList;

public abstract class Command {
    public Tablero tablero;
    protected ArrayList<Ficha> backup;

    public Command(Tablero tablero) {
        this.tablero = tablero;
    }

    public void backup() {
        ArrayList<Ficha> tempFichas = new ArrayList<>(tablero.getFichas());
        backup = tempFichas;

    }

    public void undo() {

        tablero.setFichas(new ArrayList<>(backup));

        tablero.notificarObservadores();
    }

    public abstract int execute();
}
