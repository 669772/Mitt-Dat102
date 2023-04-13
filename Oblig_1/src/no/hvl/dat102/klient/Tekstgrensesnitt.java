package no.hvl.dat102.klient;

import java.util.Scanner;
import java.lang.*;

import no.hvl.dat102.*;
import no.hvl.dat102.adt.*;

public class Tekstgrensesnitt {

	private Filmarkiv arkiv;

	public Tekstgrensesnitt() {
		arkiv = new Filmarkiv();
	}

	public Tekstgrensesnitt(int lengde) {
		arkiv = new Filmarkiv(lengde);
	}

	public Filmarkiv getArkiv() {
		return arkiv;
	}

	public void setArkiv(Filmarkiv arkiv) {
		this.arkiv = arkiv;
	}

	// lese opplysningene om en FILM fra tastatur
	public Film lesFilm() {

		Film svar = null;

		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("\n\nSøk etter Tittel eller Produsent: ");
			String tEp = scanner.nextLine();
			tEp = tEp.toLowerCase();
			String svT;
			Film[] sTab = null;

			if (tEp.equals("tittel")) {

				System.out.println("\n Hva er Tittelen: ");
				svT = scanner.nextLine();
				svT = svT.toLowerCase();

				sTab = arkiv.soekTittel(svT);
				skrivUtFilmDelstrengITittel(arkiv, svT);

			} else if (tEp.equals("produsent")) {

				System.out.println("\n Hva er Produsent: ");
				svT = scanner.nextLine();
				svT = svT.toLowerCase();

				sTab = arkiv.soekProdusent(svT);
				skrivUtFilmProdusent(arkiv, svT);

			} else {
				System.out.println("\n Fant ingenting");
				return null;
			}

			System.out.println("Hvilke av disse? ");
			String index = scanner.nextLine();
			int intIndex = 0;
			intIndex = Integer.parseInt(index);

			if(intIndex >= sTab.length) {
				System.out.print("Det er ikke et valg");
				return null;
			}
			svar = sTab[intIndex];

			return svar;
		}
	}

	// vise en film med alle opplysninger på skjerm (husk tekst for sjanger)
	public void visFilm(Film film) {
		String svar = "\nNummer: " + film.getFilmnr() + "\nFilmselskap: " + film.getFilmselskap() + "\nÅr:"
				+ film.getLanseringsaar() + "\nProdusent: " + film.getProdusent() + "\nTittel: " + film.getTittel()
				+ "\nSjanger: " + film.getSjanger() + "\n";
		System.out.println(svar);
	}

	// Skrive ut alle Filmer med en spesiell delstreng i tittelen
	public void skrivUtFilmDelstrengITittel(FilmarkivADT filma, String delstreng) {
		Film[] svar = filma.soekTittel(delstreng);

		for (int i = 0; i < svar.length; i++) {
			if (svar[i] != null) {
				System.out.println("\n\nIndex " + i + ":");
				visFilm(svar[i]);
			}
		}
	}

	// Skriver ut alle Filmer av en produsent / en gruppe
	public void skrivUtFilmProdusent(FilmarkivADT filma, String delstreng) {
		Film[] svar = filma.soekProdusent(delstreng);

		for (int i = 0; i < svar.length; i++) {
			if (svar[i] != null) {
				System.out.println("\n\nIndex " + i + ":");
				visFilm(svar[i]);
			}
		}
	}

	public void skrivUtStatistikk(FilmarkivADT filma) {

		String ut = "\nAntall filmer: " + filma.antall() + "\nAction: " + filma.antall(Sjanger.ACTION) + "\nDrama: "
				+ filma.antall(Sjanger.DRAMA) + "\nHistory: " + filma.antall(Sjanger.HISTORY) + "\nSciFi: "
				+ filma.antall(Sjanger.SCIFI);

		System.out.print(ut);
	}
	/**Første kall på film.antall er O(1), 
	deretter skrives det ut statestikk over antall filmer med de ulike sjangerene disse 4 blir dermed 4k,
	derfor blir O-notasjonen O(k).**/

}