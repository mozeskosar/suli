/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hianyzasok;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class naplo {
 
   private int honap;
   private int nap;
   private ArrayList<tanulok>tanulolista;

    public naplo(int honap, int nap, ArrayList<tanulok> tanulolista) {
        this.honap = honap;
        this.nap = nap;
        this.tanulolista = tanulolista;
    }

    public int getHonap() {
        return honap;
    }

    public int getNap() {
        return nap;
    }

    public ArrayList<tanulok> getTanulolista() {
        return tanulolista;
    }
    
    
    
    public void tanulohozzadas(tanulok tanulo){
    this.tanulolista.add(tanulo);
    }
   
}
