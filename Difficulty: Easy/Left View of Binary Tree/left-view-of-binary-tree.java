import java.util.ArrayList;

class Solution {
    private int maxLevel = 0;

    public ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        leftViewHelper(root, 1, result);
        return result;
    }

    private void leftViewHelper(Node node, int level, ArrayList<Integer> result) {
        if (node == null) return;

        // If this is the first node of its level
        if (level > maxLevel) {
            result.add(node.data);
            maxLevel = level;
        }

        // Recur for left subtree first to ensure left view
        leftViewHelper(node.left, level + 1, result);
        leftViewHelper(node.right, level + 1, result);
    }
}
