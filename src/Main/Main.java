package Main;
import Algorithms.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // Searching algorithm
        int [] array = {2, 30, -2, 12, 3, 213, -1, -2, 213, 40, 1, 23, 32, 3};

        int item = 213;
        // linear search - complexity O(n)
        int searchIndex = SearchAlgo.linearSearch(array, item);

        System.out.println("(linear search) index of " + item + " = " + searchIndex);

        item = 23;

        // binary search - complexity O(log n)
        System.out.println("(binary search) index of " + item + " = " + SearchAlgo.binarySearch(array, item));

        // Sorting Algorithms
        System.out.println("Unsorted array: " + Arrays.toString(array));

        SortWithAlgorithms sort = new SortWithAlgorithms(array);

        // bubble sort - complexity O(n^2)
        // System.out.println(
        //    "(Bubble sort) Sorted array: " + Arrays.toString(sort.bubbleSort())
        // );

        // Selection sort - complexity O(n^2)
        // System.out.println(
        //    "(Selection sort) Sorted array: " + Arrays.toString(sort.selectionSort())
        // );

        // Insertion sort - complexity O(n^2)
        // System.out.println(
        //    "(Insertion sort) Sorted array: " + Arrays.toString(sort.insertionSort())
        // );

        // Quick Sort - complexity: worst case -> O(n^2) average case -> O(n log n)
        System.out.println("(Quick sort) Sorted Array: " + sort.quickSort());
    }
}
