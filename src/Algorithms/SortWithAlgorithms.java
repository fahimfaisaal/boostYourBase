package Algorithms;

import java.util.ArrayList;
import java.util.List;

public class SortWithAlgorithms {
	private final int [] array;
	private final List<Integer> list;
	private int i;
	private int j;
	private int length;

	public SortWithAlgorithms(int [] array, int i, int j) {
		this.array = array;
		this.list = this.arrayToList(array);
		this.i = i;
		this.j = j;
		this.length = array.length;
	}

	public SortWithAlgorithms(int [] array, int i) {
		this.array = array;
		this.list = this.arrayToList(array);
		this.i = i;
		this.j = 0;
		this.length = array.length;
	}

	public SortWithAlgorithms(int [] array) {
		this.array = array;
		this.list = this.arrayToList(array);
		this.i = 0;
		this.j = 0;
		this.length = array.length;
	}

	public int[] getArray() {
		return array;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	private List<Integer> arrayToList(int [] array) {
		List<Integer> list = new ArrayList<>(this.length);

		for (int number : array) {
			list.add(number);
		}

		return list;
	}

	private int [] bSortPartition(int [] array, int i, int j, int len) {
		if (j == len - i - 1) {
			return array;
		}

		if (array[j] > array[j + 1]) {
			int swap = array[j];
			array[j] = array[j + 1];
			array[j + 1] = swap;
		}

		return bSortPartition(array, i, j + 1, len);
	}

	private int [] bSort(int [] array, int i, int j, int len) {
		if (i == len - 1) {
			return array;
		}

		bSortPartition(array, i, j, len);

		return bSort(array, i + 1, 0, len);
	}

	/**
	 * @return sortedArray {mutable} (bubble sort)
	 */
	public int [] bubbleSort() {
		return this.bSort(this.array, this.i, this.j, this.length);
	}

	private int [] select(int [] arr, int j, int len, int max, int index) {
		if (j == len) {
			return new int[] {max, index};
		}

		if (max < arr[j]) {
			max = arr[j];
			index = j;
		}

		return select(arr, j + 1, len, max, index);
	}

	private int [] sSort(int [] arr, int i, int len) {
		if (i == len) {
			return arr;
		}

		int [] selection = select(arr, 0, len - i, arr[0], 0);

		if (selection[0] != arr[len - i - 1]) {
			int swap = arr[selection[1]];
			arr[selection[1]] = arr[len - i - 1];
			arr[len - i - 1] = swap;
		}

		return sSort(arr, i + 1, len);
	}

	/**
	 * @return sortedArray {mutable} (Selection sort)
	 */
	public int [] selectionSort() {
		return sSort(this.array, this.i, this.length);
	}

	private int [] checkLeft(int [] array, int j) {
		if (j <= 0 || array[j - 1] < array[j]) {
			return array;
		}

		int swap = array[j - 1];
		array[j - 1] = array[j];
		array[j] = swap;

		return this.checkLeft(array, j - 1);
	}

	private int [] iSort(int [] array, int i, int len) {
		if (i == len) {
			return array;
		}

		if (i != 0 && array[i - 1] > array[i]) {
			this.checkLeft(array, i);
		}

		return iSort(array, i + 1, len);
	}

	/**
	 * @return sorted array {mutable} (Insertion sort)
	 */
	public int [] insertionSort() {
		return iSort(this.array, this.i, this.length);
	}

	private List<Integer> partition(List<Integer> list, int pivot, String con, int len, List<Integer> newList) {
		if (len == 0) {
			return newList;
		}

		int currentNumber = list.get(len - 1);

		if (con.equals("less")) {
			if (currentNumber <= pivot) {
				newList.add(currentNumber);
			}
		} else {
			if (currentNumber > pivot) {
				newList.add(currentNumber);
			}
		}

		return partition(list, pivot, con, len - 1, newList);
	}

	private List<Integer> qSort(List<Integer> list, int len) {
		if (len < 2) {
			return list;
		}

		int pivot = list.remove(len / 2);

		List<Integer> lessThanPivot = partition(list, pivot, "less", len - 1, new ArrayList<>());
		List<Integer> greaterThanPivot = partition(list, pivot, "greater", len - 1, new ArrayList<>());

		List<Integer> sortedList = new ArrayList<>(lessThanPivot.size() + greaterThanPivot.size());

		sortedList.addAll(qSort(lessThanPivot, lessThanPivot.size()));
		sortedList.add(pivot);
		sortedList.addAll(qSort(greaterThanPivot, greaterThanPivot.size()));

		return sortedList;
	}

	/**
	 * @return new List (Quick sort)
	 */
	public List<Integer> quickSort() {
		return this.qSort(this.list, this.length);
	}
}
