package com.dataStructureQs.heap;

import java.util.*;

public class FrequencySort {

    public static Integer[] frequencySort(int[] arr){

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: arr){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> maxHeap = new PriorityQueue<>(Comparator.comparing(e -> e.getValue()));
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            maxHeap.offer(entry);
        }

        Integer[] out = new Integer[maxHeap.size()];
        int i = 0;
        while (maxHeap.size() > 0){
            out[i] = maxHeap.poll().getKey();
            i++;
        }

        Collections.reverse(Arrays.asList(out));

        return out;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2,3,1,3,4,5,2,2,1};
        System.out.println("Numbers sorted by Frequency are: ");
        for(Integer num: frequencySort(arr)){
            System.out.print(num +" ");
        }
    }
}
