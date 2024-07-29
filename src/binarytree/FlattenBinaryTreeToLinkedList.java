package binarytree;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.cn/problems/flatten-binary-tree-to-linked-list
public class FlattenBinaryTreeToLinkedList {

    public void flatten(TreeNode root) {
        List<TreeNode> list = preTraversal(root);
        //TreeNode newRoot = new TreeNode(Integer.MAX_VALUE);
        TreeNode temp = root;
        int index = 1 ;
        while (index < list.size()) {
            temp.left = null;
            temp.right = list.get(index);
            temp = temp.right;
            index++;
        }
    }

    private List<TreeNode> preTraversal(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        doPreTraversal(list,root);
        return list;
    }

    private void doPreTraversal(List<TreeNode> list,TreeNode target) {
        if (target == null) {
            return;
        }
        list.add(target);
        doPreTraversal(list,target.left);
        doPreTraversal(list,target.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);

        new FlattenBinaryTreeToLinkedList().flatten(root);
        System.out.println(root);

    }




}
