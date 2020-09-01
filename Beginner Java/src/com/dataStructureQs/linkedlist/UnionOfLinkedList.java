package com.dataStructureQs.linkedlist;

import java.util.HashSet;

public class UnionOfLinkedList {

    public static <T> SinglyLinkedList<T>  unionOfLists(SinglyLinkedList<T> listA, SinglyLinkedList<T> listB){
        // Step 1: Create a new list for result
        SinglyLinkedList<T> resultList = new SinglyLinkedList<>();

        // Step 2: If any one of the list is empty then union is other list
        if (listA.isEmpty() ){
            return listB;
        }
        if (listB.isEmpty() ){
            return listA;
        }

        // Step 3: Loop through one list to reach the end of this list
        SinglyLinkedList<T>.Node tempNode = listA.head;
        while(tempNode.next != null){
            resultList.insertAtEnd(tempNode.data);
            tempNode = tempNode.next;
        }

        // Step 4: Append the next list to the end
        tempNode = listB.head;
        while(tempNode != null){
            resultList.insertAtEnd(tempNode.data);
            tempNode = tempNode.next;
        }

        // Step 5: Create the result list by removing duplicates from this list
        removeDuplicatesInList(resultList);

        return resultList;
    }

    public static <T> boolean contains(SinglyLinkedList<T> list, SinglyLinkedList<T>.Node node){
        SinglyLinkedList<T>.Node curr = list.head;
        while(curr != null){
            if (curr.data.equals(node.data)){
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

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
        SinglyLinkedList<String> listA = new SinglyLinkedList<>();
        listA.insertAtEnd("1");
        listA.insertAtEnd("2");
        listA.insertAtEnd("3");
        listA.insertAtEnd("4");
        listA.printList();

        SinglyLinkedList<String> listB = new SinglyLinkedList<>();
        listB.insertAtEnd("2");
        listB.insertAtEnd("1");
        listB.insertAtEnd("5");
        listB.printList();

        System.out.println("The union of two lists is = ");
        unionOfLists(listA, listB).printList();
    }
}
