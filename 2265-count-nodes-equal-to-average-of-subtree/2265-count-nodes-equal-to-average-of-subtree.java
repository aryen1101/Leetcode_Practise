/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int count = 0;
    public int averageOfSubtree(TreeNode root) {

        
        dfs(root);
        return count;

    }

    public Pair dfs(TreeNode root){

        if(root == null) return new Pair(0,0);

        Pair left = dfs(root.left);
        Pair right = dfs(root.right);

        int sum = left.sum + right.sum + root.val;
        int nodeCount = left.count + right.count + 1;
        int avg = sum / nodeCount;

        if(root.val == avg) count++;

        return new Pair(sum , nodeCount);
    }

}

class Pair{
    int sum, count;

    Pair(int sum, int count){
        this.sum = sum;
        this.count = count;
    }
}