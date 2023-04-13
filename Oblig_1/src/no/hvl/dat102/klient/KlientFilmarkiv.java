package no.hvl.dat102.klient;

import no.hvl.dat102.Filmarkiv;
import no.hvl.dat102.adt.FilmarkivADT;

public class KlientFilmarkiv {

	public static void main(String[] args) { 
		  FilmarkivADT film = new Filmarkiv(100);  
		  Meny meny = new Meny(film); 
		  meny.start(); 
		 } 
	
}
