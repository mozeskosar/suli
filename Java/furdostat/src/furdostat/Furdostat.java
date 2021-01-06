
package furdostat;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author felhaszn
 */
public class Furdostat {

    public static class adatok {

        int vendegazon;
        int reszlegazon;
        int bevagyki;
        LocalTime ido;

        public adatok(int vendegazon, int reszlegazon, int bevagyki, LocalTime ido) {
            this.vendegazon = vendegazon;
            this.reszlegazon = reszlegazon;
            this.bevagyki = bevagyki;
            this.ido = ido;
        }

    }

    public static void main(String[] args) throws FileNotFoundException, IOException {

        ArrayList<adatok> lista = new ArrayList<>();

        File adat = new File("furdoadat.txt");
        Scanner fileinput = new Scanner(adat);
        while (fileinput.hasNextLine()) {
            String data = fileinput.nextLine();
            String tomb[] = data.split(" ");
            lista.add(new adatok(Integer.parseInt(tomb[0]), Integer.parseInt(tomb[1]), Integer.parseInt(tomb[2]), LocalTime.of(Integer.parseInt(tomb[3]), Integer.parseInt(tomb[4]), Integer.parseInt(tomb[5]))));

        }
        fileinput.close();

        System.out.println("2.feladat: ");
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).reszlegazon == 0 && lista.get(i).bevagyki == 1) {
                System.out.println("Az első vendég " + lista.get(i).ido + "-kor lépett ki az öltözőből.");
                break;
            }
        }

        for (int i = lista.size() - 1; i > 0; i--) {
            if (lista.get(i).reszlegazon == 0 && lista.get(i).bevagyki == 1) {
                System.out.println("az utolsó vendég " + lista.get(i).ido + "-kor lépett ki az öltözőből.");
                break;
            }

        }

        int db = 0;
        int db2 = 0;
        for (int i = 0; i < lista.size(); i++) {
            db = 1;
            int j;
            for (j = i + 1; j < lista.size(); j++) {
                if (lista.get(i).vendegazon == lista.get(j).vendegazon) {
                    db++;
                } else {
                    if (db == 4) {
                        db2++;
                    }
                    break;
                }

            }
            i = j - 1;

        }
        System.out.println("3.feladat");
        System.out.println("A furdőben csak " + db2 + " vendég járt csak egy részlegen.");

        int maxidotartam = 0;
        int maxidotartamvendeg = 0;
        LocalTime kezdoido, zaroido = null;
        for (int i = 0; i < lista.size(); i++) {
            kezdoido = lista.get(i).ido;
            int j;
            for (j = i + 1; j < lista.size(); j++) {
                if (lista.get(i).vendegazon == lista.get(j).vendegazon) {
                    zaroido = lista.get(j).ido;
                } else {
                    // System.out.println("eltelt idő (másodpercben): " + (zaroido.toSecondOfDay() - kezdoido.toSecondOfDay()));
                    //annak vizsgálata, hogy ez nagyobb-e az eddigi max időtartamnál     
                    if (zaroido.toSecondOfDay() - kezdoido.toSecondOfDay() > maxidotartam) {
                        maxidotartam = zaroido.toSecondOfDay() - kezdoido.toSecondOfDay();
                        maxidotartamvendeg = lista.get(i).vendegazon;
                    }
                    break;
                }

            }
            i = j - 1;
        }
        System.out.println("Leghosszabb időtartamú vendég azonosítója: " + maxidotartamvendeg);
        System.out.println("Benttöltött idő hossza: " + atszamitas(maxidotartam));

        int reggeli = 0;
        int napkozben = 0;
        int delutan = 0;
        int vendeg = 0;

        for (adatok e : lista) {
            if (e.vendegazon == vendeg) {

            } else {
                vendeg = e.vendegazon;

                if (e.ido.isAfter(LocalTime.of(06, 00, 00)) && e.ido.isBefore(LocalTime.of(8, 59, 59))) {
                    reggeli++;
                }
                if (e.ido.isAfter(LocalTime.of(9, 00, 00)) && e.ido.isBefore(LocalTime.of(15, 59, 59))) {
                    napkozben++;
                }
                if (e.ido.isAfter(LocalTime.of(16, 00, 00)) && e.ido.isBefore(LocalTime.of(19, 59, 59))) {
                    delutan++;
                }

            }

        }

        System.out.println("reggeli: " + reggeli);
        System.out.println("napkozben: " + napkozben);
        System.out.println("delutan: " + delutan);

        PrintWriter pr = new PrintWriter(new FileWriter("szauna.txt"));
        int vend = 0;
        int vendszaunabanmp = 0;
        LocalTime szaunbalepes = LocalTime.of(00, 00, 00);
        for (adatok e : lista) {
            if (e.vendegazon == vend) {
                if (e.reszlegazon == 2 && e.bevagyki == 0) {
                    szaunbalepes = e.ido;
                }
                if (e.reszlegazon == 2 && e.bevagyki == 1) {
                    vendszaunabanmp = e.ido.toSecondOfDay() - szaunbalepes.toSecondOfDay();
                }

            } else {

                if (vendszaunabanmp == 0) {

                } else {

                    pr.print(vend + " " + atszamitas(vendszaunabanmp) + "\n");
                }
                vendszaunabanmp = 0;
                vend = e.vendegazon;
            }

        }
        pr.close();

        int szaunafo = 0;
        int szaunadb = 0;

        int uszodafo = 0;
        int uszodadb = 0;

        int gyogyvizfo = 0;
        int gyogyvizdb = 0;
        int strandfo = 0;
        int stranddb = 0;

        int v = 0;
        for (adatok e : lista) {
            if (e.vendegazon == v) {
                if (e.reszlegazon == 2 && e.bevagyki == 0) {
                    szaunadb++;
                }
                if (e.reszlegazon == 1 && e.bevagyki == 0) {
                    uszodadb++;
                }
                if (e.reszlegazon == 3 && e.bevagyki == 0) {
                    gyogyvizdb++;
                }
                if (e.reszlegazon == 4 && e.bevagyki == 0) {
                    stranddb++;
                }
               /* if (e.bevagyki == 0) {
                    reszlegfo[e.reszlegazon]++;
                }*/
            } else {
                //System.out.println("szaunadb: " + szaunadb + " " + v);
                if (szaunadb > 0) {
                    szaunafo++;
                }
                szaunadb = 0;
                if (uszodadb > 0) {
                    uszodafo++;
                }
                uszodadb = 0;
                if (gyogyvizdb > 0) {
                    gyogyvizfo++;
                }
                gyogyvizdb = 0;
                if (stranddb > 0) {
                    strandfo++;
                }
                stranddb = 0;
                /*
                for (int i = 0; i < reszlegfo.size; i++) {
                    if (reszlegfo[i] > 0) {reszlegdb[i]++
                }
*/
                v = e.vendegazon;

            }

        }

        if (szaunadb > 0) {
            szaunafo++;
        }
        szaunadb = 0;
        if (uszodadb > 0) {
            uszodafo++;
        }
        uszodadb = 0;
        if (gyogyvizdb > 0) {
            gyogyvizfo++;
        }
        gyogyvizdb = 0;
        if (stranddb > 0) {
            strandfo++;
        }
        stranddb = 0;

        System.out.println("szauna: " + szaunafo);
        System.out.println("uszoda: " + uszodafo);
        System.out.println("strand: " + strandfo);
        System.out.println("gyógyvíz: " + gyogyvizfo);
    }

    public static LocalTime atszamitas(int maxidotartam) {

        int ora = maxidotartam / 3600;
        int perc = maxidotartam % 3600 / 60;
        int mp = maxidotartam - ((ora * 3600) + (perc * 60));

        LocalTime ido = LocalTime.of(ora, perc, mp);

        return ido;
    }

}
