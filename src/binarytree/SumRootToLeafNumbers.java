package binarytree;

//https://leetcode.cn/problems/sum-root-to-leaf-numbers
//例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
//计算从根节点到叶节点生成的 所有数字之和
public class SumRootToLeafNumbers {

    //递归算法就是要算出递归元素之间的关系
    //本题中当前节点的叶子节点和叶子节点父节点的数字关系为 = 叶子节点.val + 父节点* 10
    //父节点和左右叶子节点关系为 父节点.value = 左节点+父节点* 10 + 右节点+父节点*10
    public int sumNumbers(TreeNode root) {
        return sumValue(root,0);
    }

    private int sumValue(TreeNode target,int parentValue) {
        if (target == null) {
            return 0;
        }
        int sum = target.val + parentValue*10;
        if (target.left == null && target.right == null) {
            return sum;
        }else {
            return sumValue(target.left,sum) + sumValue(target.right,sum);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(4);
        System.out.println(new SumRootToLeafNumbers().sumNumbers(root));
    }



}
