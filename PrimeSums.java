/**
 * @author stolljoe
 */
public class PrimeSums {
	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		for(int i=4; i<= N;i++) {// for every number i=4 to N execute numberofSums(i);//numberOfSums
			System.out.println(i+": "+numberOfSums(getFirstPrimes(i),getFirstPrimes(i).length,i));
		}
	}
    static long numberOfSums( int Primearr[], int min, int N ) 
    { 
       if (N == 0)  return 1; // If N == 0 → 1 Solution 
       if (N < 0) return 0;  // if N < 0 → no solution exists 
       if (min <=0 && N >= 1) return 0; // no solution
       return numberOfSums( Primearr, min - 1, N ) + numberOfSums( Primearr, min, N-Primearr[min-1] );  // include S[m-1] (ii) exclude S[m-1] 
    } 
	static boolean prime(int n) { //WORKS & TESTED from PrimeUtils
		if(n==1) return false;
		if(n==2||n==3) return true;
		else {
			if(n%2==0) return false;
			for(int j = 3;j<=(n/2)+1;j=j+2) {
				if(n%j==0) return false;
			}
			return true;
		}
	}
	public static int[] getFirstPrimes(int limit) { //WORKS & TESTED from PrimeUtils
		int N=0; // Number of primes we are getting 
		for(int i=2;i<limit;i++) { // Lookup of how many Primes we get
			if(prime(i)) N++;
		}	//EndOf Lookup
		int[] firstprimes = new int[N]; // Now we can declare our array
		int k=0; // k is the pos in array
		for(int i=2;i<limit;i++) // 
		{
			if(prime(i)) {
				firstprimes[k]=i;
				k++;
			}	//EndOf Lo
		}
		return firstprimes;
	}
}
