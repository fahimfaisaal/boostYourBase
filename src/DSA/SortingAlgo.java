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

	public static void bubbleSort(int [] array) {
		int len = array.length;

		for (int i = 0; i < len - 1; i++) {
			for (int j = 0; j < len - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					int swap = array[j];
					array[j] = array[j + 1];
					array[j + 1] = swap;
				}
			}
		}
	}
}
