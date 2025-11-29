import java.util.*;

class Solution {
    public static void squareWall(int s) {
        for(int i = 1; i <= s; i++) {
            for(int j = 1; j <= s; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        squareWall(s);
        sc.close();
    }
}
