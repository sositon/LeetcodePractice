import java.util.Stack;

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
 }
class Pair {
    TreeNode treeNode;
    Integer maxValue;
    public Pair(TreeNode root, Integer maxValue) {
        this.treeNode = root;
        this.maxValue = maxValue;
    }
}

public class CountGoodNodes {
    public int goodNodes(TreeNode root) {
        if(root == null) return 0;
        int goodNodes = 0;
        Stack<Pair> st = new Stack<>();
        st.add(new Pair(root, Integer.MIN_VALUE));
        while (!st.empty()){
            Pair pair = st.pop();
            TreeNode node = pair.treeNode;
            Integer maxInPath = pair.maxValue;
            if (node.val >= maxInPath)
                goodNodes++;
            if (node.left != null)
                st.add(new Pair(node.left, Math.max(node.val, maxInPath)));
            if (node.right != null)
                st.add(new Pair(node.right, Math.max(node.val, maxInPath)));
        }
        return goodNodes;
    }

    public static void main(String[] args) {
        CountGoodNodes countGoodNodes = new CountGoodNodes();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);
        System.out.println(countGoodNodes.goodNodes(root));
    }
}
