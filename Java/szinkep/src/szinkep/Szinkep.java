package szinkep;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Szinkep {

    public static class szinek {

        private int red;
        private int green;
        private int blue;

        public szinek(int red, int green, int blue) {
            this.red = red;
            this.green = green;
            this.blue = blue;
        }

        public int getRed() {
            return red;
        }

        public int getGreen() {
            return green;
        }

        public int getBlue() {
            return blue;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<szinek> lista = new ArrayList<>();
        beolvas(lista);
        feladat2(lista);

    }

    public static void beolvas(ArrayList<szinek> lista) throws FileNotFoundException {

        File adat = new File("kep.txt");
        Scanner fileinput = new Scanner(adat);
        while (fileinput.hasNextLine()) {
            String data = fileinput.nextLine();
            String tomb[] = data.split(" ");
            lista.add(new szinek(Integer.parseInt(tomb[0]), Integer.parseInt(tomb[1]), Integer.parseInt(tomb[2])));

        }
        fileinput.close();

    }

    public static void feladat2(ArrayList<szinek> lista) {
        System.out.println("Írd be a színeket egymás alá");
        Scanner be = new Scanner(System.in);
        int bepiros = be.nextInt();

        Scanner be2 = new Scanner(System.in);
        int bezold = be2.nextInt();

        Scanner be3 = new Scanner(System.in);
        int bekek = be3.nextInt();

//        System.out.println("piros: "+bepiros+" zöld: "+bezold+" kék: "+bekek);
        boolean vane = false;
        for (szinek e : lista) {
            if (e.getRed() == bepiros && e.getGreen() == bezold && e.getBlue() == bekek) {
                vane = true;

            }
        }
        System.out.println(vane);
    }

}
