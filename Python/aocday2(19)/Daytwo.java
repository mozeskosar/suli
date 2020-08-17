import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class Daytwo {

    public static class adatok {
        int x;

        public adatok( int x) {
            this.x = x;
        }
    }

    public static void main(final String[] args) throws FileNotFoundException {

        Vector<adatok> lista = new Vector<>();
        beolvas(lista);

       for (adatok adatok : lista) {
           System.out.println(adatok.x);
       }   
    }

    public static void beolvas(Vector<adatok> lista) throws FileNotFoundException {

        Scanner fileinput = new Scanner(new File("input.txt"));
        while (fileinput.hasNextLine()) {
            String data = fileinput.nextLine();
            String temp[] = data.split(",");
            lista.add(new adatok(Integer.parseInt(temp[0])));

        }
        fileinput.close();
    }
}