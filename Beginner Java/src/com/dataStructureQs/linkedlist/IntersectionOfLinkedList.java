package com.dataStructureQs.linkedlist;

public class IntersectionOfLinkedList {

    public static <T> SinglyLinkedList<T>  intersectionOfLists(SinglyLinkedList<T> listA, SinglyLinkedList<T> listB){
        // Step 1: Create a new list for result
        SinglyLinkedList<T> resultList = new SinglyLinkedList<>();

        // Step 2: If any one of the list is empty then intersection is null
        if (listA.isEmpty() || listB.isEmpty()){
            return null;
        }

        // Step 3: Loop through one list and check if the element exists in other list
        SinglyLinkedList<T>.Node tempNode = listA.head;
        while(tempNode != null){
            if (contains(listB, tempNode)){
                resultList.insertAtEnd(tempNode.data);
            }
            tempNode = tempNode.next;
        }

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

        System.out.println("The intersection of two lists is = ");
        intersectionOfLists(listA, listB).printList();
    }
}
