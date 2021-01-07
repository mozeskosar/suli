import java.io.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class txt2srt {
    public static class IdozitettFelirat {
        String idozites;
        String felirat;

        public IdozitettFelirat(String idozites, String felirat) {
            this.idozites = idozites;
            this.felirat = felirat;
        }

        public static int SzavakSzama(String szo) {
            String split[] = szo.split(" ");
            return split.length;
        }

        public static LocalTime atalakitorava(String input) {
            int mp = Integer.parseInt(input.charAt(3) + "" + input.charAt(4));
            int perc = Integer.parseInt(input.charAt(0) + "" + input.charAt(1));
            int ora = 0;
            if (perc >= 60) {
                ora = perc / 60;
                perc = perc - (ora * 60);
            }

            return LocalTime.of(ora, perc, mp);
        }

        public static String SrtIdozites(String input) {
            String split[] = input.split(" - ");
            return IdozitettFelirat.atalakitorava(split[0]) + " --> " + IdozitettFelirat.atalakitorava(split[1]);
        }

    }

    public static void main(String[] args) throws IOException {
        ArrayList<IdozitettFelirat> lista = new ArrayList<>();
        Scanner fileinput = new Scanner(new File("feliratok.txt"));
        int szamlalo = 0;
        String tomb[] = new String[2];
        while (fileinput.hasNextLine()) {
            String data = fileinput.nextLine();
            tomb[szamlalo] = data;
            szamlalo++;
            if (szamlalo == 2) {
                lista.add(new IdozitettFelirat(tomb[0], tomb[1]));
                szamlalo = 0;
            }
        }
        fileinput.close();
        System.out.println("5. feladat - Feliratok száma: " + lista.size());

        int max = 0;
        int maxhely = 0;
        for (int i = 0; i < lista.size(); i++) {
            if ((IdozitettFelirat.SzavakSzama(lista.get(i).felirat)) > max) {
                max = (IdozitettFelirat.SzavakSzama(lista.get(i).felirat));
                maxhely = i;
            }
        }
        System.out.println("7. feladat - Legtöbb szóból álló felirat:\n" + lista.get(maxhely).felirat);

        PrintWriter pr = new PrintWriter(new FileWriter("felirat.srt"));
        for (int i = 0; i < lista.size(); i++) {
            pr.println(i + 1);
            pr.println(IdozitettFelirat.SrtIdozites(lista.get(i).idozites));
            pr.println(lista.get(i).felirat);
            pr.println();
        }
        pr.close();

    }
}
