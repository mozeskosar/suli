import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;


public class jaror {
    public static class adatok {
        LocalTime ido;
        String rendszam;

        public adatok(LocalTime ido, String rendszam) {
            this.ido = ido;
            this.rendszam = rendszam;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<adatok> lista = new ArrayList<>();
        Scanner fileinput = new Scanner(new File("jarmu.txt"));
        while (fileinput.hasNextLine()) {
            String data = fileinput.nextLine();
            String tomb[] = data.split(" ");
            lista.add(new adatok(LocalTime.of(Integer.parseInt(tomb[0]), Integer.parseInt(tomb[1]), Integer.parseInt(tomb[2])), tomb[3]));

        }
        fileinput.close();
        int db = 0;

        System.out.println("2. feladat");
        System.out.println("Legalább " + (lista.get(lista.size() - 1).ido.getHour() - lista.get(0).ido.getHour() + 1) + " órát dolgoztak");

        System.out.println("3.feladat");
        System.out.println(lista.get(0).ido.getHour() + " óra: " + lista.get(0).rendszam);
        for (int i = 2; i < lista.size(); i++) {
            if (lista.get(i - 1).ido.getHour() != lista.get(i - 2).ido.getHour()) {
                System.out.println(lista.get(i - 1).ido.getHour() + " óra: " + lista.get(i - 1).rendszam);
            }
        }
        int bdb=0;
        int kdb=0;
        int mdb=0;
        for(adatok e:lista){
            if (e.rendszam.charAt(0)=='B'){
                bdb++;
            }
            if (e.rendszam.charAt(0)=='K'){
                kdb++;
            }
            if (e.rendszam.charAt(0)=='M'){
                mdb++;
            }
        }
        System.out.println("4. feladat");
        System.out.println("B-s rendszámú autók: "+bdb+" db");
        System.out.println("K-s rendszámú autók: "+kdb+" db");
        System.out.println("M-s rendszámú autók: "+mdb+" db");

        System.out.println("5. feladat");
        int hely1=0;
        int hely2=0;
        int max=0;
        long asd=0;
        for (int i = 0; i < lista.size()-1; i++) {
            if ((Duration.between(lista.get(i+1).ido,lista.get(i).ido).toMinutes())>max){
                asd=(Duration.between(lista.get(i+1).ido,lista.get(i).ido).toMinutes());

            }
        }

        System.out.println(lista.get(hely1).ido+" - "+lista.get(hely2).ido);
        System.out.println(asd);
    }

}
