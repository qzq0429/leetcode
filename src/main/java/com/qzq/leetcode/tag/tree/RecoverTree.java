package com.qzq.leetcode.tag.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RecoverTree {

	/**
	 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
	 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
	 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
	 * = left; this.right = right; } }
	 */

//	public void recoverTree(TreeNode root) {
//		List<TreeNode> nodeList = new ArrayList<TreeNode>();
//		MiddleInsert(root, nodeList);
//		List<Integer> integerList = nodeList.stream().map(e -> {
//			return e.val;
//		}).collect(Collectors.toList());
//		int[] a = findSwap(integerList);
//		recover(nodeList, a[0], a[1]);
//	}
//
//	public void MiddleInsert(TreeNode root, List<TreeNode> list) {
//
//		if (root == null) {
//			return;
//		}
//		MiddleInsert(root.left, list);
//		list.add(root);
//		MiddleInsert(root.right, list);
//
//	}
//
//	public int[] findSwap(List<Integer> list) {
//		Integer x = null;
//		Integer y = null;
//		for (int i = 0; i < list.size() - 1; i++) {
//			if (list.get(i) > list.get(i + 1)) {
//				y = list.get(i + 1);
//				if (x == null)
//					x = list.get(i);
//				else
//					break;
//			}
//
//		}
//
//		return new int[] { x, y };
//
//	}
//
//	public void recover(List<TreeNode> NodeList, int x, int y) {
//		int count = 2;
//		for (int i = 0; i < NodeList.size(); i++) {
//			TreeNode node = NodeList.get(i);
//			if (node.val == x || node.val == y) {
//				if (node.val == x) {
//					node.val = y;
//					count--;
//				} else {
//					node.val = x;
//					count--;
//				}
//				if (count == 0) {
//					break;
//				}
//			}
//		}
//	}

	public void swap(TreeNode a, TreeNode b) {
		int tmp = a.val;
		a.val = b.val;
		b.val = tmp;
	}

	public void recoverTree(TreeNode root) {
		// predecessor is a Morris predecessor.
		// In the 'loop' cases it could be equal to the node itself predecessor == root.
		// pred is a 'true' predecessor,
		// the previous node in the inorder traversal.
		TreeNode x = null, y = null, pred = null, predecessor = null;

		while (root != null) {
			// If there is a left child
			// then compute the predecessor.
			// If there is no link predecessor.right = root --> set it.
			// If there is a link predecessor.right = root --> break it.
			if (root.left != null) {
				// Predecessor node is one step left
				// and then right till you can.
				predecessor = root.left;
				while (predecessor.right != null && predecessor.right != root)
					predecessor = predecessor.right;

				// set link predecessor.right = root
				// and go to explore left subtree
				if (predecessor.right == null) {
					predecessor.right = root;
					root = root.left;
				}
				// break link predecessor.right = root
				// link is broken : time to change subtree and go right
				else {
					// check for the swapped nodes
					if (pred != null && root.val < pred.val) {
						y = root;
						if (x == null)
							x = pred;
					}
					pred = root;

					predecessor.right = null;
					root = root.right;
				}
			}
			// If there is no left child
			// then just go right.
			else {
				// check for the swapped nodes
				if (pred != null && root.val < pred.val) {
					y = root;
					if (x == null)
						x = pred;
				}
				pred = root;

				root = root.right;
			}
		}
		swap(x, y);
	}

}
