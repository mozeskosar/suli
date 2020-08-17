/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tanciskola;

/**
 *
 * @author User
 */
public class Tancosztaly {
    
    private String kategoria;
    private String noi;
    private String ferfi;

    public Tancosztaly(String kategoria, String noi, String ferfi) {
        this.kategoria = kategoria;
        this.noi = noi;
        this.ferfi = ferfi;
    }

    public String getKategoria() {
        return kategoria;
    }

    public String getNoi() {
        return noi;
    }

    public String getFerfi() {
        return ferfi;
    }
    
    
}
