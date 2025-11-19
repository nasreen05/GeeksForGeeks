import java.util.Scanner;

public class Solution {
    public static void solve() {
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        int b = scn.nextInt();
        int c = scn.nextInt();

        int d = a ^ a;         // XOR of a with itself = 0
        int e = c ^ b;         // XOR of c and b
        e = ~e;                // NOT of e
        int f = a & b;         // AND of a and b
        int g = c | (a ^ a);   // OR of c with (a XOR a) which is c | 0 = c

        System.out.println(d + " " + e + " " + f + " " + g);
    }
}
