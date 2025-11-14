import java.util.*;

class Solution {
    boolean pythagoreanTriplet(int[] arr) {
        int n = arr.length;
        if (n < 3) return false;

        // Get frequency of each number
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Get unique values and sort them
        Set<Integer> uniqueSet = new HashSet<>();
        for (int num : arr) {
            uniqueSet.add(num);
        }
        List<Integer> vals = new ArrayList<>(uniqueSet);
        Collections.sort(vals);

        // Get squares of unique values (already sorted since vals is sorted)
        List<Integer> squares = new ArrayList<>();
        for (int v : vals) {
            squares.add(v * v);
        }

        // Now, check for each pair a, b where a <= b
        for (int i = 0; i < vals.size(); i++) {
            for (int j = i; j < vals.size(); j++) {  // j starts from i to allow a == b
                int a = vals.get(i);
                int b = vals.get(j);
                long sumSq = (long) a * a + (long) b * b;  // Use long to avoid overflow
                // Binary search for sumSq in squares
                int idx = Collections.binarySearch(squares, (int) sumSq);
                if (idx >= 0) {
                    int c = vals.get(idx);
                    // Now check conditions based on frequencies
                    if (a == b) {
                        if (freq.get(a) >= 2) {
                            if (c == a) {
                                if (freq.get(a) >= 3) return true;
                            } else {
                                if (freq.get(c) >= 1) return true;
                            }
                        }
                    } else {
                        if (freq.get(a) >= 1 && freq.get(b) >= 1) {
                            if (c == a) {
                                if (freq.get(a) >= 2) return true;
                            } else if (c == b) {
                                if (freq.get(b) >= 2) return true;
                            } else {
                                if (freq.get(c) >= 1) return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}

