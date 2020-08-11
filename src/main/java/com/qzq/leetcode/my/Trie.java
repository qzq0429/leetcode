package com.qzq.leetcode.my;

public class Trie {
	private int SIZE = 26;
	private TrieNode root;
	
	Trie(){
		root = new TrieNode();
	}
	
	private class TrieNode{
		private int num;//有多少单词通过这个节点，即有根至该节点组成的字符串模式出现的次数
		private TrieNode[] son;//所有的儿子节点
		private boolean isEnd;//是不是最后一个节点
		private char val;//节点的值
		private boolean haveSon;
		
		TrieNode(){
			num=1;
			son=new TrieNode[SIZE];
			isEnd = false;
			haveSon = false;
			
		}
	}
	/**
	 * 插入逻辑：
	 * 1.判断数据是否为空 若是则返回
	 * 2.将字符串化成字符数组
	 * 3.遍历字符数组，* 查询node.son(子树)中是否包含对应的字符
	 * 包含则将该子树查询次数++，若不包含则在node子树中新增节点，并赋值，并将当前节点中haveSon置为true
	 * 并再往子树进行推进 在最后一个节点将node是不是叶子节点定义为true;
	 * @param str
	 */
	public void insert(String str) {
		if(str==null || str.length()==0) {
			return ;
		}
		TrieNode node=root;
		char[] letters = str.toCharArray();
		for(int i=0,len=str.length();i<len;i++) {
			int pos = letters[i]-'a';
			if(node.son[pos]==null)
			{
				node.haveSon=true;
				node.son[pos] = new TrieNode();
				node.son[pos].val = letters[i];
			}else {
				node.son[pos].num++;
			}
			node = node.son[pos];
		}
		node.isEnd = true;
	}
}
