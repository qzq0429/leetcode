package com.qzq.leetcode.tag.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TreeIterator {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null){
            return new ArrayList<List<Integer>>();
        }

    Map<Integer,List<Integer>> map =  new HashMap<Integer,List<Integer>>();
    insertRoot(root,map,0);
    List<List<Integer>> allList = map.values().stream().collect(Collectors.toList());
    return allList;
    }

    public void insertRoot(TreeNode root,Map<Integer,List<Integer>> map,int height){
        if(root==null) return;

        List<Integer> list = map.get(height);
        if(list == null){
            list = new ArrayList<Integer>();
        }
        list.add(root.val);
        map.put(height,list);
        if(root.left!=null){
            insertRoot(root.left,map,height+1);
        }
        if(root.right!=null){
            insertRoot(root.right,map,height+1);
        }


    }
}
