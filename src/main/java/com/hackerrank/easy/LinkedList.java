package com.hackerrank.easy;

public class LinkedList {
    public static void main(String[] args) {
        SinglyLinkedList llist1 = new SinglyLinkedList();
        llist1.insertNode(1);
        llist1.insertNode(3);
        llist1.insertNode(5);

        SinglyLinkedList llist2 = new SinglyLinkedList();
        llist2.insertNode(2);//0
        llist2.insertNode(4);//1
        llist2.insertNode(6);//2
        llist2.insertNode(7);//3

        int data = getNode(llist2.head, 4);
        System.out.println(">>>>>>>" + data);
        //printLinkedList(singlyLinkedListNode);

        // 1 -> 2 -> 3 -> 4 -> 5


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
}
