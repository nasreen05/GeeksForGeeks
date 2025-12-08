class Complete {
    public static ArrayList<Integer> array(int a[][], int b[], int n) {
        ArrayList<Integer> result = new ArrayList<>();
        
        int sumDiagonal = 0;
        int maxVal = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            sumDiagonal += a[i][i];     // Left diagonal element
            maxVal = Math.max(maxVal, b[i]); // Track maximum of 1D array
        }

        result.add(sumDiagonal);
        result.add(maxVal);
        
        return result;
    }
}
