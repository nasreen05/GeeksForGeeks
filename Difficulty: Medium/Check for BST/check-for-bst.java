class Solution {
    public boolean isBST(Node root) {
        return isBSTUtil(root, null, null);
    }
    
    private boolean isBSTUtil(Node node, Integer min, Integer max) {
        if (node == null) 
            return true;
        
        // If node's data violates the min/max constraint, not a BST
        if ((min != null && node.data <= min) || (max != null && node.data >= max)) 
            return false;
        
        // Recursively check subtrees with updated ranges
        return isBSTUtil(node.left, min, node.data) && 
               isBSTUtil(node.right, node.data, max);
    }
}
