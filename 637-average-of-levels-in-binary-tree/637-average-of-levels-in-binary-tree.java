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
    public List<Double> averageOfLevels(TreeNode root) {
        
        ArrayList<Double> ans = new ArrayList<>();
        
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        q.add(null);  // when we hit null in queue then it signifies that all nodes present at that height/level has been traversed.
        double sum=0, count=0;
        while(!q.isEmpty())
        {
            TreeNode node = q.poll();
            
            if(node == null)
            {
                double average = sum/count;
                ans.add(average);
                sum = 0;
                count = 0;
                
                if(!q.isEmpty())
                {
                    q.add(null);
                }
                
            }
            else
            {
                sum+=node.val;
                count++;
                
                if(node.left != null)
                {
                    q.add(node.left);
                }
                if(node.right != null)
                {
                    q.add(node.right);
                }
            }
            
        }
             
        return ans;
    }
}