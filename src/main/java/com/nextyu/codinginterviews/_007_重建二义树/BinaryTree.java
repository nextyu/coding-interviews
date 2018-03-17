package com.nextyu.codinginterviews._007_重建二义树;

import cn.hutool.core.collection.CollUtil;

import java.util.*;

public class BinaryTree {
    private static class BinaryTreeNode {
        int item;
        BinaryTreeNode left;
        BinaryTreeNode right;

        public BinaryTreeNode(int item, BinaryTreeNode left, BinaryTreeNode right) {
            this.item = item;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode _4 = new BinaryTreeNode(4, null, null);
        BinaryTreeNode _8 = new BinaryTreeNode(8, null, null);
        BinaryTreeNode _12 = new BinaryTreeNode(12, null, null);
        BinaryTreeNode _16 = new BinaryTreeNode(16, null, null);
        BinaryTreeNode _6 = new BinaryTreeNode(6, _4, _8);
        BinaryTreeNode _14 = new BinaryTreeNode(14, _12, _16);
        BinaryTreeNode root = new BinaryTreeNode(10, _6, _14);

        preOrderTraversalRecursion(root);
        System.out.println();
        preOrderTraversal(root);
        System.out.println();
        inOrderTraversalRecursion(root);
        System.out.println();
        inOrderTraversal(root);
        System.out.println();
        postOrderTraversalRecursion(root);
        System.out.println();
        postOrderTraversal(root);
        System.out.println();
        levelOrder(root);

    }

    private static void visit(BinaryTreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.item + " ");
    }

    /**
     * 前序（先序）遍历：先访问根节点，再访问左子结点，最后访问右子节点
     *
     * @param root
     */
    public static void preOrderTraversalRecursion(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        visit(root); // 访问根节点
        preOrderTraversalRecursion(root.left); // 访问左子结点
        preOrderTraversalRecursion(root.right); // 访问右子节点
    }

    /**
     * 非递归前序遍历
     *
     * @param root
     */
    public static void preOrderTraversal(BinaryTreeNode root) {
        if (root == null) {
            return;
        }

        Deque<BinaryTreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            BinaryTreeNode node = stack.pop();
            if (node != null) {
                visit(node);
                if (node.right != null) {
                    stack.push(node.right); // 入栈右子节点
                }
                if (node.left != null) {
                    stack.push(node.left); // 入栈左子节点
                }
            }
        }
    }

    /**
     * 中序遍历：先访问左子结点，再访问根节点，最后访问右子节点
     *
     * @param root
     */
    public static void inOrderTraversalRecursion(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraversalRecursion(root.left); // 访问左子结点
        visit(root); // 访问根节点
        inOrderTraversalRecursion(root.right); // 访问右子节点
    }


    /**
     * 非递归中序遍历
     *
     * @param root
     */
    public static void inOrderTraversal(BinaryTreeNode root) {
        if (root == null) {
            return;
        }

        Deque<BinaryTreeNode> stack = new LinkedList<>();
        BinaryTreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            visit(cur);
            cur = cur.right;
        }

    }

    /**
     * 后序遍历：先访问左子结点，再访问右子节点，最后访问根节点
     *
     * @param root
     */
    public static void postOrderTraversalRecursion(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        postOrderTraversalRecursion(root.left); // 访问左子结点
        postOrderTraversalRecursion(root.right); // 访问右子节点
        visit(root); // 访问根节点
    }

    /**
     * 非递归后序遍历
     * <p>
     * 先采用类似先序遍历（先遍历根结点再右子结点最后左子节点），最后把遍历的序列逆转即得到了后序遍历
     *
     * @param root
     */
    public static void postOrderTraversal(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        List<Integer> list = new ArrayList<>();
        Deque<BinaryTreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            BinaryTreeNode node = stack.pop();
            if (node != null) {
                list.add(node.item);
                if (node.left != null) {
                    stack.push(node.left); // 入栈左子节点
                }
                if (node.right != null) {
                    stack.push(node.right); // 入栈右子节点
                }
            }
        }

        List<Integer> reverse = CollUtil.reverse(list);
        System.out.println(reverse);
    }

    /**
     * 层序遍历（宽度优先遍历）
     * 一层一层遍历
     *
     * @param root
     */
    public static void levelOrder(BinaryTreeNode root) {
        if (root == null) {
            return;
        }

        List<List<Integer>> results = CollUtil.newArrayList();
        Queue<BinaryTreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (CollUtil.isNotEmpty(queue)) {
            List<Integer> result = CollUtil.newArrayList();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                BinaryTreeNode node = queue.poll();
                if (node != null) {
                    result.add(node.item);
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
            }

            results.add(result);
        }

        System.out.println(results);
    }


}
