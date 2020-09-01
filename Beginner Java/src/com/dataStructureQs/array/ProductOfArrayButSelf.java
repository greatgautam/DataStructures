package com.dataStructureQs.array;

public class ProductOfArrayButSelf {

    public static int[] productOfArrayButSelf(int[] array1){
        // Step 1: Define the array for result
        int[] result = new int[array1.length];

        // Step 2: Store the product of each element to the left of an element
        int product = 1;
        for(int i = 0; i < array1.length; i++){
            result[i] = product;
            product = product * array1[i];
        }

        // Step 3: Store the product of each element to the right of an element
        product = 1;
        for(int i = array1.length-1; i >=0; i--){
            result[i] = result[i] * product;
            product = product * array1[i];
        }

        return result;
    }
    public static void main(String[] args) {
        int[] array1 = { 1, 2, 3, 4, 5};
        int[] result = productOfArrayButSelf(array1);
        System.out.println("Result is: ");
        for(int i = 0; i < array1.length; i++){
            System.out.print(result[i]+" ");
        }
    }

    //The time complexity for this algorithm is O(n)
}
