package com.nextyu.codinginterviews._006_从尾到头打印链表;

import java.util.Stack;

/**
 * 2018-03-16 10:21
 *
 * @author nextyu
 */
public class MyTest006 {
    private static class ListNode<E> {
        E item;
        ListNode<E> next;

        public ListNode(E item, ListNode<E> next) {
            this.item = item;
            this.next = next;
        }
    }

    public static void print(ListNode root) {
        if (null == root) {
            return;
        }
        ListNode temp = root;
        while (temp != null) {
            System.out.println(temp.item);
            temp = temp.next;
        }

    }

    /**
     * 从尾到头打印，意思就是："后进先出"，可以使用栈数据预先保存数据，再循环打印出来
     *
     * @param root
     */
    public static void printReverse(ListNode root) {
        if (null == root) {
            return;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = root;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }

        while (!stack.isEmpty()) {
            ListNode pop = stack.pop();
            System.out.println(pop.item);
        }

    }


    public static void main(String[] args) {
        ListNode<Integer> node3 = new ListNode<>(3, null);
        ListNode<Integer> node2 = new ListNode<>(2, node3);
        ListNode<Integer> node1 = new ListNode<>(1, node2);
        ListNode<Integer> node0 = new ListNode<>(0, node1);

        print(node0);
        printReverse(node0);
    }
}
