package com.dataStructureQs.Dynamic;

public class KnapsackMemoize {

    public int knapsack(int[] wt, int[] value, int n, int maxWt){

        if (n <= 0 || maxWt <= 0){
            return 0;
        }
        // Step 1: Create a table called memo with number of rows as wt array length +1
        // and number of columns as maxWt +1
        int[][] memo = new int[n+1][maxWt+1];

        // Step 2: Populate 0th row and 0th column with default value of 0
        for (int j = 0; j <= maxWt; j++) {
            memo[0][j] = 0;
        }

        // Step 3:
        for (int i = 1; i < n+1; i++){
            for (int j = 1; j < maxWt+1; j++){
                if (wt[i-1] > j ){
                    memo[i][j] = memo[i-1][j];
                }else{
                    System.out.println("i ="+i+" j ="+j+" wt[i-1] "+wt[i-1]+" New ="+(j-wt[i-1]));
                    memo[i][j] = Math.max(memo[i-1][j],
                            memo[i-1][j-wt[i-1]]+value[i-1]);
                }
            }
        }
        printArray(memo);
        return memo[n][maxWt];
    }

    public static void main(String[] args) {
        int[] wt = {2,3,5,8};
        int[] value = {5,20,32,40};
        int maxWt = 8;

        KnapsackMemoize k = new KnapsackMemoize();

        System.out.println("Max value in Knapsack is:"+k.knapsack(wt,value, wt.length, maxWt));

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
