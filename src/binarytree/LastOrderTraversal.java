package binarytree;

import java.util.ArrayList;
import java.util.List;

public class LastOrderTraversal {


    public List<Integer> traversal(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        traversal(values, root);
        return values;
    }

    private void traversal(List<Integer> values, TreeNode target) {
        if (target == null) {
            return;
        }
        if (target.left != null) {
            traversal(values, target.left);
        }

        if (target.right != null) {
            traversal(values, target.right);
        }

        Integer value = target.val;
        values.add(value);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(new LastOrderTraversal().traversal(root));
    }
}
