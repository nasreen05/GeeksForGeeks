import java.util.*;

class Solution {
    public List<Integer> frequencyCount(int[] arr) {
        int n = arr.length;
        int[] freq = new int[n];
        
        // Count frequency of each number in arr
        for (int num : arr) {
            if (num >= 1 && num <= n) {
                freq[num - 1]++;
            }
        }
        
        // Convert the frequency array to List<Integer> and return
        List<Integer> result = new ArrayList<>();
        for (int count : freq) {
            result.add(count);
        }
        return result;
    }
}
