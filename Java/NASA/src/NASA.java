import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NASA {
    public static class Keres {
        String cim;
        String datumido;
        String GET;
        String httpkod;
        String meret;

        public Keres(String cim, String datumido, String GET, String httpkod, String meret) {
            this.cim = cim;
            this.datumido = datumido;
            this.GET = GET;
            this.httpkod = httpkod;
            this.meret = meret;
        }

        public static int ByteMeret(String meret) {
            int szam = 0;
            return meret.equals("-") ? szam = 0 : (szam = Integer.parseInt(meret));
        }

        public static boolean Domain(String cim) {

            return (cim.endsWith("0") || cim.endsWith("1") || cim.endsWith("2") ||
                    cim.endsWith("3") || cim.endsWith("4") || cim.endsWith("5") ||
                    cim.endsWith("6") || cim.endsWith("7") || cim.endsWith("8") ||
                    cim.endsWith("9")) ? true : false;
        }

    }

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Keres> lista = new ArrayList<>();
        Scanner fileinput = new Scanner(new File("NASAlog.txt"));
        while (fileinput.hasNextLine()) {
            String data = fileinput.nextLine();
            String[] temp;
            temp = data.split("\\*");
            String[] uccso = temp[3].split(" ");
            lista.add(new Keres(temp[0], temp[01], temp[2], uccso[0], uccso[1]));
        }
        fileinput.close();

        System.out.println("5. feladat: Kérések száma: " + lista.size());
        int sum = 0;
        for (Keres e : lista) {
            sum = Integer.sum(Keres.ByteMeret(e.meret), sum);
        }

        System.out.println("6. feladat: Válaszok összes mérete: " + sum + " byte");
        double domantrue = 0;
        double domainfalse = 0;
        for (Keres e : lista) {
            if (Keres.Domain(e.cim) == false) {
                domainfalse++;
            }
        }
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("8. feladat: Domain-es kérések: " + df.format(((domainfalse / lista.size()) * 100)) + "%");
        System.out.println("9. feladat: Statisztika");
        HashMap<String, Integer> allapotok=new HashMap<>();
        for (int i = 0; i < lista.size(); i++) {
            allapotok.put(lista.get(i).httpkod,allapotok.getOrDefault(lista.get(i).httpkod,0)+1);
        }
        for(Map.Entry<String,Integer> e:allapotok.entrySet()){
            System.out.println(e.getKey()+": "+e.getValue()+" db");
        }
    }
}
