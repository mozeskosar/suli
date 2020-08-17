
package eutazas;

import java.time.LocalDateTime;

public class utazas {
    
    private int megallo;
    private LocalDateTime felszallasdatum;
    private int azonosito;
    private jegy jegy_;

    public utazas(int megallo, LocalDateTime felszallasdatum, int azonosito, jegy jegy_) {
        this.megallo = megallo;
        this.felszallasdatum = felszallasdatum;
        this.azonosito = azonosito;
        this.jegy_ = jegy_;
    }

    public int getMegallo() {
        return megallo;
    }

    public LocalDateTime getFelszallasdatum() {
        return felszallasdatum;
    }

    public int getAzonosito() {
        return azonosito;
    }

    public jegy getJegy() {
        return jegy_;
    }
    
    
}
