package com.dataStructureQs.Dynamic;

public class KnapsackBaeldung {

    public int knapsackDP(int[] w, int[] v, int n, int W) {
        if (n <= 0 || W <= 0) {
            return 0;
        }

        int[][] m = new int[n + 1][W + 1];
        for (int j = 0; j <= W; j++) {
            m[0][j] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                if (w[i - 1] > j) {
                    m[i][j] = m[i - 1][j];
                } else {
                    m[i][j] = Math.max(
                            m[i - 1][j],
                            m[i - 1][j - w[i - 1]] + v[i - 1]);
                }
            }
        }

        printArray(m);
        return m[n][W];
    }

    public static void main(String[] args) {
        int[] wt = {2,3,5,8};
        int[] value = {5,20,30,40};
        int maxWt = 8;

        KnapsackBaeldung k = new KnapsackBaeldung();

        System.out.println("Max value in Knapsack is:"+k.knapsackDP(wt,value, wt.length, maxWt));

    }

    public static void printArray(int[][] array){
        for(int[] elemArray: array){
            for(int element: elemArray){
                System.out.print(" "+element);
            }
            System.out.println("");
        }
    }
}
