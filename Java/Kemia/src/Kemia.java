import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Kemia {
    public static class adatok {
        String ev;
        String anyag;
        String vegyjel;
        int rendszam;
        String felfedezo;

        public adatok(String ev, String anyag, String vegyjel, int rendszam, String felfedezo) {
            this.ev = ev;
            this.anyag = anyag;
            this.vegyjel = vegyjel;
            this.rendszam = rendszam;
            this.felfedezo = felfedezo;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<adatok> lista = new ArrayList<>();
        Scanner fileinput = new Scanner(new File("felfedezesek.csv"));
        String elsosor = fileinput.nextLine();
        while (fileinput.hasNextLine()) {
            String data = fileinput.nextLine();
            String tomb[] = data.split(";");
            lista.add(new adatok(tomb[0], tomb[1], tomb[2], Integer.parseInt(tomb[3]), tomb[4]));
        }
        fileinput.close();
        System.out.println("3. feladat: Elemek száma: " + lista.size());
        System.out.println("4. feladat: Felfedezések száma az ókorban: " + lista.stream().filter(k -> k.ev.equals("Ókor")).count());
        System.out.println("5. feladat: Kérek egy vegyjelet: ");
        Scanner be = new Scanner(System.in);
        String bekertvegyjel = be.nextLine();
        while (!((bekertvegyjel.length() == 1 || bekertvegyjel.length() == 2) && bekertvegyjel.matches(".*[a-zA-Z]+.*[a-zA-Z]"))) {
            System.out.print("5. feladat: Kérek egy vegyjelet: ");
            bekertvegyjel = be.nextLine();
        }
        int hely = 0;
        boolean vane = false;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).vegyjel.toLowerCase().contains(bekertvegyjel.toLowerCase()) ||
                    lista.get(i).vegyjel.toUpperCase().contains(bekertvegyjel.toUpperCase()) ||
                    lista.get(i).vegyjel.equals(bekertvegyjel)
            ) {
                vane = true;
                hely = i;
                break;
            } else {
                vane = false;
            }

        }
        if (vane) {
            System.out.println("6. feladat: Keresés");
            System.out.println("        Az elem vegyjele: " + lista.get(hely).vegyjel);
            System.out.println("        Az elem neve: " + lista.get(hely).anyag);
            System.out.println("        Rendszáma: " + lista.get(hely).rendszam);
            System.out.println("        Felfedezés éve: " + lista.get(hely).ev);
            System.out.println("        Felfedező: " + lista.get(hely).felfedezo);
        } else {
            System.out.println("6. feladat: Keresés");
            System.out.println("        Nincs ilyen elem az adatforrásban!");
        }

        int maxido = 0;
        for (int i = 0; i < lista.size() - 1; i++) {
            if (!lista.get(i).ev.equals("Ókor")) {
                if (Integer.parseInt(lista.get(i + 1).ev) - Integer.parseInt(lista.get(i).ev) > maxido) {
                    maxido = Integer.parseInt(lista.get(i + 1).ev) - Integer.parseInt(lista.get(i).ev);
                }
            }
        }
        System.out.println("7. feladat: " + maxido + " év volt a leghosszabb időszak két elem felfedezése között.");

        Map<String, Integer> felfedezesek = new HashMap<String, Integer>();
        for (int i = 0; i < lista.size(); i++) {
            if (!lista.get(i).ev.equals("Ókor")) {
                felfedezesek.put(lista.get(i).ev, felfedezesek.getOrDefault(lista.get(i).ev, 0) + 1);

            }
        }
        System.out.println("8. feladat: Statisztika");
        for (Map.Entry<String, Integer> e : felfedezesek.entrySet()) {
            if (e.getValue() > 3) {
                System.out.println("        "+e.getKey() + ": " + e.getValue() + " db");
            }

        }

    }
}
