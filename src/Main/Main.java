package Main;
import DSA.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // Searching algorithm
        int [] array = {2, 30, 12, 3, 213, -1, -2, 40, 1, 23, 32, 3};

        int item = 213;
        // linear search - complexity O(n)
        int searchIndex = SearchAlgo.linearSearch(array, item);

        System.out.println("(linear search) index of " + item + " = " + searchIndex);

        item = 23;

        // binary search - complexity O(log n)
        System.out.println("(binary search) index of " + item + " = " + SearchAlgo.binarySearch(array, item));

        // Sorting Algorithm
        System.out.println("Unsorted array: " + Arrays.toString(array));

        // bubble sort - complexity O(n^2)
        // SortingAlgo.bubbleSort(array, 0, 0, array.length);

        // System.out.println("(Bubble sort) Sorted array: " + Arrays.toString(array));

        // selection sort - complexity O(n^2)
        System.out.println(
            "(Selection sort) Sorted array: " + Arrays.toString(
            SortingAlgo.selectionSort(array, 0, array.length)
            )
        );

    }
}
