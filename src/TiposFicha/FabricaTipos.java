/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TiposFicha;

import java.util.ArrayList;

/**
 *
 * @author nicol
 */
public class FabricaTipos {
    private ArrayList<TipoFicha> tipoFichas = new ArrayList<>();
    
    public FabricaTipos(){
        this.tipoFichas = new ArrayList<>();
    }
    
    public ITipoFicha getTipoFicha(TipoFicha tipoFicha ){
        if(!tipoFichas.contains(tipoFicha)){
            tipoFichas.add(tipoFicha);
        }
        return tipoFicha ;
    }
}
