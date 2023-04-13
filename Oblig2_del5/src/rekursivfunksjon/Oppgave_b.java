package rekursivfunksjon;

public class Oppgave_b {

	public static void main(String[] args) {

		String str = "";
		for (int i = 0; i < 10; i++) {
			str += sum(i) + ", ";
		}
		System.out.println(str);
		
	}

	private static long sum(long n) {
		long svar = 0;

		if (n == 0) {
			return 2;
		} else if (n==1) {
			return 5;
		}

		if (n > 1) {
			svar = 5 * sum(n - 1) - 6 * sum(n - 2) + 2;
		}
		return svar;
	}

}
