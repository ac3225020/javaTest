package binarytree;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.cn/problems/kth-smallest-element-in-a-bst
public class KthSmallest {

    //求k小的数 先中序遍历 再取第k个
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> nums = new ArrayList<>();
        fillValuesFromBST(nums,root);
        return nums.get(k-1);
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

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        System.out.println(new KthSmallest().kthSmallest(root,1));
    }


}
