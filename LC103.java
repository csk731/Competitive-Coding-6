// TC: O(N)
// SC: O(N)
// where N is the number of nodes in the tree

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class LC103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = -1;
        while(!q.isEmpty()){
            int size = q.size();
            level++;
            List<Integer> innerAns = new ArrayList<>();
            while(size>0){
                TreeNode pn = q.poll();
                innerAns.add(pn.val);
                if(pn.left!=null) q.add(pn.left);
                if(pn.right!=null) q.add(pn.right);
                size--;
            }
            if((level&1)==1) Collections.reverse(innerAns);
            ans.add(innerAns);
        }
        return ans;
    }
}