package com.dataStructureQs.linkedlist;

public class DetectLoopInList {

    public static <T> boolean detectLoop(SinglyLinkedList<T> list){
        // Step 1: Define two pointers. Slow and Fast
        SinglyLinkedList.Node slowPointer = list.head;
        SinglyLinkedList.Node fastPointer = list.head;

        // Step 2: Loop through every node of the LinkedList
        // Move two steps for fast pointer and one step for slowpointer
        while(slowPointer != null && fastPointer != null && fastPointer.next != null){
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
            // Step 3: If Slow pointer meets fast pointer, then there is a loop
            if (slowPointer == fastPointer){
                return true;
            }
        }

        return false;
    }
    public static void main(String[] args) {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        list.insertAtEnd("1");
        list.insertAtEnd("6");
        list.insertAtEnd("2");
        list.insertAtEnd("3");
        list.printList();

        System.out.println("There is a loop in this list = "+detectLoop(list));

        System.out.println("Creating loop in the list.");
        list.head.next.next.next = list.head.next;
        System.out.println("There is a loop in this list = "+detectLoop(list));
    }
}
