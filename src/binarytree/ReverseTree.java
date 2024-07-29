package binarytree;


public class ReverseTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode rightTemp = root.right;
        TreeNode leftTemp = root.left;
        root.right = leftTemp;
        root.left = rightTemp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new MiddleOrderTraversal().traversal(root));
        TreeNode newRoot = new ReverseTree().invertTree(root);
        System.out.println(new MiddleOrderTraversal().traversal(newRoot));

    }


}
