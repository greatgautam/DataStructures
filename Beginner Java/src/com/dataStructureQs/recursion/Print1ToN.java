package com.dataStructureQs.recursion;

public class Print1ToN {

    public static void main(String[] args) {
        int n = 10;
        printRec(n);
    }

    public static void printRec(int n) {
        if (n ==1){
            System.out.println("1");
            return;
        }
        printRec(n-1);
        System.out.println(n);
    }
}
