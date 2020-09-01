package com.dataStructureQs.array;

import java.util.HashMap;

public class FindTwoNumberSumN {

    public static int[] findTwoNumberSum(int[] array1, int sum) {
        // Step 1: Initialize the Map
        // and put all numbers in Map
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i < array1.length; i++){
            map.put(array1[i],i);
        }

        // Step 2: Loop through the array and find the
        // complement number in map
        for(int j = 0; j < array1.length; j++){
            int toFind = sum - array1[j];
            if (map.get(toFind) != null){
                result[0] = array1[j];
                result[1] = array1[map.get(toFind)];
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array1 = {1,2,3,4,5,6,7,8};
        int sum = 7;
        int[] result = findTwoNumberSum(array1, sum);
        System.out.println("Result: Number 1= "+result[0]+" Number 2= "+result[1]);
        System.out.println("Sum: "+ sum);
    }

    //The time complexity for this algorithm is O(n)
}
