/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cegesauto;

import java.time.LocalDateTime;

/**
 *
 * @author User
 */
public class autok {
    
    private LocalDateTime datum;
    private String rendszam;
    private int azon;
    private int km;
    private boolean kibe;

    public autok(LocalDateTime datum, String rendszam, int azon, int km, boolean kibe) {
        this.datum = datum;
        this.rendszam = rendszam;
        this.azon = azon;
        this.km = km;
        this.kibe = kibe;
    }

    public LocalDateTime getDatum() {
        return datum;
    }

    public String getRendszam() {
        return rendszam;
    }

    public int getAzon() {
        return azon;
    }

    public int getKm() {
        return km;
    }

    public boolean isKibe() {
        return kibe;
    }
    
    
}
