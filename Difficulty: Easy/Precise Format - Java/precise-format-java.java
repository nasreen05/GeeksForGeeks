import java.util.ArrayList;

class Solution {
    static ArrayList<Float> divisionWithPrecision(float a, float b) {
        ArrayList<Float> results = new ArrayList<>();
        float exactResult = a / b;
        results.add(exactResult);
        
        // Format the result to 3 decimal places using String.format and parse back to float
        String formattedString = String.format("%.3f", exactResult);
        float formattedResult = Float.parseFloat(formattedString);
        results.add(formattedResult);
        
        return results;
    }
}
