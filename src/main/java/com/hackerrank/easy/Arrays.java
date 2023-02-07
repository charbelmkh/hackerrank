package com.hackerrank.easy;

import java.util.ArrayList;
import java.util.List;

public class Arrays {
    /*
     * Complete the 'dynamicArray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */
    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        int lastAnswer = 0;
        List<Integer> result = new ArrayList<>();
        List<List<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(new ArrayList<>());
        }
        for (List<Integer> query : queries) {
            int queryType = query.get(0);
            int x = query.get(1);
            int y = query.get(2);
            int idx = (x ^ lastAnswer) % n;
            if (queryType == 1) {
                arr.get(idx).add(y);
            } else {
                int size = arr.get(idx).size();
                lastAnswer = arr.get(idx).get(y % size);
                result.add(lastAnswer);
            }
        }
        return result;
    }

    /*
     * Complete the 'hourglassSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */
    public static int hourglassSum(List<List<Integer>> arr) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 1; i < arr.size() - 1; i++) {
            for (int j = 1; j < arr.size() - 1; j++) {
                int tempSum = arr.get(i - 1).get(j - 1) + arr.get(i - 1).get(j) + arr.get(i - 1).get(j + 1) +
                        arr.get(i).get(j) +
                        arr.get(i + 1).get(j - 1) + arr.get(i + 1).get(j) + arr.get(i + 1).get(j + 1);
                maxSum = Math.max(tempSum, maxSum);

            }

        }
        return maxSum;
    }

    /*
     * Complete the 'reverseArray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY a as parameter.
     */
    public static List<Integer> reverseArray(List<Integer> a) {
        ArrayList<Integer> reverseArray = new ArrayList<>();
        for (int i = a.size() - 1; i >= 0; i--) {
            reverseArray.add(a.get(i));
        }
        return reverseArray;

    }

    /*
     * Complete the 'rotateLeft' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER d
     *  2. INTEGER_ARRAY arr
     */
    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
        ArrayList<Integer> rotatedArray = new ArrayList<>(arr);
        int leftShift = d % arr.size();
        if (leftShift != 0) {
            for (int i = 0; i < arr.size(); i++) {
                Integer value = arr.get(i);
                int newPosition = (arr.size() + i - leftShift) % arr.size();
                rotatedArray.set(newPosition, value);
            }
        }
        return rotatedArray;
    }
}