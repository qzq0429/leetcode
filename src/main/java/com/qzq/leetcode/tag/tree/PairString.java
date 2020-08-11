package com.qzq.leetcode.tag.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PairString {
	
	
//	public static void main(String[] args) {
//		palindromePairs(new String[] {
//				"a","abc","aba",""});
//	}
//	public static List<List<Integer>> palindromePairs(String[] words) {
//		
//		int size = words.length;
//		List<List<Integer>> a = new ArrayList<List<Integer>>();
//		if(size==0) {
//			return a;
//		}
//		Map<Integer, List<Integer>> map = new HashMap();
//		for (int i = 0; i < size; i++) {
//			String key = words[i];
//			List<Integer> list = new ArrayList();
//			for (int j = 0; j < size; j++) {
//				if (j == i) {
//					continue;
//				}
//				list.add(j);
//			}
//			map.put(i, list);
//		}
//		
//		map.keySet().stream().forEach(e -> {
//			List<Integer> comList = map.get(e);
//
//			comList.forEach(k -> {
//				List<Integer> list = new ArrayList();
//				String tmp = words[e] + words[k];
//				Integer tmpSize = tmp.length();
//				if(tmpSize==1) {
//				list.add(e);
//				list.add(k); 
//				a.add(list);
//				return;
//				}
//				if(tmpSize%2==0)
//				{
//					String s =tmp.substring(0, tmpSize / 2);
//					String s2 = tmp.substring(tmpSize / 2);
//					StringBuffer sb = new StringBuffer(s2);
//					String res = sb.reverse().toString();
//					if ( s.equals( res)) {
//						list.add(e);
//						list.add(k);
//						a.add(list);
//					}
//					return;
//				}else {
//					String s =tmp.substring(0, tmpSize / 2);
//					String s2 = tmp.substring(tmpSize / 2+1);
//					StringBuffer sb = new StringBuffer(s2);
//					String res = sb.reverse().toString();
//					if ( s.equals( res)) {
//						list.add(e);
//						list.add(k);
//						a.add(list);
//					}
//					return;
//				}
//
//
//
//			});
//
//
//
//		});
//
//		return a;
//
//	}

}
