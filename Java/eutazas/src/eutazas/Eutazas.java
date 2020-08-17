
package eutazas;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Eutazas {


    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<utazas> lista = new ArrayList<>();
        beolvas(lista);
        System.out.println("2. feladat: " + lista.size());
        feladat3(lista);
        int tomb[] = feladat4(lista);

        int max = 0;
        for (int i = 1; i < tomb.length; i++) {

            if (tomb[max] < tomb[i]) {
                max = i;
            }

        }

        System.out.println(tomb[max] + " " + max);
        
        
        int tomb2[]=feladat5(lista);
        System.out.println("kedvezmenyes "+tomb2[0]+" ingyenes "+tomb2[1]);
        

    }

    public static void beolvas(ArrayList<utazas> lista) throws FileNotFoundException {

        File adat = new File("utasadat.txt");
        Scanner fileinput = new Scanner(adat);
        while (fileinput.hasNextLine()) {
            String data = fileinput.nextLine();
            String tomb[] = data.split(" ");
            DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyMMdd-HHmm");
            LocalDateTime ld = LocalDateTime.parse(tomb[1], df);

            if (tomb[3].equals("JGY")) {
                lista.add(new utazas(Integer.parseInt(tomb[0]), ld, Integer.parseInt(tomb[2]), new normaljegy(Integer.parseInt(tomb[4]), "JGY")));

            } else {

                lista.add(new utazas(Integer.parseInt(tomb[0]), ld, Integer.parseInt(tomb[2]), new berlet(LocalDateTime.parse(tomb[4] + "-0000", df), tomb[3])));

            }

        }

        fileinput.close();

    }

    public static int feladat3(ArrayList<utazas> lista) {
        int db = 0;

        for (utazas e : lista) {
            if (e.getJegy().getNev().equals("JGY")) {
                if (((normaljegy) e.getJegy()).getDb() == 0) {
                    db++;
                }
            } else {
                if (((berlet) e.getJegy()).getLejarat().plusDays(1).isBefore(e.getFelszallasdatum())) {
                    db++;
                }

            }

        }
        System.out.println("3.feladat: " + db);

        return db;
    }

    public static int[] feladat4(ArrayList<utazas> lista) {

        int tomb[] = new int[30];
        for (utazas e : lista) {
            tomb[e.getMegallo()]++;
        }

        return tomb;
    }

    public static int[] feladat5(ArrayList<utazas> lista) {
        int[] value = new int[2];
        ArrayList<String> kedvezmenyes = new ArrayList<>(Arrays.asList("TAB", "NYB"));
        ArrayList<String> ingyenes = new ArrayList<>(Arrays.asList("NYP", "RVS", "GYK"));

        for (utazas e : lista) {
            if (!e.getJegy().getNev().equals("JGY")) {
                if (!((berlet) e.getJegy()).getLejarat().plusDays(1).isBefore(e.getFelszallasdatum())) {

                    if (kedvezmenyes.contains(e.getJegy().getNev())) {
                        value[0]++;
                    } else if (ingyenes.contains(e.getJegy().getNev())) {
                        value[1]++;

                    }

                }

            }
        }

        return value;
    }
}
