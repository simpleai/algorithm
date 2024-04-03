package com.xiaoruiit.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author hxr
 * @Classname TireNode
 * @Description 前缀树结点定义
 */
public class TrieNode {

    public int index;
    public List<Integer> palindromes;// 记录从该节点往下的能构成回文的所有输入字符串的下标
    public HashMap<Character, TrieNode> children;

    public TrieNode(){
        index = -1;
        children = new HashMap<>();
        palindromes = new ArrayList<>();
    }

}
