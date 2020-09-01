package com.dataStructureQs.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class SumOfNSmallestAndMSmallestNumbers {

    public static int kthSmallestNumber(int[] arr, int k){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int num: arr){
            maxHeap.offer(num);
            if (maxHeap.size() > k){
                maxHeap.poll();
            }
        }
        return maxHeap.peek();
    }

    public static int sumOfSmallestNumbers(int[] arr, int n, int m){
        int first = kthSmallestNumber(arr,n);
        int second = kthSmallestNumber(arr,m);

        int total = 0;
        for(int num: arr){
            if (num > first && num < second){
                total = total + num;
            }
        }

        return total;

    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        int n = 3;
        int m = 7;
        System.out.println("Kth smallest number is = "+sumOfSmallestNumbers(arr, n, m));
    }
}
