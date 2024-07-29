package binarytree;

import java.util.*;

//https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal
public class BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            Integer[] array = new Integer[size];
            for (int i = 0;i < size;i++) {
                TreeNode node = nodes.poll();
                array[size-i-1] = node.val;
                if (node.left != null) {
                    nodes.offer(node.left);
                }
                if (node.right != null) {
                    nodes.offer(node.right);
                }
            }
            result.add(Arrays.asList(array));
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new BinaryTreeZigzagLevelOrderTraversal().zigzagLevelOrder(root));
    }


}
