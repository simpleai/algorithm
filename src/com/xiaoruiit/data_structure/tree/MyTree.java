package com.xiaoruiit.data_structure.tree;

import sun.reflect.generics.tree.Tree;

/**
 * 二叉树
 */
public class MyTree {

    public TreeNode rootNode;

    public static TreeNode init() {
        TreeNode rootNode = new TreeNode(4);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(6);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(7);
        rootNode.leftNode = node1;
        rootNode.leftNode.leftNode = node2;
        rootNode.leftNode.rightNode = node3;
        rootNode.rightNode = node4;
        rootNode.rightNode.leftNode = node5;
        rootNode.rightNode.rightNode = node6;
        return rootNode;
    }

    /**
     * 二叉树中序遍历 左根右
     * 对于每一个节点，1.找他的左节点，2.打印他本身，3，找他的右节点
     * 结束条件 找到的节点为 null
     */
    public static void traverseTree(TreeNode rootNode) {
        if (rootNode == null) {
            return;
        }
        traverseTree(rootNode.leftNode);
        System.out.println(rootNode.data);
        traverseTree(rootNode.rightNode);
    }

    /**
     * 新增结点
     * <p>
     * 分析：
     * 二分查找，找到新节点应该处于的位置，把新节点作为叶节点插入。
     * 已存在时，返回false
     */
    public static boolean add(TreeNode root, TreeNode newNode) {
        if (root == null) {
            root = newNode;
            return true;
        }

        if (root.data > newNode.data) {
            if (root.leftNode == null) {
                root.leftNode = newNode;
                newNode.parentNode = root;
                return true;
            } else {
                return add(root.leftNode, newNode);
            }
        } else if (root.data < newNode.data) {
            if (root.rightNode == null) {
                root.rightNode = newNode;
                newNode.parentNode = root;
                return true;
            } else {
                return add(root.rightNode, newNode);
            }
        } else {// 数据已存在
            return false;
        }
    }


    /**
     * 删除结点
     * 分析：删除的四种情况
     *      1.要删除的节点是叶子节点
     *      2.要删除的节点只有左子树
     *      3.要删除的节点只用右子树
     *      4.要删除的节点有左子树和右子树，有两种办法
     *           第一种，找到此节点的前驱节点，放到此节点上
     *           第二种，找到此节点的后驱节点，放到此节点上
     */
    public static boolean delete(TreeNode rootNode, int number) {
        if (rootNode == null) {
            return false;
        }

        if (rootNode.data > number) {
            return delete(rootNode.leftNode, number);
        } else if (rootNode.data < number) {
            return delete(rootNode.rightNode, number);
        } else {// 找到了节点
            if (rootNode.leftNode == null && rootNode.rightNode == null) {// 没有左右子树
                // 通过父节点将找到的节点删除
                TreeNode parentNode = rootNode.parentNode;
                if (parentNode.leftNode == rootNode) {
                    parentNode.leftNode = null;
                }
                if (parentNode.rightNode == rootNode) {
                    parentNode.rightNode = null;
                }
            } else if (rootNode.leftNode == null && rootNode.rightNode != null) {// 左子树为空
                // 当前节点的父节点指向当前节点的右子树
                TreeNode parentNode = rootNode.parentNode;
                if (parentNode.leftNode == rootNode) {
                    parentNode.leftNode = rootNode.rightNode;
                }
                if (parentNode.rightNode == rootNode) {
                    parentNode.rightNode = rootNode.rightNode;
                }
            } else if (rootNode.leftNode != null && rootNode.rightNode == null) {// 右子树为空
                // 当前节点的父节点指向当前节点的左子树
                TreeNode parentNode = rootNode.parentNode;
                if (parentNode.leftNode == rootNode) {
                    parentNode.leftNode = rootNode.leftNode;
                }
                if (parentNode.rightNode == rootNode) {
                    parentNode.rightNode = rootNode.leftNode;
                }
            } else {// 左右子树都不为空
                // 找前驱
                TreeNode precursorNode = rootNode.leftNode;
                while (precursorNode.rightNode != null){
                    precursorNode = precursorNode.rightNode;
                }
                rootNode.data = precursorNode.data;// 修改数据
                return delete(precursorNode, precursorNode.data);// 删除前驱节点
            }
            return true;
        }
    }

        public static void main (String[]args){
            TreeNode root = new TreeNode(4);
            MyTree tree = new MyTree();
            for (int i = 0; i < 10; i++) {
                tree.add(root, new TreeNode(i));
            }
            System.out.println(tree.rootNode);
            // 删除
            TreeNode rootDelete = new TreeNode(4);
            MyTree.add(rootDelete, new TreeNode(2));
            MyTree.add(rootDelete, new TreeNode(1));
            MyTree.add(rootDelete, new TreeNode(0));
            MyTree.add(rootDelete, new TreeNode(3));
            MyTree.add(rootDelete, new TreeNode(5));
            MyTree.add(rootDelete, new TreeNode(6));
            delete(rootDelete,2);
            System.out.println();
        }

    }
