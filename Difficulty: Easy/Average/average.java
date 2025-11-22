class Solution {
    public static double posAverage(int[] arr) {
        double sum = 0;
        int count = 0;
        
        for(int num : arr) {
            if(num >= 0) {
                sum += num;
                count++;
            }
        }
        
        if(count == 0) {
            return 0.0; // or handle no non-negative number case appropriately
        }
        
        return sum / count;
    }
}
