package com.dataStructureQs.array;

public class MergeTwoSortedArrays {

        // Merge input array1 and array2 into resultArray
        public static int[] mergeTwoArrays(int[] array1, int[] array2) {
            int size1 = array1.length;
            int size2 = array2.length;

            // Step 1
            // Initialize the new Array and counters
            int[] resultArray = new int[size1+size2];
            int i = 0, j = 0, k = 0;

            // Step 2
            // Traverse both array
            while (i < size1 && j < size2) {
                // If current element of the first
                // array is smaller than current element
                // of the second array then copy the element
                // of the first array and increment the index of
                // the first array. Else copy the element of the
                // second array and increment its index
                if (array1[i] < array2[j])
                    resultArray[k++] = array1[i++];
                else
                    resultArray[k++] = array2[j++];
            }

            // Step 3
            // Copy remaining elements of first array
            while (i < size1)
                resultArray[k++] = array1[i++];

            // Copy remaining elements of the second array
            while (j < size2)
                resultArray[k++] = array2[j++];

            return resultArray;
        }

        public static void main(String args[]) {

            int[] array1 = {1,5,9,10,21}; // first sorted array
            int[] array2 = {3,6,11};  // second sorted array

            int[] resultArray = mergeTwoArrays(array1, array2);

            System.out.print("Arrays after merging: ");
            for(int i = 0; i < array1.length + array2.length; i++) {
                System.out.print(resultArray[i] + " ");
            }
        }

        //The time complexity for this algorithm is O(n+m), where n and m are the sizes of two arrays.
}
