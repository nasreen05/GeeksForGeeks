class Solution {
    public static void operators(int a, int b, int c) {
         // code here
        int d,e,f,g;
        d = a ^ a;
        e = c ^ b;
        f = a & b;
        g = c | (a ^ a);
        e = ~ e;
        
        System.out.println(d +" "+ e +" "+ f +" "+ g);

    }
}
        
    

