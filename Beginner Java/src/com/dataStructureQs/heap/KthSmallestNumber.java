package com.dataStructureQs.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestNumber {

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

    public static void main(String[] args) {
        int[] arr = {1,3,3,4,5};
        int k = 3;
        System.out.println("Kth smallest number is = "+kthSmallestNumber(arr, k));
    }
}
