package com.dataStructureQs.array;

import java.util.HashMap;

public class FindFirstUniqueElement {
    public static int findFirstUniqueElement(int[] array1){

        // Step 1: Define a HashMap
        HashMap<Integer,Integer> map = new HashMap<>();
        // Step 2: Store each element of array and its frequency in HashMap
        for(int i = 0; i < array1.length; i++){
            if ( map.get(array1[i]) != null){
                map.put(array1[i], map.get(array1[i])+1 );
            }else{
                map.put(array1[i],1);
            }
        }

        // Step 3: Loop through array and find the first element
        // that has frequency = 1 in HashMap
        for(int i = 0; i < array1.length; i++){
            if (map.get(array1[i]) == 1){
                return array1[i];
            }
        }

        // In case no element is unique, return -1
        return -1;
    }

    public static void main(String[] args) {
        int[] array1 = {10,2,3,2,10,3,4};
        int unique = findFirstUniqueElement(array1);
        System.out.println("First unique element in array is = "+unique);
    }

}
