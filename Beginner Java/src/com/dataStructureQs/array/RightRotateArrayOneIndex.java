package com.dataStructureQs.array;

public class RightRotateArrayOneIndex {

    public static int[] rightRotateArrayOne(int[] array){
        // Step 1: Store the last element in a variable
        int first = array[array.length-1];

        // Step 2: Keep moving from Right to left
        // Copy element from left to right
        for (int i = array.length-1; i > 0; i--){
            array[i] = array[i-1];
        }

        // Step 3: Copy the last element of array to the first position
        array[0] = first;
        return array;
    }
    public static void main(String[] args) {
        int[] array = {0,1,2,3,4};
        System.out.println("Array after rotation is : ");
        array = rightRotateArrayOne(array);
        for (int i=0; i < array.length; i++){
            System.out.print(array[i]+" ");
        }
    }
}
