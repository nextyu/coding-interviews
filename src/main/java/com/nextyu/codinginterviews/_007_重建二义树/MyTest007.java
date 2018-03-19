package com.nextyu.codinginterviews._007_重建二义树;

public class MyTest007 {
    private static class BinaryTreeNode {
        int item;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
//        test7();

    }

    // 普通二叉树
    //              1
    //           /     \
    //          2       3
    //         /       / \
    //        4       5   6
    //         \         /
    //          7       8
    public static void test1() {
        int[] preOrder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inOrder = {4, 7, 2, 1, 5, 3, 8, 6};
        print(preOrder, inOrder);
    }

    // 所有结点都没有右子结点
    //            1
    //           /
    //          2
    //         /
    //        3
    //       /
    //      4
    //     /
    //    5
    public static void test2() {
        int[] preOrder = {1, 2, 3, 4, 5};
        int[] inOrder = {5, 4, 3, 2, 1};
        print(preOrder, inOrder);
    }

    // 所有结点都没有左子结点
    //            1
    //             \
    //              2
    //               \
    //                3
    //                 \
    //                  4
    //                   \
    //                    5
    public static void test3() {
        int[] preOrder = {1, 2, 3, 4, 5};
        int[] inOrder = {1, 2, 3, 4, 5};
        print(preOrder, inOrder);
    }

    // 树中只有一个结点
    public static void test4() {
        int[] preOrder = {1};
        int[] inOrder = {1};
        print(preOrder, inOrder);
    }

    // 完全二叉树
    //              1
    //           /     \
    //          2       3
    //         / \     / \
    //        4   5   6   7
    public static void test5() {
        int[] preOrder = {1, 2, 4, 5, 3, 6, 7};
        int[] inOrder = {4, 2, 5, 1, 6, 3, 7};
        print(preOrder, inOrder);
    }

    // 输入空指针
    public static void test6() {
        print(null, null);
    }

    // 输入的两个序列不匹配
    public static void test7() {
        int[] preOrder = {1, 2, 4, 5, 3, 6, 7};
        int[] inOrder = {4, 2, 8, 1, 6, 3, 7};
        print(preOrder, inOrder);
    }


    public static void print(int[] preOrder, int[] inOrder) {
        BinaryTreeNode root = construct(preOrder, inOrder);
        preOrderTraversalRecursion(root);
        System.out.println();
        inOrderTraversalRecursion(root);
        System.out.println();
        System.out.println("------------------------------------------------");
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
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二节树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字
     *
     * @param preOrder 前序遍历
     * @param inOrder  中序遍历
     * @return 树的根结点
     */
    public static BinaryTreeNode construct(int[] preOrder, int[] inOrder) {
        // 输入的合法性判断，两个数组都不能为空，并且都有数据，而且数据的数目相同
        if (preOrder == null || inOrder == null || preOrder.length != inOrder.length || preOrder.length < 1) {
            return null;
        }
        return construct(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);
    }

    /**
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二节树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字
     *
     * @param preOrder 前序遍历
     * @param pStart   前序遍历的开始位置
     * @param pEnd     前序遍历的结束位置
     * @param inOrder  中序遍历
     * @param iStart   中序遍历的开始位置
     * @param iEnd     中序遍历的结束位置
     * @return 树的根结点
     */
    private static BinaryTreeNode construct(int[] preOrder, int pStart, int pEnd, int[] inOrder, int iStart, int iEnd) {
        // 开始位置大于结束位置说明已经没有需要处理的元素了
        if (pStart > pEnd) {
            return null;
        }

        // 取前序遍历的第一个数字，就是当前的根结点
        int value = preOrder[pStart];
        int index = iStart;

        // 在中序遍历的数组中找根结点的位置
        while (index <= iEnd && inOrder[index] != value) {
            index++;
        }

        // 如果在整个中序遍历的数组中没有找到，说明输入的参数是不合法的，抛出异常
        if (index > iEnd) {
            throw new RuntimeException("invalid input");
        }

        // 创建当前的根结点，并且为结点赋值
        BinaryTreeNode node = new BinaryTreeNode();
        node.item = value;

        // 递归构建当前根结点的左子树，左子树的元素个数：index-is+1个
        // 左子树对应的前序遍历的位置在[ps+1, ps+index-is]
        // 左子树对应的中序遍历的位置在[is, index-1]
        node.left = construct(preOrder, pStart + 1, pStart + index - iStart, inOrder, iStart, index - 1);

        // 递归构建当前根结点的右子树，右子树的元素个数：ie-index个
        // 右子树对应的前序遍历的位置在[ps+index-is+1, pe]
        // 右子树对应的中序遍历的位置在[index+1, ie]
        node.right = construct(preOrder, pStart + index - iStart + 1, pEnd, inOrder, index + 1, iEnd);

        // 返回创建的根结点
        return node;
    }
}
