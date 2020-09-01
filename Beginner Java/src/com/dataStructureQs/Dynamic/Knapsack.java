package com.dataStructureQs.Dynamic;

public class Knapsack {

    public int knapsack(int[] wt, int[] value, int n, int maxWt){
        if (n == 0 || maxWt == 0){
            return 0;
        }
        if (wt[n-1] <= maxWt){
            return Math.max(value[n-1]+knapsack(wt,value,n-1,maxWt-wt[n-1]),
                    knapsack(wt,value,n-1, maxWt));
        }else{
            return knapsack(wt,value, n-1, maxWt);
        }
    }

    public static void main(String[] args) {
        int[] wt = {2,3,5,8};
        int[] value = {10,20,30,60};
        int maxWt = 8;

        Knapsack k = new Knapsack();

        System.out.println("Max value in Knapsack is:"+k.knapsack(wt,value, wt.length, maxWt));

    }
}
