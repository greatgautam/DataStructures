package com.dataStructureQs.heap;

import java.util.*;

public class KfrequentNumbers {

    public static Integer[] topKfrequentNumbers(int[] array, int k){
        // Step 1: Create an array for output
        Integer[] out = new Integer[k];

        // Step 2: Create a HashMap to store frequency of each element

        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num: array){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        // Step 3: Create a MaxHeap to keep only top K most frequent numbers
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(Comparator.comparing(e -> e.getValue()));

        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            maxHeap.offer(entry);
            if (maxHeap.size() > k){
                maxHeap.poll();
            }
        }

        // Step 4: Return the output
        int i = 0;
        while (maxHeap.size() > 0){
            out[i] = maxHeap.poll().getKey();
            i++;
        }
        Collections.reverse(Arrays.asList(out));
        return out;
    }
    public static void main(String[] args) {
        int[] arr = {1,1,2,3,1,3,4,5,2,1};
        int k = 3;
        System.out.println("Top K frequent numbers are: ");
        for(int num: topKfrequentNumbers(arr, k)){
            System.out.print(num +" ");
        }
    }
}
