package com.smartershining;

import java.util.HashMap;

/**
 * Created by smartershining on 16-6-17.
 */

/**
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * <p>
 * Return a deep copy of the list.
 */
class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }
}

public class CopyRandomList {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode newHead = new RandomListNode(head.label);
        map.put(head, newHead);

        RandomListNode p = head.next;
        RandomListNode newp = newHead;


        while (p != null) {
            RandomListNode node = new RandomListNode(p.label);
            newp.next = node;
            map.put(p, node);
            p = p.next;
            newp = newp.next;
        }

        p = head;
        newp = newHead;

        while (p != null) {
            newp.random = map.get(p.random);
            newp = newp.next;
            p = p.next;
        }
        return newHead;
    }

    public RandomListNode copyRandomList2(RandomListNode head) {
        if (head == null) {
            return head;
        }
        RandomListNode node = head;
        while (node != null) {
            RandomListNode temp = new RandomListNode(node.label);
            temp.next = node.next;
            node.next = temp;
            node = temp.next;
        }
        node = head;
        while (node != null) {
            if (node.random != null)
                node.next.random = node.random.next;
            node = node.next.next;
        }

        node = head;
        RandomListNode newHead = head.next;
        RandomListNode newNode = newHead;

        while (node.next.next != null) {
            node.next = newNode.next;
            newNode.next = newNode.next.next;
            node = node.next;
            newNode = newNode.next;
        }

        node.next = null;
        return newHead;

    }
}
