package com.dataStructureQs.binarySearch;

public class Search2DArray {

    public static int[] search2DArray(int[][] array, int element){
        int[] result = new int[2];
        int row = 0;
        int column = array[0].length -1;

        while ( row >=0 && row < array.length && column >= 0){
            if (array[row][column] == element){
                result[0] = row;
                result[1] = column;
                return result;
            }else if(array[row][column] > element){
                column--;
            }else if(array[row][column] < element){
                row++;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[][] array =
                {{10, 20, 30, 40},
                {12, 21, 32, 41},
                {15, 25, 35, 45},
                {20, 31, 40, 50}
        };
        int element = 25;
        int[] result = search2DArray(array, element);
        if (result != null){
            System.out.println("Element is found at row "+result[0]+ " column "+result[1]);
        }else{
            System.out.println("Element is NOT found!");
        }
    }
}
