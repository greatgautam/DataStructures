package com.dataStructureQs.linkedlist;

public class FindMiddleOfList {

    public static <T> Object findMiddleElement(SinglyLinkedList<T> list){

        // Step 1: Define two pointers: Slow and Fast
        SinglyLinkedList.Node slowPointer = list.head;
        SinglyLinkedList.Node fastPointer = list.head;

        // Step 2: Move through LinkedList, fast pointer moves two steps,
        // slow pointer moves one step
        while(slowPointer != null && fastPointer != null && fastPointer.next != null){
            // Fast pointer makes two jumps
            fastPointer = fastPointer.next.next;
            // If Fast Pointer has not reached till the end
            if (fastPointer != null){
                slowPointer = slowPointer.next;
            }
        }

        return slowPointer.data;
    }

    public static void main(String[] args) {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        list.insertAtEnd("1");
        list.insertAtEnd("6");
        list.insertAtEnd("2");
        list.insertAtEnd("3");
        list.printList();

        System.out.println("Middle Point of the list is = "+findMiddleElement(list));
    }
}
