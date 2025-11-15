class Solution {
    public static void printPrimeFactorization(int n) {
        
        while (n % 2 == 0) {  //print the number of 2n devided by n
            System.out.print(2 + " ");
            n /= 2;
        }
        // n must be odd at this point,  factors from 3
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                System.out.print(i + " ");
                n /= i;
            }
        }
        // If n is still greater than 2, then it's prime number
        if (n > 2) {
            System.out.print(n + " ");
        }
    }
}
