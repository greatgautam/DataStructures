package com.dataStructureQs.linkedlist;

import java.util.HashSet;

public class RemoveDuplicatesInList {

    public static <T> void removeDuplicatesInList(SinglyLinkedList<T> list){

        // Step 1: Create a HashSet
        HashSet<T> visited = new HashSet<>();

        // Step 2: Create two pointers to store current and previous position
        SinglyLinkedList<T>.Node current = list.head;
        SinglyLinkedList<T>.Node previous = list.head;

        // Step 3: Move through LinkedList
        if ( !list.isEmpty() && current.next != null){
            // Loop till the end of the list
            while(current != null){
                // Step 4: If visited set contains the data then remove this node
                if (visited.contains(current.data)){
                    previous.next = current.next;
                    current = current.next;
                }else{ // Step 5: If visited does not contain data, then add to visited.
                    visited.add(current.data);
                    previous = current;
                    current = current.next;
                }
            }
        }

    }

    public static void main(String[] args) {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        list.insertAtEnd("1");
        list.insertAtEnd("6");
        list.insertAtEnd("2");
        list.insertAtEnd("3");
        list.insertAtEnd("2");
        list.printList();

        System.out.println("Removing Duplicates from the list.");
        removeDuplicatesInList(list);
        list.printList();
    }
}
