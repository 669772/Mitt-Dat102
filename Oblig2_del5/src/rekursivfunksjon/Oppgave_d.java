package rekursivfunksjon;

public class Oppgave_d {

	public static void main(String[] args) {
		
		System.out.println(sum(4));
		System.out.println(sum(10));
		System.out.println(sum(40));
		
	}
	
	public static long sum(long n) {
	    if (n <= 1) {
	        return n;
	    }
	    
	    long fib = 1;
	    long prevFib = 1;
	    
	    for (long i = 2; i < n; i++) {
	        long temp = fib;
	        fib += prevFib;
	        prevFib = temp;
	    }
	    
	    return fib;
	}

}
