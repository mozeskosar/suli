import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class csudh {
    public static class adatok {
        String domain;
        String ip;

        public adatok(String domain, String ip) {
            this.domain = domain;
            this.ip = ip;
        }
    }

    public static ArrayList<adatok> lista = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Scanner fileinput = new Scanner(new File("csudh.txt"));
        String elsosor = fileinput.nextLine();
        while (fileinput.hasNextLine()) {
            String data = fileinput.nextLine();
            String temp[] = data.split(";");
            lista.add(new adatok(temp[0], temp[1]));

        }
        fileinput.close();

        System.out.println("3. feladat: Domainek száma: " + lista.size());
        System.out.println("5. feladat: Az első domain felépítése");
        System.out.println("1. szint: " + Domain(lista.get(0).domain, 1));
        System.out.println("2. szint: " + Domain(lista.get(0).domain, 2));
        System.out.println("3. szint: " + Domain(lista.get(0).domain, 3));
        System.out.println("4. szint: " + Domain(lista.get(0).domain, 4));
        System.out.println("5. szint: " + Domain(lista.get(0).domain, 5));

        kiirat(); //5. feladat
    }

    public static String Domain(String domain, int szint) {
        String split[] = domain.split("\\.");
        int index = split.length;
        if (index < szint) {
            return "nincs";
        } else {
            return split[index - szint];
        }
    }

    public static void kiirat() throws IOException {
        PrintWriter pr = new PrintWriter(new FileWriter("table.html"));
        pr.println("<table>" +
                "<tr>" +
                "<th style='text-align: left'>Ssz</th>" +
                "<th style='text-align: left'>Host Domainneve</th>" +
                "<th style='text-align: left'>Host IP címe</th>" +
                "<th style='text-align: left'>1. szint</th>" +
                "<th style='text-align: left'>2. szint</th>" +
                "<th style='text-align: left'>3. szint</th>" +
                "<th style='text-align: left'>4. szint</th>" +
                "<th style='text-align: left'>5. szint</th>" +
                "</tr>");
        for (int i = 0; i < lista.size(); i++) {
            pr.println(      "<tr>" +
                            "<th style='text-align: left'>" + ((i + 1) + ".") + "</th>" +
                            "<td>" + lista.get(i).domain + "</td>" +
                            "<td>" + lista.get(i).ip + "</td>" +
                            "<td>" + Domain(lista.get(i).domain, 1) + "</td>" +
                            "<td>" + Domain(lista.get(i).domain, 2) + "</td>" +
                            "<td>" + Domain(lista.get(i).domain, 3) + "</td>" +
                            "<td>" + Domain(lista.get(i).domain, 4) + "</td>" +
                            "<td>" + Domain(lista.get(i).domain, 5) + "</td>" +
                            "</tr>"
            );
        }
        pr.close();

    }
}
