package com.qzq.leetcode.tag.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class IteratorTree {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {

		Queue queue = new ArrayDeque<TreeNode>();
		List<List<Integer>> allList = new ArrayList<List<Integer>>();
		if (root == null) {
			return allList;
		}
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < size; i++) {
				TreeNode node = (TreeNode) queue.poll();
				list.add(node.val);
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
				queue.add(node.right);
			}
			allList.add(list);
		}
		List<List<Integer>> tmpList = new ArrayList<List<Integer>>();
		int size = allList.size();
		for (int i = size - 1; i < size; i++) {
			List<Integer> tlist = allList.get(i);
			if (i % 2 != 0) {
				int tmpSize = tlist.size();
				List<Integer> hlist = new ArrayList<Integer>();
				for (int j = 0; j < tmpSize; j++) {
					int tmp = tlist.get(tmpSize - 1 - j);
					hlist.add(tmp);
				}
				tmpList.add(hlist);
			}

			tmpList.add(tlist);

		}
		return tmpList;

	}
}
