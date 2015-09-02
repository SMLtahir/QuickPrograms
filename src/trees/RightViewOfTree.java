package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered 
from top to bottom.
This solution involved adding to list only the last node of every level to give the right view.

A similar question can be constructed for the left view of a tree.
The solution to that would be similar to this one but instead of the last node, add the first node.
 * @author Tahir
 *
 */
public class RightViewOfTree {
    
	public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null) { return result;}
        
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        TreeNode endOfLevel = root;
        
        while(!q.isEmpty()) {
            TreeNode focus = q.remove();
            if(focus.left != null) { q.add(focus.left);}
            if(focus.right != null) { q.add(focus.right);}
            if(focus == endOfLevel) {
                result.add(focus.val);
                endOfLevel = q.peekLast();
            }
        }
        return result;
    }
}
