package vb2018;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Vb2018 {

    public static class adatok {

        String varos;
        String stadion;
        String alternativnev;
        int ferohely;

        public adatok(String varos, String stadion, String alternativnev, int ferohely) {
            this.varos = varos;
            this.stadion = stadion;
            this.alternativnev = alternativnev;
            this.ferohely = ferohely;
        }

    }

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<adatok> lista = new ArrayList<>();
        Scanner fileinput = new Scanner(new File("vb2018.txt"));
        String elso = fileinput.nextLine();
        while (fileinput.hasNextLine()) {
            String data = fileinput.nextLine();
            String tomb[] = data.split(";");
            lista.add(new adatok(tomb[0], tomb[1], tomb[2], Integer.parseInt(tomb[3])));
        }
        fileinput.close();

        System.out.println("3. feladat: Stadionok száma: " + lista.size());

        System.out.println("4. feladat: A legkevesebb férőhely:");
        int min = Integer.MAX_VALUE;
        int minhely = 0;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).ferohely < min) {
                min = lista.get(i).ferohely;
                minhely = i;
            }
        }
        System.out.println("Város: " + lista.get(minhely).varos);
        System.out.println("Stadion neve: " + lista.get(minhely).stadion);
        System.out.println("Férőhely: " + lista.get(minhely).ferohely);

        int osszeg = 0;
        for (int i = 0; i < lista.size(); i++) {
            osszeg = Integer.sum(osszeg, lista.get(i).ferohely);
        }
        double atlag = Double.parseDouble(String.valueOf(osszeg)) / Double.parseDouble(String.valueOf(lista.size()));
        DecimalFormat df = new DecimalFormat("#.#");
        System.out.println("5. feladat: Átlagos férőhelyszám: " + df.format(atlag));

        int altdb = 0;
        for (adatok e : lista) {
            if (!e.alternativnev.equals("n.a.")) {
                altdb++;
            }
        }
        System.out.println("6. feladat: Két néven is ismert stadionok száma: " + altdb);

        Scanner be = new Scanner(System.in);
        System.out.println("7. feladat: Kérem a város nevét: ");
        String bekert = be.nextLine();

        while (bekert.length() < 3) {
            System.out.println("7. feladat: Kérem a város nevét: ");
            bekert = be.nextLine();
        }
        boolean vane=false;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).varos.equals(bekert)) {
                vane=true;
                break;
            }
        }
        if (vane) {
            System.out.println("8. feladat: A megadott város nem VB helyszín.");
        }else{
        System.out.println("8. feladat: A megadott város VB helyszín.");
        }
        
        Long varosok=lista.stream().map(mapper -> mapper.varos).distinct().count();
        System.out.println("9 feladat: "+varosok+" különböző városban voltak mérkőzések.");
        
    }

}
