package DSA;

public class SortingAlgo {

	public static void bubbleSort(int [] array, int i, int j, int len) {
		if (i == len - 1) {
			return;
		}

		if (j == len - i - 1) {
			return;
		}

		if (j != len - i - 1) {
			if (array[j] > array[j + 1]) {
				int swap = array[j];
				array[j] = array[j + 1];
				array[j + 1] = swap;
			}

			bubbleSort(array, i, j + 1, len);
		}

		bubbleSort(array, i + 1, 0, len);
	}

	private static int [] select(int [] arr, int j, int len, int max, int index) {
		if (j == len) {
			return new int[] {max, index};
		}

		if (max < arr[j]) {
			max = arr[j];
			index = j;
		}

		return select(arr, j + 1, len, max, index);
	}

	public static int [] selectionSort(int [] arr, int i, int len) {
		if (i == len) {
			return arr;
		}

    int [] selection = select(arr, 0, len - i, arr[0], 0);

		if (selection[0] != arr[len - i - 1]) {
			int swap = arr[selection[1]];
			arr[selection[1]] = arr[len - i - 1];
			arr[len - i - 1] = swap;
		}

		return selectionSort(arr, i + 1, len);
	}
}
