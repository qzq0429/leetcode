package com.qzq.leetcode.tag.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class ZTreeiteratorTest {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		Queue<TreeNode> queue = new ArrayDeque<>();
		queue.add(root);
		boolean sort = true;
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> array = new ArrayList<Integer>();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				if (node != null) {
					array.add(node.val);
					if(node.left!=null)
					queue.add(node.left);
					if(node.right!=null)
					queue.add(node.right);
				}
			}
			if (sort != true) {
				Collections.reverse(array);
			}
			sort = !sort;
			list.add(array);

		}
		return list;
	}
}
