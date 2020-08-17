package kiralynok;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Kiralynok {

    public static class Tabla {

        private char T[][] = new char[8][8];
        private char UresCella = '#';

        public Tabla(char uc) {
            this.UresCella = uc;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    T[i][j] = UresCella;
                }

            }

        }

        public void Megjelenit() {

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    System.out.print(T[i][j]);
                }
                System.out.println("");
            }
            System.out.println("");
        }

        public void Elhelyez(int n) {
            for (int i = 0; i < n; i++) {

                int x;
                int y;

                do {

                    x = (int) (Math.random() * 8);
                    y = (int) (Math.random() * 8);
                } while (T[x][y] != UresCella);

                T[x][y] = 'K';
            }

        }

        public boolean UresOszlop(int m) {
            int i = 0;
            while (i <= 7 && T[i][m] == UresCella) {
                i++;
            }
            return !(i <= 7);
        }

        public boolean UresSor(int m) {
            int i = 0;
            while (i <= 7 && T[m][i] == UresCella) {
                i++;
            }
            return !(i <= 7);
        }

        public int UresOszlopokSzama() {

            int db = 0;
            for (int i = 0; i < 8; i++) {
                if (UresOszlop(i)) {
                    db++;
                }
            }
            return db;
        }

        public int UresSorokSzama() {

            int db = 0;
            for (int i = 0; i < 8; i++) {
                if (UresSor(i)) {
                    db++;
                }
            }
            return db;
        }

        public void FajlbaIr() throws IOException {

            try (PrintWriter pr = new PrintWriter(new FileWriter("tablak64.txt"))) {
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {

                        pr.print(T[i][j]);

                    }
                    pr.println("");
                }
                pr.println('\n');
            }
        }

    }

    public static void main(String[] args) throws IOException {
        Tabla tabla = new Tabla('#');
        System.out.println("4. feladat: az üres tábla");
        tabla.Megjelenit();

        System.out.println("6. feladat: A feltöltött tábla");
        tabla.Elhelyez(8);
        tabla.Megjelenit();

        System.out.println("9. feladat: Üres sorok és oszlopok száma");
        System.out.println("Oszlopok: " + tabla.UresOszlopokSzama());
        System.out.println("Sorok: " + tabla.UresSorokSzama());

        for (int i = 1; i < 65; i++) {
            Tabla ujtabla = new Tabla('*');
            ujtabla.Elhelyez(i);
            ujtabla.FajlbaIr();
        }

    }

}
