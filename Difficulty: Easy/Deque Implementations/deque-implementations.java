import java.util.ArrayDeque;

class Solution {
    // Push element x to the back of the deque
    public static void pb(ArrayDeque<Integer> dq, int x) {
        dq.addLast(x);
    }

    // Pop element from the back of the deque
    public static void ppb(ArrayDeque<Integer> dq) {
        if (!dq.isEmpty()) {
            dq.removeLast();
        }
    }

    // Return the front element of the deque
    public static int front_dq(ArrayDeque<Integer> dq) {
        if (!dq.isEmpty()) {
            return dq.getFirst();
        }
        return -1; // or throw exception or return a default value if deque is empty
    }

    // Push element x to the front of the deque
    public static void pf(ArrayDeque<Integer> dq, int x) {
        dq.addFirst(x);
    }
}
