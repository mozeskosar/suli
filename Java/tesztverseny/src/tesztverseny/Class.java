/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tesztverseny;

/**
 *
 * @author User
 */
public class Class implements Comparable<Class>{
 
    public static String helyesvalasz;
    private String azonosito;
    private String valasz;
    private int pont;
    
    public int getPont() {
        return pont;
    }

    public void setPont(int pont) {
        this.pont = pont;
    }
    
    public Class(String azonosito, String valasz) {
        this.azonosito = azonosito;
        this.valasz = valasz;
    }

    public String getAzonosito() {
        return azonosito;
    }

    public String getValasz() {
        return valasz;
    }

    @Override
    public int compareTo(Class o) {
   
        if (pont==o.getPont()) {
            return 0;
        }else if(pont<o.getPont()){
        return 1;
        }else return -1;
        
    }
    
}
