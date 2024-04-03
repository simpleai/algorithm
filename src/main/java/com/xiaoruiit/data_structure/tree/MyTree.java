package com.xiaoruiit.data_structure.tree;

/**
 * 二叉树
 */
public class MyTree {

    public TreeNode2 rootNode;

    public static TreeNode2 init() {
        TreeNode2 rootNode = new TreeNode2(4);
        TreeNode2 node1 = new TreeNode2(2);
        TreeNode2 node2 = new TreeNode2(1);
        TreeNode2 node3 = new TreeNode2(3);
        TreeNode2 node4 = new TreeNode2(6);
        TreeNode2 node5 = new TreeNode2(5);
        TreeNode2 node6 = new TreeNode2(7);
        rootNode.left = node1;
        rootNode.left.left = node2;
        rootNode.left.right = node3;
        rootNode.right = node4;
        rootNode.right.left = node5;
        rootNode.right.right = node6;
        return rootNode;
    }

    /**
     * 二叉树前序遍历 根左右
     */
    public static void frontTraverseTree(TreeNode2 root){
        if (root == null){
            return;
        }

        System.out.print(root.val +",");
        frontTraverseTree(root.left);
        frontTraverseTree(root.right);
    }



    /**
     * 二叉树中序遍历 左根右
     * 对于每一个节点，1.找他的左节点，2.打印他本身，3，找他的右节点
     * 结束条件 找到的节点为 null
     */
    public static void traverseTree(TreeNode2 rootNode) {
        if (rootNode == null) {
            return;
        }
        traverseTree(rootNode.left);
        System.out.print(rootNode.val +",");
        traverseTree(rootNode.right);
    }

    /**
     * 新增结点
     * <p>
     * 分析：
     * 二分查找，找到新节点应该处于的位置，把新节点作为叶节点插入。
     * 已存在时，返回false
     */
    public static boolean add(TreeNode2 root, TreeNode2 newNode) {
        if (root == null) {
            root = newNode;
            return true;
        }

        if (root.val > newNode.val) {
            if (root.left == null) {
                root.left = newNode;
                newNode.parentNode = root;
                return true;
            } else {
                return add(root.left, newNode);
            }
        } else if (root.val < newNode.val) {
            if (root.right == null) {
                root.right = newNode;
                newNode.parentNode = root;
                return true;
            } else {
                return add(root.right, newNode);
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
    public static boolean delete(TreeNode2 rootNode, int number) {
        if (rootNode == null) {
            return false;
        }

        if (rootNode.val > number) {
            return delete(rootNode.left, number);
        } else if (rootNode.val < number) {
            return delete(rootNode.right, number);
        } else {// 找到了节点
            if (rootNode.left == null && rootNode.right == null) {// 没有左右子树
                // 通过父节点将找到的节点删除
                TreeNode2 parentNode = rootNode.parentNode;
                if (parentNode.left == rootNode) {
                    parentNode.left = null;
                }
                if (parentNode.right == rootNode) {
                    parentNode.right = null;
                }
            } else if (rootNode.left == null && rootNode.right != null) {// 左子树为空
                // 当前节点的父节点指向当前节点的右子树
                TreeNode2 parentNode = rootNode.parentNode;
                if (parentNode.left == rootNode) {
                    parentNode.left = rootNode.right;
                }
                if (parentNode.right == rootNode) {
                    parentNode.right = rootNode.right;
                }
            } else if (rootNode.left != null && rootNode.right == null) {// 右子树为空
                // 当前节点的父节点指向当前节点的左子树
                TreeNode2 parentNode = rootNode.parentNode;
                if (parentNode.left == rootNode) {
                    parentNode.left = rootNode.left;
                }
                if (parentNode.right == rootNode) {
                    parentNode.right = rootNode.left;
                }
            } else {// 左右子树都不为空
                // 找前驱
                TreeNode2 precursorNode = rootNode.left;
                while (precursorNode.right != null){
                    precursorNode = precursorNode.right;
                }
                rootNode.val = precursorNode.val;// 修改数据
                return delete(precursorNode, precursorNode.val);// 删除前驱节点
            }
            return true;
        }
    }

        public static void main (String[]args){
            TreeNode2 root = new TreeNode2(4);
            MyTree tree = new MyTree();
            for (int i = 0; i < 10; i++) {
                tree.add(root, new TreeNode2(i));
            }

            System.out.println("前序遍历：");
            frontTraverseTree(root);
            System.out.println("前序遍历结束");

            // 删除
            TreeNode2 rootDelete = new TreeNode2(4);
            MyTree.add(rootDelete, new TreeNode2(2));
            MyTree.add(rootDelete, new TreeNode2(1));
            MyTree.add(rootDelete, new TreeNode2(0));
            MyTree.add(rootDelete, new TreeNode2(3));
            MyTree.add(rootDelete, new TreeNode2(5));
            MyTree.add(rootDelete, new TreeNode2(6));

            System.out.println("中序遍历未删除：");
            traverseTree(rootDelete);

            delete(rootDelete,2);

            System.out.println("中序遍历：");
            traverseTree(rootDelete);
        }

    }
