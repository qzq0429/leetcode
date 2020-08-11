package com.qzq.leetcode.tag.tree;

import java.util.HashMap;
import java.util.Map;

public class CreateTree_106_Test {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> inorderMap = new HashMap<Integer,Integer>();
        for(int i=0;i<inorder.length;i++) {
        	inorderMap.put(inorder[i],i);
        }
        int n = inorder.length;
        return createTree(inorder,postorder,0,n-1,0,n-1,inorderMap);
    }

	public  TreeNode createTree(int[] inorder, int[] postorder,
									int inorder_leftindex, int inorder_rightindex, 
										int postorder_leftindex, int postorder_rightindex,
										Map<Integer,Integer> map) {
		// TODO Auto-generated method stub
		if(postorder_leftindex>postorder_rightindex) {
			return null;
		}
		int size = postorder_rightindex-postorder_leftindex;
		int rootIndex = map.get(postorder[postorder_rightindex]);
		int leftSize = rootIndex-inorder_leftindex;
		TreeNode rootNode = new TreeNode(postorder[postorder_rightindex]);
		TreeNode leftNode = createTree(inorder,postorder,
										inorder_leftindex,rootIndex-1,
										postorder_leftindex,postorder_leftindex+leftSize-1
										,map);
		TreeNode rightNode = createTree(inorder,postorder,
											rootIndex+1,inorder_rightindex,
											postorder_leftindex+leftSize,postorder_rightindex-1
											,map);
		rootNode.left = leftNode;
		rootNode.right = rightNode;
		return rootNode;
	} 
}
