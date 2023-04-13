package no.hvl.dat102;

import no.hvl.dat102.adt.*;

public class Filmarkiv implements FilmarkivADT {

	protected Film[] data;
	protected int nesteledig;

	public Filmarkiv() {
		data = new Film[20];
		nesteledig = 0;
	}

	public Filmarkiv(int lengde) {
		data = new Film[lengde];
		nesteledig = 0;
	}

	public Film[] getData() {
		return data;
	}

	public void setData(Film[] data) {
		this.data = data;
	}

	public int getNesteledig() {
		return nesteledig;
	}

	public void setNesteledig(int nesteledig) {
		this.nesteledig = nesteledig;
	}

	@Override
	public Film finnFilm(int nr) {

		boolean funnet = false;
		int i = 0;
		Film svar = null;

		while (funnet == false && i < nesteledig) {

			if (data[i].getFilmnr() == nr) {
				funnet = true;
				svar = data[i];
			}

			i++;
		}

		return svar;
	}

	private void utvid() {
		Film[] nytab = new Film[data.length * 2];
		nesteledig = 0;

		for (int i = 0; i < data.length; i++) {
			nytab[i] = data[i];
			nesteledig++;
		}

		data = nytab;
	}

	@Override
	public void leggTilFilm(Film nyFilm) {

		if (nesteledig >= data.length) {
			utvid();
		}
		
		data[nesteledig] = nyFilm;
		nesteledig++;
	}

	@Override
	public boolean slettFilm(int filmnr) {

		boolean svar = false;

		for (int i = filmnr; i <= nesteledig; i++) {
			if (i == nesteledig) {
				data[i] = null;
				svar = true;
			} else {
				data[i] = data[i + 1];
			}
		}
		nesteledig--;

		return svar;
	}

	private Film[] trimTab(Film[] tab, int n) {
		// n er antall elementer
		Film[] nytab = new Film[n];
		int i = 0;
		while (i < n) {
			nytab[i] = tab[i];
			i++;
		}
		return nytab;
	}

	@Override
	public Film[] soekTittel(String delstreng) {

		Film[] svar = new Film[nesteledig];
		int j = 0;
		for (int i = 0; i < nesteledig; i++) {
			if (data[i].getTittel().contains(delstreng)) {
				svar[j] = data[i];
				j++;
			}
		}
		trimTab(svar, (j - 1));

		return svar;
	}

	@Override
	public Film[] soekProdusent(String delstreng) {

		Film[] svar = new Film[nesteledig];
		int j = 0;
		for (int i = 0; i < nesteledig; i++) {
			if (data[i].getProdusent().contains(delstreng)) {
				svar[j] = data[i];
				j++;
			}
		}
		trimTab(svar, j);

		return svar;
	}

	@Override
	public int antall(Sjanger sjanger) {

		int svar = 0;

		for (int i = 0; i < nesteledig; i++) {
			if (data[i].getSjanger() == sjanger) {
				svar++;
			}
		}

		return svar;
	}

	@Override
	public int antall() {

		return nesteledig;
	}
}