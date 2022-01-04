package com.xiaoruiit.data_structure.tree;

/**
 * 字典树
 */
public class TrieTree {


    /**
     * 添加
     */
    public static void add(TrieNode root, String word){
        if (root == null || word == null || word.length() == 0){
            return;
        }

        char[] chars = word.toCharArray();
        for (int i = 0; i < word.length() ; i++){
            char ch = chars[i];
            if (!root.children.containsKey(ch)){// 对于每个当前字符，如果还没有被添加到children哈希表中，创建一个新结点，放入children哈希表中
                root.children.put(ch, new TrieNode());
            }
            root = root.children.get(ch);
        }

        root.isEnd = true;// 单词结束，设置结束标记
    }

    /**
     * 查找
     */
    public static boolean search(TrieNode root, String word){
        if (root == null || word == null || word.length() == 0){
            return false;
        }

        char[] wordChars = word.toCharArray();
        for (int i = 0; i < wordChars.length; i++) {
            TrieNode trieNode = root.children.get(wordChars[i]);
            if (trieNode == null){
                return false;
            } else {
                root = trieNode;
            }
        }
        if (root.isEnd){
            return true;
        }

        return false;
    }


    public static void main(String[] args) {
        TrieNode root = new TrieNode();
        TrieTree.add(root,"ab");
        TrieTree.add(root,"abc");
        TrieTree.add(root,"abd");
        TrieTree.add(root,"bcd");
        System.out.println(root);

        System.out.println(TrieTree.search(root, "bc"));
        System.out.println(TrieTree.search(root, "bcd"));
        System.out.println(TrieTree.search(root, "bcde"));
    }
}
