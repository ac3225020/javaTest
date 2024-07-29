package binarytree;

public class WaySum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        //重要 值相等且 左右为空
        if (root.val == targetSum && root.left == null && root.right == null) {
            return true;
        }

        return hasPathSum(root.left,targetSum-root.val) || hasPathSum(root.right,targetSum-root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-2);
        root.right = new TreeNode(-3);
        //System.out.println(new WaySum().hasPathSum(root,5));
        System.out.println(new WaySum().hasPathSum(root,-5));
        //System.out.println(new WaySum().hasPathSum(root,4));
    }


}
