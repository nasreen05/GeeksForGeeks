class Solution {
    public ArrayList<Integer> findDuplicates(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int index = Math.abs(arr[i]) - 1;
            
            // If already negative → duplicate found
            if (arr[index] < 0) {
                result.add(Math.abs(arr[i]));
            } else {
                arr[index] = -arr[index]; 
            }
        }

        return result;
    }
}
