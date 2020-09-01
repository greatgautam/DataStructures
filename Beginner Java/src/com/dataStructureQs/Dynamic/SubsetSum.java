package com.dataStructureQs.Dynamic;

public class SubsetSum {

    public boolean subsetSum(int[] array, int sum, int n){
        boolean result = false;
        if ( n == 0 || sum == 0){
            return result;
        }

        if (array[n-1] <= sum ){
            result = subsetSum(array,sum-array[n-1],n-1) && subsetSum(array, sum, n-1);
        }else{
            subsetSum(array, sum, n-1);
        }

        return result;
    }
    public static void main(String[] args) {
        int[] array = {1,2,3};
        int sum = 5;

        SubsetSum s = new SubsetSum();
        System.out.println("Subset for sum = "+sum+" exists = "+s.subsetSum(array, sum, array.length));
    }
}
