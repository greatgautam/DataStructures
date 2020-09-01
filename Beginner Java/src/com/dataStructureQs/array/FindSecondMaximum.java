package com.dataStructureQs.array;

public class FindSecondMaximum {
    public static int findSecondMaximumElement(int[] array){
        // Step 1: Initialize two variables to store max and second max
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for(int i = 0; i < array.length; i++){
            if (array[i] > max){
                secondMax = max;
                max = array[i];
            }
            if (array[i] > secondMax & array[i] != max){
                secondMax = array[i];
            }
        }

        return secondMax;
    }

    public static void main(String[] args) {
        int[] array = {0,1,2,3};
        System.out.println("Second max element is = "+findSecondMaximumElement(array));
    }
}
