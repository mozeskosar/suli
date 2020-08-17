
package eutazas;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class berlet extends jegy{
    
    private LocalDateTime lejarat;

    public berlet(LocalDateTime lejarat, String nev) {
        super(nev);
        this.lejarat = lejarat;
    }

    public LocalDateTime getLejarat() {
        return lejarat;
    }
    
    
    
}
