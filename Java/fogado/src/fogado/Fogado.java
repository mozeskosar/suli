package fogado;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Scanner;

public class Fogado {

    public static class adatok {

        String vezeteknev;
        String keresztnev;
        LocalTime idopont;
        LocalDateTime rogzitve;

        public adatok(String vezeteknev, String keresztnev, LocalTime idopont, LocalDateTime rogzitve) {
            this.vezeteknev = vezeteknev;
            this.keresztnev = keresztnev;
            this.idopont = idopont;
            this.rogzitve = rogzitve;
        }

    }

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<adatok> lista = new ArrayList<>();
        beolvas(lista);
//        System.out.println(lista.get(0).vezeteknev+" "+lista.get(0).keresztnev+" "+lista.get(0).idopont+" "+lista.get(0).rogzitve);
        System.out.println(lista.size());
    }

    public static void beolvas(ArrayList<adatok> lista) throws FileNotFoundException {
        Scanner fileinput = new Scanner(new File("fogado.txt"));
        while (fileinput.hasNextLine()) {
            String data = fileinput.nextLine();
            String tomb[] = data.split(" ");
            String ido1[] = tomb[2].split(":");
            String ido2[] = tomb[3].split("-");
            String ido3[] = ido2[0].split(".");
            String ido4[] = ido2[1].split(":");
            LocalTime temp1=LocalTime.of(Integer.parseInt(ido1[0]), Integer.parseInt(ido1[1]));
            
            LocalDateTime temp2=LocalDateTime.of(Integer.parseInt(ido3[0]), Integer.parseInt(ido3[1]),
                            Integer.parseInt(ido3[2].replace("-", "")), Integer.parseInt(ido4[0]), Integer.parseInt(ido4[1]));
            
            lista.add(new adatok(tomb[0], tomb[1], temp1, temp2));

        }
        fileinput.close();
    }

}
