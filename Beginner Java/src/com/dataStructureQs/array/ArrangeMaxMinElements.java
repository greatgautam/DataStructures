package com.dataStructureQs.array;

public class ArrangeMaxMinElements {

    // TODO This solution is incomplete

    public static void arrangeMaxMinElements(int[] array) {

        // Step 1: Find the MAX element and add 1 to it
        // so that no other number is bigger than this number
        int maxElement = array[array.length-1]+1;
        int maxIndex = array.length-1;
        int minIndex = 0;
        // Step 2: Loop through Array
        for(int i = 0; i < array.length; i++){
            if ( i%2 == 0){
                array[i] += (array[maxIndex] * maxElement) ;
                maxIndex--;
            }else{
                array[i] += (array[minIndex] * maxElement) ;
                minIndex++;
            }
        }

        // Step 3: Divide by MaxElement
        for(int i = 0; i < array.length; i++){
            array[i] = array[i] / maxElement;
        }
        

    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        System.out.println("Array after arranging max and min elements is : ");
        arrangeMaxMinElements(array);
        for (int i=0; i < array.length; i++){
            System.out.print(array[i]+" ");
        }
    }

}
