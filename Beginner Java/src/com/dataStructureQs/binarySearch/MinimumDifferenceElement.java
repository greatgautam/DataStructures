package com.dataStructureQs.binarySearch;

public class MinimumDifferenceElement {

    public static int minimumDifferenceElement(int[] arr, int element){
        int start = 0;
        int end = arr.length -1;
        while (start < end){
            int mid = start + (end - start)/2;
            if (arr[mid] == element){
                return 0;
            }else if( arr[mid] < element){
                start = mid +1;
            }else{
                end = mid -1;
            }
        }

        int diff = Math.min(Math.abs(arr[start]-element),Math.abs(arr[end]-element));

        return diff;
    }
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 6, 8, 13, 14, 18};
        int element = 10;
        System.out.println("Minimum difference with the given element is = "+minimumDifferenceElement(arr,element));
    }
}
