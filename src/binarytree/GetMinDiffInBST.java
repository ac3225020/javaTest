package binarytree;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.cn/problems/minimum-absolute-difference-in-bst
public class GetMinDiffInBST {

    //查找二叉搜索树之间任何两个节点之间的最小差值(绝对值)
    //搜索二叉树的中序遍历是递增的
    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<Integer> nums = new ArrayList<>();
        fillValuesFromBST(nums,root);
        return getMinValueByList(nums);

    }

    private Integer getMinValueByList(List<Integer> nums) {
        Integer min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.size() -1; i++) {
            min = Math.min(Math.abs(nums.get(i)-nums.get(i+1)),min);
        }
        return min == Integer.MAX_VALUE ? 0: min;
    }

    private void fillValuesFromBST(List<Integer> nums,TreeNode target) {
        if (target.left != null) {
            fillValuesFromBST(nums,target.left);
        }
        nums.add(target.val);
        if (target.right != null) {
            fillValuesFromBST(nums,target.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(236);
        root.left = new TreeNode(104);
        root.right = new TreeNode(701);
        root.left.right = new TreeNode(227);
        root.right.right = new TreeNode(911);
        //root.left.right = new TreeNode(3);
        System.out.println(new GetMinDiffInBST().getMinimumDifference(root));
    }
}
