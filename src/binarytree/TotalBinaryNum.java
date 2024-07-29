package binarytree;

//完全二叉树的节点数
public class TotalBinaryNum {


    //思考 利用完全二叉树的性质
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }

        //要加上自己
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        System.out.println(new TotalBinaryNum().countNodes(root));
    }






}
