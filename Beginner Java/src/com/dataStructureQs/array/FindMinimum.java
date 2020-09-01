package com.dataStructureQs.array;

public class FindMinimum {

    public static int findMinimum(int[] array1){
        // Step 1: Create a temp variable to store minimum
        int min = array1[0];

        // Step 2: Loop through array to compare each element
        // and find the minimum
        for(int i =0; i < array1.length; i++){
            if (array1[i] < min){
                min = array1[i];
            }
        }

        return min;
    }

    public static void main(String[] args) {
        int[] array1 = {10,2,5,9,0};
        int min = findMinimum(array1);
        System.out.println("Minimum is = "+min);
    }
}
