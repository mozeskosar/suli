/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uca;

/**
 *
 * @author User
 */
public class telek {
    
   private boolean oldal;
   private int szelesseg;
   private  char szin;

    public telek(boolean oldal, int szelesseg, char szin) {
        this.oldal = oldal;
        this.szelesseg = szelesseg;
        this.szin = szin;
    }

    public boolean isOldal() {
        return oldal;
    }

    public int getSzelesseg() {
        return szelesseg;
    }

    public char getSzin() {
        return szin;
    }
    
    
    
    
    
    
    
}
