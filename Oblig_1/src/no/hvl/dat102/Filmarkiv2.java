package no.hvl.dat102;

import no.hvl.dat102.adt.FilmarkivADT;

public class Filmarkiv2 implements FilmarkivADT {

	private int antall;
	private LinearNode<Film> start;

	public Filmarkiv2() {
		start = null;
		antall = 0;
	}

	@Override
	public Film finnFilm(int nr) {

		boolean funnet = false;
		int i = 0;
		Film svar = null;

		while (funnet == false && i < antall) {
			if (start.getElement().getFilmnr() == nr) {
				funnet = true;
				svar = start.getElement();
				return svar;
			}
			start = start.getNeste();
		}
		return svar;
	}

	@Override
	public void leggTilFilm(Film nyFilm) {
		LinearNode<Film> newNode = new LinearNode<>(nyFilm);
		newNode.setNeste(start);
		start = newNode;
		antall++;

	}

	@Override
	public boolean slettFilm(int filmnr) {

		LinearNode<Film> aktuell = start;
		LinearNode<Film> forgjenger = null;

		while (aktuell != null) {
			if (aktuell.getElement().getFilmnr() == filmnr) {
				if (forgjenger == null) {
					start = aktuell.getNeste();
				} else {
					forgjenger.setNeste(aktuell.getNeste());
				}
				antall--;
				return true;
			}
			forgjenger = aktuell;
			aktuell = aktuell.getNeste();
		}
		return false;
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

		LinearNode<Film> aktuell = start;
		int i = 0;
		Film[] svar = new Film[antall];

		while (aktuell != null) {

			if (aktuell.getElement().getTittel().contains(delstreng)) {
				svar[i] = aktuell.getElement();
			}
			aktuell = aktuell.getNeste();
			i++;
		}
		trimTab(svar, i);
		return svar;
	}

	@Override
	public Film[] soekProdusent(String delstreng) {
		LinearNode<Film> aktuell = start;
		int i = 0;
		Film[] svar = new Film[antall];

		while (aktuell != null) {

			if (aktuell.getElement().getProdusent().contains(delstreng)) {
				svar[i] = aktuell.getElement();
			}
			aktuell = aktuell.getNeste();
			i++;
		}
		trimTab(svar, i);
		return svar;
	}

	@Override
	public int antall(Sjanger sjanger) {
		
		LinearNode<Film> aktuell = start;
		int as = 0;
		
		while (aktuell != null) {
			if (aktuell.getElement().getSjanger() == sjanger) {
				as++;
			}
		}
		return as;
	}
	//O-notasjon O(k), løkken går gjennom hvert element en gang, derav O(k).

	@Override
	public int antall() {
		// TODO Auto-generated method stub
		return antall;
	}

}
