package com.dataStructureQs.linkedlist;

public class NthElementFromEndInList {

    public static <T> Object nthElementFromEnd(SinglyLinkedList<T> list, int n){
        // Step 1: Get the size of list to check if list has n elements
        int size = list.size;
        int pointsToMove = size - n;

        // Step 2: Check if List is empty or there are not enough elements
        if (size ==0 || pointsToMove < 0 ){
            return null;
        }
        // Step 3: Start moving the list for pointsToMove
        SinglyLinkedList.Node currPointer = list.head;
        int count = 0;

        // Step 4: Loop through the list and move currPointer
        while(currPointer != null ){
            if (count == pointsToMove){
                return currPointer.data;
            }
            count++; // Increment the count
            currPointer = currPointer.next;
        }

        return null;
    }
    public static void main(String[] args) {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        list.insertAtEnd("1");
        list.insertAtEnd("4");
        list.insertAtEnd("5");
        list.insertAtEnd("7");
        list.insertAtEnd("9");
        list.printList();

        int n = 3;
        System.out.println("The "+n+" from end in this list is = "+nthElementFromEnd(list, n));
    }
}
