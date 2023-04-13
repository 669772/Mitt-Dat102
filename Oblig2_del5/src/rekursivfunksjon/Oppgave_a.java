package rekursivfunksjon;

public class Oppgave_a {

	public static void main(String[] args) {

		System.out.print(sum(100));
		
	}

	private static long sum(long n) {
		long svar = 0;

		if (n == 0) {
			return 0;
		}

		svar = n + sum(n - 1);

		return svar;

	}

}
