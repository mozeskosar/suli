/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class naplo {
    String nev;
    String osztaly;
    int elsonap;
    int utolsonap;
    int mulasztott;

    public naplo(String nev, String osztaly, int elsonap, int utolsonap, int mulasztott) {
        this.nev = nev;
        this.osztaly = osztaly;
        this.elsonap = elsonap;
        this.utolsonap = utolsonap;
        this.mulasztott = mulasztott;
    }

    public String getNev() {
        return nev;
    }

    public String getOsztaly() {
        return osztaly;
    }

    public int getElsonap() {
        return elsonap;
    }

    public int getUtolsonap() {
        return utolsonap;
    }

    public int getMulasztott() {
        return mulasztott;
    }
    
    
    
}
