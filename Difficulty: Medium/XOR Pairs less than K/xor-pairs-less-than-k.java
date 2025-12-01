import java.util.*;

class TrieNode {
    TrieNode[] children = new TrieNode[2];
    int count = 0;  // count of numbers passing through this node
}

class Solution {
    public int cntPairs(int[] arr, int k) {
        TrieNode root = new TrieNode();
        int result = 0;
        for (int num : arr) {
            result += countLess(root, num, k, 31);
            insert(root, num);
        }
        return result;
    }

    private void insert(TrieNode root, int num) {
        TrieNode node = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (node.children[bit] == null)
                node.children[bit] = new TrieNode();
            node = node.children[bit];
            node.count++;
        }
    }

    private int countLess(TrieNode node, int num, int k, int bitIndex) {
        if (node == null || bitIndex < 0) return 0;

        int numBit = (num >> bitIndex) & 1;
        int kBit = (k >> bitIndex) & 1;

        if (kBit == 1) {
            // If kBit=1, can add all nodes children[numBit] (XOR bit 0 < 1)
            // Then go down children[1-numBit]
            int res = 0;
            if (node.children[numBit] != null)
                res += node.children[numBit].count;
            res += countLess(node.children[1 - numBit], num, k, bitIndex - 1);
            return res;
        } else {
            // If kBit=0, need XOR bit to be 0 => follow same bit only
            return countLess(node.children[numBit], num, k, bitIndex - 1);
        }
    }
}
