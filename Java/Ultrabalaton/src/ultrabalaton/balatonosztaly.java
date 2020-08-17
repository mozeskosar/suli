package ultrabalaton;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class balatonosztaly {
 String versenyzonev;
 String rajtszam;
  String versenyzokategoria;
String idoeredmeny;
String tavszazalek;

    public balatonosztaly(String versenyzonev, String rajtszam, String versenyzokategoria, String idoeredmeny, String tavszazalek) {
        this.versenyzonev = versenyzonev;
        this.rajtszam = rajtszam;
        this.versenyzokategoria = versenyzokategoria;
        this.idoeredmeny = idoeredmeny;
        this.tavszazalek = tavszazalek;
    }

    public String getVersenyzonev() {
        return versenyzonev;
    }

    public String getRajtszam() {
        return rajtszam;
    }

    public String getVersenyzokategoria() {
        return versenyzokategoria;
    }

    public String getIdoeredmeny() {
        return idoeredmeny;
    }

    public String getTavszazalek() {
        return tavszazalek;
    }
    
}
