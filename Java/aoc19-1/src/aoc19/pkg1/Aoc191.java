package aoc19.pkg1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class Aoc191 {

    public static class osz {

        int x;

        public osz(int x) {
            super();
            this.x = x;
        }

    }

    public static void main(String[] args) throws FileNotFoundException {
        Vector<osz> lista = new Vector<>();
        beolvas(lista);
         Vector<Integer> eredmeny=new Vector<>();
        for (int i = 0; i < lista.size(); i++) {
            eredmeny.add(((lista.get(i).x)/3)-2);
        }
        int s=0;
        for (int i = 0; i < eredmeny.size(); i++) {
            s=Integer.sum(eredmeny.get(i), s);
        }
        day2(eredmeny);      

    }

    public static void beolvas(Vector<osz> v) throws FileNotFoundException {
        Scanner fileinput = new Scanner(new File("input.txt"));
        while (fileinput.hasNextLine()) {
            String data = fileinput.nextLine();
            String temp[] = data.split("\n");
            v.add(new osz(Integer.parseInt(temp[0].replace(" ", ""))));

        }
        fileinput.close();

    }

    public static void day2(Vector<Integer> eredmeny){
    
        var t0=0;
        var t=0;
        var t2=0;
        ArrayList<Integer>l=new ArrayList<>();
        
        
        
        for (int i = 0; i < eredmeny.size(); i++) {
           t0=eredmeny.get(i);
            t=(eredmeny.get(i)/3)-2;
            t2=(t/3)-2;
           int t3=(t2/3)-2;
           int t4=(t3/3)-2;
            int t5=(t4/3)-2;
            int t6=(t5/3)-2;
            int t7=(t6/3)-2;
            int t8=(t7/3)-2;
            int t9=(t8/3)-2;
            int t10=(t9/3)-2;
            int t11=(t10/3)-2;
            int t12=(t11/3)-2;
            int t13=(t12/3)-2;
            int t14=(t13/3)-2;
            int t15=(t14/3)-2;
        
        l.add(t0);
         l.add(t);
           l.add(t2);
            l.add(t3);
             l.add(t4); 
              l.add(t5);
               l.add(t6);
                l.add(t7);
                 l.add(t8);
                  l.add(t9);
              l.add(t10);
               l.add(t11);
                l.add(t12);
                 l.add(t13); l.add(t14);
                  l.add(t15);
                  
                 
           
        }
      
        for (int i = 0; i < l.size(); i++) {
            if (l.get(i)<0) {
                l.remove(l.get(i));
            }
        }
        int osszeg=0;
        for (int i = 0; i < l.size(); i++) {
            osszeg=Integer.sum(l.get(i), osszeg);
        }
        System.out.println(osszeg);
    } 
  
}
