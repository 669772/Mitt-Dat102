package no.hvl.dat102.klient;

import no.hvl.dat102.kjedet.Parentessjekker;

public class Parentessjekk_klient {
	public static void main(String[] args) {

		Parentessjekker sjekker = new Parentessjekker();

		String s1 = "({[()]})";
		String s2 = "{[()](";
		String s3 = "Hei)";
		String s4 = "{dette (danner) ikke ] par";

		System.out.println(s1 + " er balansert: " + sjekker.erBalansert(s1));
		System.out.println(s2 + " er balansert: " + sjekker.erBalansert(s2));
		System.out.println(s3 + " er balansert: " + sjekker.erBalansert(s3));
		System.out.println(s4 + " er balansert: " + sjekker.erBalansert(s4));
	}
}
