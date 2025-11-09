import java.util.ArrayList;

class GFG {
    // Function to find the first occurrence of x
    static int findFirst(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        int first = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == x) {
                first = mid;
                high = mid - 1; // search to the left (lower indices)
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return first;
    }

    // Function to find the last occurrence of x
    static int findLast(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        int last = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == x) {
                last = mid;
                low = mid + 1; // search to the right (higher indices)
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return last;
    }

    // Main function to find first and last occurrences
    ArrayList<Integer> find(int[] arr, int x) {
        ArrayList<Integer> res = new ArrayList<>();
        int first = findFirst(arr, x);
        int last = findLast(arr, x);

        res.add(first);
        res.add(last);

        return res;
    }
}
