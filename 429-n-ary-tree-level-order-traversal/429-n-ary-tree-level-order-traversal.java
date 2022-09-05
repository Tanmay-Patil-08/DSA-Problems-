/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        
        List<List<Integer>> ans  = new ArrayList<List<Integer>>(); 
        if(root == null ){
            return ans;
        }
        
        Queue <Node> q  = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            
            int len = q.size();
            List <Integer> level = new ArrayList<> ();
            
            for(int i = 0 ; i < len ; i++ ){
                
                Node currNode = q.poll();
                level.add(currNode.val);
                
                for(Node child : currNode.children ){
                    q.add(child);
                }
                
            }
            ans.add(level);
            
            
        }
        return ans;
        
        
    }
}