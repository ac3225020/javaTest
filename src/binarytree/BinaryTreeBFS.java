package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//二叉树的数组表示，基于广度优先算法遍历二叉树
public class BinaryTreeBFS {

    //树转数组 层次遍历
    public List<Integer> transferTreeBFSToList(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }else {
            return result;
        }
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current != null) {
                result.add(current.val);
            }
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
        return result;
    }

    public TreeNode transferBFSArrayToTree(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }

        TreeNode root = new TreeNode(list.get(0));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (i < list.size()) {
            TreeNode current = queue.poll();
            if (list.get(i) != null) {
                current.left = new TreeNode(list.get(i));
                queue.add(current.left);
            }
            i++;
            if (i < list.size() && list.get(i) != null) {
                current.right = new TreeNode(list.get(i));
                queue.add(current.right);
            }
        }
        return root;
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        List<Integer> bfs = new BinaryTreeBFS().transferTreeBFSToList(root);
        System.out.println(bfs);
        System.out.println(new BinaryTreeBFS().transferBFSArrayToTree(bfs));
    }
}
