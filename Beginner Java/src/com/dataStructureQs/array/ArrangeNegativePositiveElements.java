package com.dataStructureQs.array;

public class ArrangeNegativePositiveElements {

    public static void arrangeNegativePositiveElements(int[] array){
        //Step 1: Initialize Counters and temp variable for swap
        int start = 0;
        int end = array.length-1;
        int temp = 0;

        //Step 2: Iterate over the array one element at a time
        // Swap negative element with positive element
        // If we keep getting negative number then keep moving to right
        // If we keep getting positive number then keep moving to left
        while (start < end){
            while(array[start] < 0 && start < end){
                start++;
            }
            while(array[end] >= 0 && start < end){
                end--;
            }
            temp = array[start];
            array[start] = array[end];
            array[end] = temp;
        }
    }

    public static void main(String[] args) {
        int[] array = {1,-2,2,3,-4};
        System.out.println("Array after arranging negative positive elements is : ");
        arrangeNegativePositiveElements(array);
        for (int i=0; i < array.length; i++){
            System.out.print(array[i]+" ");
        }
    }
}
