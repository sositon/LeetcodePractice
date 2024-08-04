# Count Good Nodes in Binary Tree

Given a binary tree, we need to count the number of "good" nodes. A node is considered "good" if in the path from the root to that node, there are no nodes with a value greater than the current node's value.

## Class Definition

### TreeNode

The `TreeNode` class represents a node in the binary tree. It has an integer value and two child nodes: `left` and `right`.

```java
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }class Pair {
    TreeNode treeNode;
    Integer maxValue;
    public Pair(TreeNode root, Integer maxValue) {
        this.treeNode = root;
        this.maxValue = maxValue;
    }
}public class CountGoodNodes {
    public int goodNodes(TreeNode root) {
        // implementation here
    }
}
    3
   / \
  1   4
 /   / \
3   1   5
Please note that the actual implementation of the `goodNodes` method is not included in this markdown file.