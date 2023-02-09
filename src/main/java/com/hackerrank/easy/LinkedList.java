package com.hackerrank.easy;

import java.util.HashMap;

public class LinkedList {
    // THINK OF THE EDGE CASES BEFORE WRITING ANYTHING
    // SOME OF THEM LOOKS EASY

      static boolean hasCycle(SinglyLinkedListNode head) {
        HashMap<SinglyLinkedListNode, Integer> counter = new HashMap<>();
        SinglyLinkedListNode node = head;
        while (node.next != null) {
            Integer count = counter.getOrDefault(node, 0);
            if (count > 1) {
                return true;
            }
            counter.put(node, count + 1);
            node = node.next;
        }
        return false;
    }

    public static DoublyLinkedListNode reverse(DoublyLinkedListNode llist) {
        if (llist.next == null) {
            llist.next = llist.prev;
            llist.prev = null;
            return llist;
        }
        DoublyLinkedListNode doublyLinkedListNode = reverse(llist.next);
        DoublyLinkedListNode temp = llist.next;
        llist.next = llist.prev;
        llist.prev = temp;
        return doublyLinkedListNode;

    }

    public static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode llist, int data) {
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
        // in case the head is null;
        if (llist == null) {
            return newNode;
        }
        // in case the newNode is the new head
        if (data < llist.data) {
            newNode.next = llist;
            return newNode;
        }
        DoublyLinkedListNode node = llist;
        while (node != null) {
            if (node.data < data && (node.next == null || node.next.data >= data)) {
                newNode.next = node.next;
                node.next = newNode;
                break;
            }
            node = node.next;
        }
        return llist;
    }

    public static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode node1 = head1;
        while (node1 != null) {
            SinglyLinkedListNode node2 = head2;
            while (node2 != null) {
                if (node1 == node2) {
                    return node1.data;
                }
                node2 = node2.next;
            }
            node1 = node1.next;
        }
        return 0;
    }

    public static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode llist) {
        if (llist.next == null) {
            return llist;
        }
        SinglyLinkedListNode nextNode = removeDuplicates(llist.next);
        if (nextNode.data == llist.data) {
            llist.next = nextNode.next;
        }
        return llist;
    }

    public static int getNode(SinglyLinkedListNode head, int positionFromTail) {
        SinglyLinkedListNode node = head;
        int size = 0;
        while (node.next != null) {
            size++;
            node = node.next;
        }
        node = head;
        int positionFromHead = size - positionFromTail;
        while (node.next != null && positionFromHead-- > 0) {
            node = node.next;
        }
        return node.data;
    }

    public static SinglyLinkedListNode mergeLists1(SinglyLinkedListNode nodeA, SinglyLinkedListNode nodeB) {
        if (nodeA != null && nodeB != null) {
            if (nodeA.data < nodeB.data) {
                nodeA.next = mergeLists1(nodeA.next, nodeB);
                return nodeA;
            } else {
                nodeB.next = mergeLists1(nodeA, nodeB.next);
                return nodeB;
            }
        }
        return nodeA == null ? nodeB : nodeA;
    }

    public static SinglyLinkedListNode mergeLists2(SinglyLinkedListNode headA, SinglyLinkedListNode headB) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        SinglyLinkedListNode currentA = headA, currentB = headB;
        while (currentA != null && currentB != null) {
            if (currentA.data < currentB.data) {
                singlyLinkedList.insertNode(currentA.data);
                currentA = currentA.next;
            } else {
                singlyLinkedList.insertNode(currentB.data);
                currentB = currentB.next;
            }

        }
        while (currentA != null) {
            singlyLinkedList.insertNode(currentA.data);
            currentA = currentA.next;
        }
        while (currentB != null) {
            singlyLinkedList.insertNode(currentB.data);
            currentB = currentB.next;
        }
        return singlyLinkedList.head;
    }

    static boolean compareLists(SinglyLinkedListNode node, SinglyLinkedListNode node2) {
        if (node.next == null && node2.next == null) {
            return node.data == node2.data;
        } else if (node.next != null && node2.next != null) {
            return compareLists(node.next, node2.next) && node.data == node2.data;
        } else {
            return false;
        }
    }

    public static SinglyLinkedListNode reverse(SinglyLinkedListNode node) {
        if (node.next == null) {
            return node;
        } else {
            SinglyLinkedListNode reverse = reverse(node.next);
            node.next.next = node;
            node.next = null;
            return reverse;
        }
    }

    public static void reversePrint(SinglyLinkedListNode llist) {
        if (llist.next != null) {
            reversePrint(llist.next);
        }
        System.out.println(llist.data);
    }

    public static SinglyLinkedListNode deleteNode(SinglyLinkedListNode llist, int position) {
        if (llist == null) return null;
        if (position == 0) return llist.next;
        deleteNodeRecursive(llist, position, 1);
        return llist;
    }

    public static void deleteNodeRecursive(SinglyLinkedListNode currentNode, int position, int current) {
        if (currentNode != null) {
            if (current == position) {
                currentNode.next = currentNode.next.next;
            } else {
                deleteNodeRecursive(currentNode.next, position, current + 1);
            }
        }
    }

    public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position) {
        insertNodeAtPosition(llist, data, position, 1);
        return llist;
    }

    public static void insertNodeAtPosition(SinglyLinkedListNode currentNode, int data, int position, int current) {
        if (current == position) {
            SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
            newNode.next = currentNode.next;
            currentNode.next = newNode;
        } else {
            insertNodeAtPosition(currentNode.next, data, position, current + 1);
        }
    }

    /**
     * Insert node at the head of linked list
     */
    public static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode head, int data) {
        SinglyLinkedListNode insertedNode = new SinglyLinkedListNode(data);
        if (head == null) {
            return insertedNode;
        }
        insertedNode.next = head;
        return insertedNode;
    }


    /**
     * Insert node at the tail of linked list
     */
    public static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
        if (head == null) {
            return new SinglyLinkedListNode(data);
        }
        insertNodeAtTailRecursive(head, data);
        return head;
    }

    public static void insertNodeAtTailRecursive(SinglyLinkedListNode node, int data) {
        if (node.next == null) {
            node.next = new SinglyLinkedListNode(data);
        } else {
            insertNodeAtTailRecursive(node.next, data);
        }
    }

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    public static void printLinkedList(SinglyLinkedListNode head) {
        System.out.println(head.data);
        if (head.next != null) {
            printLinkedList(head.next);
        }
    }

    public static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }

        @Override
        public String toString() {
            return String.format("{\"data\":%s}", data);
        }
    }

    public static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);
            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    static class DoublyLinkedList {
        public DoublyLinkedListNode head;
        public DoublyLinkedListNode tail;

        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
                node.prev = this.tail;
            }

            this.tail = node;
        }
    }

    static class DoublyLinkedListNode {
        public int data;
        public DoublyLinkedListNode next;
        public DoublyLinkedListNode prev;

        public DoublyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
            this.prev = null;
        }

        @Override
        public String toString() {
            return String.format("{\"data\":%s}", data);
        }
    }
}
