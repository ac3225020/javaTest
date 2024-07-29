package binarytree;

//检查树是否对称 注意 这里比较要比较两个节点是否对此 不是一个节点内部是否对称
public class Symmetric {


    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left,root.right);
    }

    private boolean isSymmetric(TreeNode left,TreeNode right) {
        if (left == null && right != null) {
            return false;
        }
        if (left != null && right == null) {
            return false;
        }

        if (left == null && right == null) {
            return true;
        }
        if (left.val == right.val) {
            return isSymmetric(left.left,right.right) && isSymmetric(left.right,right.left);
        }else {
            return false;
        }
    }




    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        System.out.println(new Symmetric().isSymmetric(root));
        System.out.println(new PreorderTraversal().traversal(root));
        System.out.println(new MiddleOrderTraversal().traversal(root));
        System.out.println(new LastOrderTraversal().traversal(root));
    }
}
