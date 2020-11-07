package balkezesek;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class balkezesek {

	public static class jatekosok {
		String nev;
		String elsodatum;;
		String utolsodatum;
		int suly;
		int magassag;

		public jatekosok(String nev, String elsodatum, String utolsodatum, int suly, int magassag) {
			this.nev = nev;
			this.elsodatum = elsodatum;
			this.utolsodatum = utolsodatum;
			this.suly = suly;
			this.magassag = magassag;
		}

	}

	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<jatekosok> lista = new ArrayList<jatekosok>();
		Scanner fileinput = new Scanner(new File("balkezesek.csv"));
		String elsosor = fileinput.nextLine();
		while (fileinput.hasNextLine()) {
			String data = fileinput.nextLine();
			String tomb[] = data.split(";");
			lista.add(new jatekosok(tomb[0], tomb[1], tomb[2], Integer.parseInt(tomb[3]), Integer.parseInt(tomb[4])));

		}
		fileinput.close();
		System.out.println("3. feladat: " + lista.size());
		System.out.println("4.feladat:");
		DecimalFormat df = new DecimalFormat("#.#");
		double temp = 0.0;
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).utolsodatum.contains("1999-10")) {
				temp = lista.get(i).magassag * 2.54;
				System.out.println(lista.get(i).nev + ", " + df.format(temp) + " cm");
			}

		}
		System.out.println("5. feladat: ");
		System.out.println("Kérek egy 1990 és 1999 közötti évszámot!: ");
		Scanner be = new Scanner(System.in);
		int bekertev = be.nextInt();
		while (bekertev > 1999 || bekertev < 1990) {
			System.out.println("Hibás adat!kérek egy 1990 és 1999 közötti évszámot!: ");
			bekertev = be.nextInt();
		}

		DecimalFormat df2 = new DecimalFormat("#.##");
		double tempsuly = 0.0;
		double atlagsuly = 0.0;
		int db = 0;
		for (int i = 0; i < lista.size(); i++) {
			String elso = lista.get(i).elsodatum.charAt(0) + "" + lista.get(i).elsodatum.charAt(1) + ""
					+ lista.get(i).elsodatum.charAt(2) + "" + lista.get(i).elsodatum.charAt(3);
			String utolso = lista.get(i).utolsodatum.charAt(0) + "" + lista.get(i).utolsodatum.charAt(1) + ""
					+ lista.get(i).utolsodatum.charAt(2) + "" + lista.get(i).utolsodatum.charAt(3);
			if (bekertev <= Integer.parseInt(utolso) && bekertev >= Integer.parseInt(elso)) {
				db++;
				tempsuly = Double.sum(tempsuly, Double.parseDouble(Integer.toString(lista.get(i).suly)));
			}

		}
		atlagsuly = tempsuly / db;
		System.out.println("6. feladat: " + df2.format(atlagsuly) + " font");
	}

}
