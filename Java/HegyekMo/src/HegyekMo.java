import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HegyekMo {
    public static class adatok {
        String nev;
        String hegyseg;
        int magassag;

        public adatok(String nev, String hegyseg, int magassag) {
            this.nev = nev;
            this.hegyseg = hegyseg;
            this.magassag = magassag;
        }
    }

    public static void main(String[] args) throws IOException {
        ArrayList<adatok> lista = new ArrayList<>();
        Scanner fileinput = new Scanner(new File("hegyekMo.txt"));
        String elsosor = fileinput.nextLine();
        while (fileinput.hasNextLine()) {
            String data = fileinput.nextLine();
            String tomb[] = data.split(";");
            lista.add(new adatok(tomb[0], tomb[1], Integer.parseInt(tomb[2])));
        }
        fileinput.close();
        System.out.println("3. feladat: Hegycsúcsok száma: " + lista.size() + " db");
        int atlag = 0;
        int sum = 0;
        for (adatok e : lista) {
            sum = Integer.sum(sum, e.magassag);
        }
        atlag = sum / lista.size();
        System.out.println("4. feladat: Hegycsúcsok átlagos magassága: " + atlag + " m");

        int legmagasabb = 0;
        int legmagasabbhely = 0;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).magassag > legmagasabb) {
                legmagasabb = lista.get(i).magassag;
                legmagasabbhely = i;
            }
        }
        System.out.println("5. feladat: A legmagasabb hegycsúcs adatai:");
        System.out.println("Név: " + lista.get(legmagasabbhely).nev);
        System.out.println("Hegység: " + lista.get(legmagasabbhely).hegyseg);
        System.out.println("Magasság: " + lista.get(legmagasabbhely).magassag);

        System.out.println("6. feladat: Kérek egy magasságot: ");
        Scanner be = new Scanner(System.in);
        int bekertmagassag = be.nextInt();
        boolean vanemagasabb = false;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).hegyseg.equals("Börzsöny") && lista.get(i).magassag > bekertmagassag) {
                vanemagasabb = true;
                break;
            }
        }
        if (vanemagasabb) {
            System.out.println("Van " + bekertmagassag + "m-nél magasabb hegycsúcs a Börzsönyben!");
        } else {
            System.out.println("Nincs " + bekertmagassag + "m-nél magasabb hegycsúcs a Börzsönyben!");
        }


        int db7 = 0;
        double lab300 = 914.41;
        for (int i = 0; i < lista.size(); i++) {
            double mag = lista.get(i).magassag;
            if (mag > lab300) {
                db7++;
            }
        }
        System.out.println("7. feladat: 3000 lábnál magasabb hegycsúcsok száma: " + db7);

        System.out.println("8. feladat: Hegység statisztika");
        HashMap<String, Integer> dictionary = new HashMap<>();
        for (int i = 0; i < lista.size(); i++) {
            dictionary.put(lista.get(i).hegyseg, dictionary.getOrDefault(lista.get(i).hegyseg, 0) + 1);
        }

        for (Map.Entry<String, Integer> e : dictionary.entrySet()) {
            System.out.println(e.getKey() + " - " + e.getValue() + " db");

        }
        System.out.println("9. feladat: bukk-videk.txt");
        PrintWriter pr = new PrintWriter(new FileWriter("bukk-videk.txt"));
        pr.println("Hegycsúcs neve;Magasság láb");
        DecimalFormat df = new DecimalFormat("#.#");
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).hegyseg.equals("Bükk-vidék")) {
                double asd = lista.get(i).magassag * 3.280839895;
                pr.println(lista.get(i).nev + ";" + df.format(asd).replace(",", "."));
            }
        }
        pr.close();
    }
}
