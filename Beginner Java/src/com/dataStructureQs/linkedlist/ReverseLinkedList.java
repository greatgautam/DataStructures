package com.dataStructureQs.linkedlist;

public class ReverseLinkedList {

    public static <T> void  reverseList(SinglyLinkedList<T> list){
        // Step 1: Initialize a variable to store the pointer to New List
        SinglyLinkedList<T>.Node newList = null;
        SinglyLinkedList<T>.Node current = list.head;
        SinglyLinkedList<T>.Node next = null; // The list can be empty so, the next can be null

        // Step 2: Loop through list till current is not null
        while(current != null){
            // Since current is not null, we can call current.next (no NullPointerException)
            next = current.next; // Move next by one step.
            current.next = newList; // Point Current to new List
            newList = current; // Point new List to Current
            current = next; // Move current one step forward in original list
        }

        // Step 3: Assign the newList to original list
        list.head = newList;
    }

    public static void main(String[] args) {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        list.insertAtEnd("1");
        list.insertAtEnd("2");
        list.insertAtEnd("3");
        list.printList();

        System.out.println("List after Reversal");
        reverseList(list);
        list.printList();

    }
}
