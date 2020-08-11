package com.qzq.leetcode.tag.dp;

import java.util.HashMap;
import java.util.Map;

import com.qzq.leetcode.tag.tree.TreeNode;

public class ROBIII {
	Map<TreeNode,Integer> f = new HashMap<TreeNode,Integer>();
	Map<TreeNode,Integer> g = new HashMap<TreeNode,Integer>();
	public int rob(TreeNode root) {
		dfs(root);
		return Math.max(f.getOrDefault(root, 0), g.getOrDefault(root, 0));
	}

	public void dfs(TreeNode node) {
		// TODO Auto-generated method stub
		if(node == null) {
			return ;
		}
		dfs(node.left);
		dfs(node.right);
		f.put(node, node.val+g.getOrDefault(node.left, 0)+g.getOrDefault(node.right, 0));
		g.put(node, Math.max(f.getOrDefault(node.left, 0), g.getOrDefault(node.left, 0))
				+Math.max(f.getOrDefault(node.right, 0), g.getOrDefault(node.right, 0))
				);
	}
}
