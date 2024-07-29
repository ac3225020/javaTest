package binarytree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.cn/problems/average-of-levels-in-binary-tree
//二叉树的层平均值
public class AverageOfLevelsInBinaryTree {

    public List<Double> averageOfLevels(TreeNode root) {

        List<Double> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Long sum = 0L;
            //重点 这里和简单的层次遍历不一样 要把数据全部取出来
            for (int i = 0 ; i < size ; i ++) {
                TreeNode current = queue.poll();
                sum += current.val;
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            result.add( (sum / (double)size));
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2147483647);
        root.left = new TreeNode(2147483647);
        root.right = new TreeNode(2147483647);
        System.out.println(new AverageOfLevelsInBinaryTree().averageOfLevels(root));
    }


}
