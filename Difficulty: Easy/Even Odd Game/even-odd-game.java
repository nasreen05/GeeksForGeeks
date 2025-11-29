import java.util.*;

public class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            
            if (n % 2 == 1) {
                System.out.println("You");
            } else {
                System.out.println("Friend");
            }
        }
        sc.close();
    }
}
