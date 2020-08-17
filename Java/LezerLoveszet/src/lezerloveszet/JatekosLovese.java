/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lezerloveszet;

/**
 *
 * @author felhaszn
 */
public class JatekosLovese {
    public static double celtablax;
    public static double celtablay;
    
    private String nev;
    private double lovesx;
    private double lovesy;
    private int sorszam;
    private double pontszam;

    public JatekosLovese(String nev, double lovesx, double lovesy, int sorszam, double pontszam) {
        this.nev = nev;
        this.lovesx = lovesx;
        this.lovesy = lovesy;
        this.sorszam = sorszam;
        this.pontszam = pontszam;
    }

    public static double getCeltablax() {
        return celtablax;
    }

    public static double getCeltablay() {
        return celtablay;
    }

    public String getNev() {
        return nev;
    }

    public double getLovesx() {
        return lovesx;
    }

    public double getLovesy() {
        return lovesy;
    }

    public int getSorszam() {
        return sorszam;
    }

    public double getPontszam() {
        return pontszam;
    }

    public static void setCeltablax(double celtablax) {
        JatekosLovese.celtablax = celtablax;
    }

    public static void setCeltablay(double celtablay) {
        JatekosLovese.celtablay = celtablay;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public void setLovesx(double lovesx) {
        this.lovesx = lovesx;
    }

    public void setLovesy(double lovesy) {
        this.lovesy = lovesy;
    }

    public void setSorszam(int sorszam) {
        this.sorszam = sorszam;
    }

    public void setPontszam(double pontszam) {
        this.pontszam = pontszam;
    }
    
    public static double Tavolsag(double lovesx, double lovesy){
    
        double dx=JatekosLovese.celtablax-lovesx;
        double dy=JatekosLovese.celtablay-lovesy;
    
        return Math.sqrt(Math.pow(dx,2)+Math.pow(dy,2));
    }
    
    public static double round(double value, int places) {
    if (places < 0) throw new IllegalArgumentException();

    long factor = (long) Math.pow(10, places);
    value = value * factor;
    long tmp = Math.round(value);
    return (double) tmp / factor;
}
    public static double Pontszam(double lovesx, double lovesy){
       
        double pontszam=10-JatekosLovese.Tavolsag(lovesx, lovesy);  
        pontszam=round(pontszam,2);
                
        if (pontszam<0) {
            pontszam=0;
        }
    return pontszam;
    }
}