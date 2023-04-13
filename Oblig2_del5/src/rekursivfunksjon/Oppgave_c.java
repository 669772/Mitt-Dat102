package rekursivfunksjon;

public class Oppgave_c {

	public static void main(String[] args) {

		System.out.println(sum(4));
		System.out.println(sum(10));
		System.out.println(sum(40));

	}

	private static long sum(long n) {
		long svar = 0;

		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		}

		svar = sum(n - 1) + sum(n - 2);

		return svar;
	}

}
