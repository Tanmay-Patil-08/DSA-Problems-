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
    public TreeNode pruneTree(TreeNode root) {
        
        if(ContainsOne(root)){
            return root;
        }
        else{
            return null;
        }
        
        
    }
    public boolean ContainsOne (TreeNode root ){
        if(root == null ){
            return false;
        }
        boolean leftContainsOne =ContainsOne(root.left );
        
        boolean rightContainsOne = ContainsOne(root.right);
        
        if(!leftContainsOne) root.left = null;
        if(!rightContainsOne) root.right = null;
        
        return root.val == 1 || leftContainsOne || rightContainsOne;

    }
    
}