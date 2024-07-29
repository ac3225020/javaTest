package binarytree;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.cn/problems/validate-binary-search-tree
public class IsValidBST {

    public boolean isValidBST(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        fillValuesFromBST(nums,root);
        return isOrder(nums);
    }

    private void fillValuesFromBST(List<Integer> nums, TreeNode target) {
        if (target.left != null) {
            fillValuesFromBST(nums,target.left);
        }
        nums.add(target.val);
        if (target.right != null) {
            fillValuesFromBST(nums,target.right);
        }
    }

    private boolean isOrder(List<Integer> nodes) {
        for (int i = 0; i < nodes.size()-1; i++) {
            Integer left = nodes.get(i);
            Integer right = nodes.get(i+1);
            if (right <= left) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);
        System.out.println(new IsValidBST().isValidBST(root));
    }

}
