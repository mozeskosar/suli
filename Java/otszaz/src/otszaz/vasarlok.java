/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otszaz;

import java.util.*;

/**
 *
 * @author User
 */
public class vasarlok {
   
    private Map<String,Integer>termek;

    public vasarlok(Map<String, Integer> termek) {
        this.termek = (new HashMap<>(termek));
    }

    public Map<String, Integer> getTermek() {
        return termek;
    }
    
    
    
}
