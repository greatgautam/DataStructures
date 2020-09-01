package com.dataStructureQs.linkedlist;

public class SinglyLinkedList<T> {

    public class Node {
        public T data; // Data to be stored in a Node
        public Node next; // Pointer to the next node
    }
    public Node head; // Head of the list
    public int size; // Size of the list

    // Constructor to create SinglyLinkedList
    public SinglyLinkedList(){
        head =null;
        size =0;
    }

    // IsEmpty method returns true if the list has 0 elements
    public boolean isEmpty(){
        if (size == 0){
            return true;
        }
        return false;
    }

    public void insertAtEnd(T data){
        // If List is empty then insert at the head
        if (isEmpty()){
            insertAtHead(data);
            return;
        }
        // If list is not empty then insert the element at the end

        Node node = new Node();
        node.data = data;
        node.next = null;
        Node currentNode = head;
        while(currentNode.next !=null){
            currentNode = currentNode.next;
        }
        currentNode.next = node;
        size++;
    }

    public void insertAtHead(T data){
        Node node = new Node();
        node.data = data;
        node.next = head;
        head = node;
        size++;
    }

    public void printList(){
        Node current = head;
        while(current != null){
            System.out.print(current.data+ " ");
            current = current.next;
        }
        System.out.println("");
    }
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.insertAtEnd(1);
        list.printList();

        list.insertAtEnd(2);
        list.printList();

    }

}
