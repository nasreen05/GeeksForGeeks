import java.util.*;

public class Solution {
    public static void solve() {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        
        // Print numbers from x down to 0 using while loop
        int i = x;
        while (i >= 0) {
            System.out.print(i);
            if (i > 0) {
                System.out.print(" ");
            }
            i--;
        }
        System.out.println();
    }
}
