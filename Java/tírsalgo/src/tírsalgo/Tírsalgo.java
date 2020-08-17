package tírsalgo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Tírsalgo {

    public static class ajtok {

        private LocalTime ido;
        private int azonosito;
        private boolean beki;

        public ajtok(LocalTime ido, int azonosito, boolean beki) {
            this.ido = ido;
            this.azonosito = azonosito;
            this.beki = beki;
        }

        public LocalTime getIdo() {
            return ido;
        }

        public int getAzonosito() {
            return azonosito;
        }

        public boolean isBeki() {
            return beki;
        }

    }

    static Scanner be = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<ajtok> lista = new ArrayList<>();
        beolvas(lista);
        System.out.println("2. feladat");
        System.out.println("Az első belépő: " + elsobe(lista) + "\n" + "Az utolsó kilépő: " + utolsoki(lista));
        try {
            feladat3(lista);
        } catch (IOException e) {
            System.out.println(e);
        }
        System.out.println("4. feladat");
        System.out.println("A végén a társalgóban voltak: " + feladat4(lista));
        System.out.println("5. feladat");
        System.out.println(feladat5(lista) + "-kor voltak a legtöbben a társalgóban.");
        System.out.println("6. feladat");
        int szam = intbe("Adja meg a személy azonosítóját! ");

        System.out.println("7. feladat");
        System.out.println(feladat7(szam, lista));
        System.out.println("8. feladat");
        System.out.println(feladat8(szam, lista));
        be.close();

    }

    public static void beolvas(ArrayList<ajtok> lista) throws FileNotFoundException {

        File adat = new File("ajto.txt");
        Scanner fileinput = new Scanner(adat);
        while (fileinput.hasNextLine()) {
            String data = fileinput.nextLine();
            String tomb[] = data.split(" ");

            lista.add(new ajtok(LocalTime.of(Integer.parseInt(tomb[0]), Integer.parseInt(tomb[1])), Integer.parseInt(tomb[2]),
                    tomb[3].equals("be") ? true : false));

        }

        fileinput.close();

    }

    public static int elsobe(ArrayList<ajtok> lista) {

        int elso = -1;
        for (ajtok e : lista) {
            if (e.isBeki()) {
                elso = e.getAzonosito();
                break;
            }
        }

        return elso;
    }

    public static int utolsoki(ArrayList<ajtok> lista) {

        int utolso = -1;
        for (int i = lista.size() - 1; i >= 0; i--) {

            if (!lista.get(i).isBeki()) {
                utolso = lista.get(i).getAzonosito();
                break;
            }
        }

        return utolso;
    }

    public static void feladat3(ArrayList<ajtok> lista) throws IOException {
        PrintWriter pr = new PrintWriter(new FileWriter("athaladas.txt"));
        Map<Integer, Integer> map = new HashMap<>();

        for (ajtok e : lista) {
            if (!map.containsKey(e.getAzonosito())) {
                map.put(e.getAzonosito(), 1);
            } else {
                map.put(e.getAzonosito(), map.get(e.getAzonosito() + 1));
            }

        }
        map.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByKey()).forEach(result -> pr.println(result.getKey() + " " + result.getValue()));

        pr.close();
    }

    public static String feladat4(ArrayList<ajtok> lista) {

        ArrayList<Integer> bentmaradtak = new ArrayList<>();
        for (ajtok e : lista) {
            if (e.isBeki()) {
                bentmaradtak.add(e.getAzonosito());
            } else {
                bentmaradtak.remove((Object) e.getAzonosito());

            }

        }

        Collections.sort(bentmaradtak);
        StringBuilder sb = new StringBuilder();

        for (Integer a : bentmaradtak) {
            sb.append(a + " ");

        }

        return sb.toString();
    }

    public static LocalTime feladat5(ArrayList<ajtok> lista) {

        ArrayList<Integer> bentmaradtak = new ArrayList<>();
        int max = 0;
        LocalTime ido = null;
        for (ajtok e : lista) {
            if (e.isBeki()) {
                bentmaradtak.add(e.getAzonosito());
            } else {
                bentmaradtak.remove((Object) e.getAzonosito());

            }

            if (max < bentmaradtak.size()) {
                max = bentmaradtak.size();
                ido = e.getIdo();
            }

        }

        //Collections.sort(bentmaradtak);
        return ido;
    }

    public static int intbe(String text) {

        System.out.print(text);

        return be.nextInt();
    }

    public static String feladat7(int azonosito, ArrayList<ajtok> lista) {

        StringBuilder sb = new StringBuilder();
        ArrayList<LocalTime> ido = new ArrayList<>();
        for (ajtok e : lista) {
            if (e.getAzonosito() == azonosito) {
                ido.add(e.getIdo());
            }
        }

        for (int i = 0; i < ido.size(); i++) {
            LocalTime lt = ido.get(i);
            String perc = lt.getMinute() < 10 ? "0" + lt.getMinute() : "" + lt.getMinute();

            if (i % 2 == 0) {
                sb.append(lt.getHour() + ":" + perc + "-");

            } else {
                sb.append(lt.getHour() + ":" + perc + "\n");

            }

        }

        return sb.toString();
    }

    public static String feladat8(int azonosito, ArrayList<ajtok> lista) {

        int db = 0;
        StringBuilder sb = new StringBuilder();
        ArrayList<LocalTime> ido = new ArrayList<>();
        for (ajtok e : lista) {
            if (e.getAzonosito() == azonosito) {
                ido.add(e.getIdo());
            }
        }

        String ki = ido.size() % 2 == 0 ? "A megfigyelés végén nem volt bent a társalgóban." : "a megfigyelés végén a társalgóban volt.";
        ido.add(LocalTime.of(15, 0, 0));

        for (int i = 0; i < ido.size() - 1; i += 2) {
            LocalTime diff = ido.get(i + 1).minusNanos(ido.get(i).toNanoOfDay());
            db += diff.getHour() * 60 + diff.getMinute();

        }

        return String.format("A(z) %d. személy összese %d percet volt bent, %s", azonosito, db, ki);
    }

}
