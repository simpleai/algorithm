package com.xiaoruiit.data_structure.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author hxr
 * @Classname TireNode
 * @Description 前缀树结点定义
 */
public class TrieNode {


    boolean isEnd;
    HashMap<Character, TrieNode> children;

    TrieNode() {
        isEnd = false;
        children = new HashMap<>();
    }

}
