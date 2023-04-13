package no.hvl.dat102.kjedet;

import java.util.Stack;

import no.hvl.dat102.adt.ParentessjekkerADT;

public class Parentessjekker implements ParentessjekkerADT {

	@Override
	public boolean erVenstreparentes(char p) {

		char a = '{';
		char b = '(';
		char c = '[';

		if (p == a || p == b || p == c) {
			return true;
		}

		return false;
	}

	@Override
	public boolean erHogreparentes(char p) {

		char a = '}';
		char b = ')';
		char c = ']';

		if (p == a || p == b || p == c) {
			return true;
		}

		return false;
	}

	@Override
	public boolean erParentes(char p) {

		char a = '}';
		char b = ')';
		char c = ']';

		char d = '{';
		char e = '(';
		char f = '[';

		if (p == a || p == b || p == c || p == d || p == e || p == f) {
			return true;
		}

		return false;

	}

	@Override
	public boolean erPar(char venstre, char hogre) {

		char a = '{';
		char b = '[';
		char c = '(';
		char d = '}';
		char e = ']';
		char f = ')';

		if ((venstre == a && hogre == d) || (venstre == b && hogre == e) || (venstre == c && hogre == f)) {
			return true;
		}

		return false;

	}

	@Override
	public boolean erBalansert(String s) {

	    KjedetStabel<Character> stabel = new KjedetStabel<>();

	    for (int i = 0; i < s.length(); i++) {
	        char c = s.charAt(i);
	        if (erVenstreparentes(c)) {
	           
	            stabel.push(c);
	        } else if (erHogreparentes(c)) {
	            
	            if (stabel.erTom() || !erPar(stabel.pop(), c)) {
	                
	                return false;
	            }
	        }
	    }


	    return stabel.erTom();
	}

}
