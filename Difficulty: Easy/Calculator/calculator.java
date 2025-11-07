class Solution {
    public void calculate(int a, int b, int operator) {
        if (operator == 1) {
            System.out.println(a + b);
        } else if (operator == 2) {
            System.out.println(a - b);
        } else if (operator == 3) {
            System.out.println(a * b);
        } else {
            System.out.println("Invalid Input");
        }
    }
}