package com.qzq.leetcode.tag.tree;

import java.util.Arrays;

public class CreateTreeTest {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if(preorder.length==0) {
			return null;
		}
		
		if (preorder.length == 3) {
			TreeNode left = new TreeNode(inorder[2], null, null);
			TreeNode right = new TreeNode(inorder[0], null, null);
			TreeNode root = new TreeNode(inorder[1], left, right);
		}
		if (preorder.length == 2) {
			
			TreeNode right = null;
			TreeNode left  = null;
			if (inorder[0] == preorder[0]) {
				right = new TreeNode(preorder[1], null, null);

			} else {
				left = new TreeNode(preorder[1], null, null);

			}
			
			return new TreeNode(preorder[0], left, right);
		}
		if(preorder.length==1) {
			return new TreeNode(preorder[0],null,null);
		}
		
		int root = preorder[0];
		int size = preorder.length;
		int indexRoot =-1; 
		for(int i=0;i<size;i++) {
			if(root == inorder[i]) {
				indexRoot=i;
			}
		}
		
		if(indexRoot==0) {
			int[] rightPr = Arrays.copyOfRange(preorder,1, size);
			int[] rightIn = Arrays.copyOfRange(inorder, 1, size);
			TreeNode RightTreeNode = buildTree(rightPr,rightIn);
			TreeNode RootTreeNode = new TreeNode(root, null, RightTreeNode);
			return RootTreeNode;
		}
		
		if(indexRoot==size-1) {
			int[] leftPr = Arrays.copyOfRange(preorder,1, size);
			int[] leftIn = Arrays.copyOfRange(inorder, 0, size-1);
			TreeNode leftTreeNode = buildTree(leftPr,leftIn);
			TreeNode RootTreeNode = new TreeNode(root, leftTreeNode, null);
			return RootTreeNode;
		}
		
		int leftSize = indexRoot; 
		int rightSize = size-indexRoot-1;		
		int[] leftPr = Arrays.copyOfRange(preorder, 1, leftSize+1);
		int[] leftIn = Arrays.copyOfRange(inorder,0, indexRoot);
		
		int[] rightPr = Arrays.copyOfRange(preorder, leftSize+1, size);
		int[] rightIn = Arrays.copyOfRange(inorder,indexRoot+1, size);
		 TreeNode leftTreeNode = buildTree(leftPr,leftIn);
		 TreeNode rightTreeNode = buildTree(rightPr,rightIn);
		return new TreeNode(root, leftTreeNode, rightTreeNode);
	}
}
