package DSA;

public class SearchAlgo {
	private static int lSearch(int [] array, int value, int index) {
		if (index != -1) {
			if (array[index] == value) {
				return index;
			}

			return lSearch(array, value, index - 1);
		}

		return -1;
	}

	public static int linearSearch(int[] array, int key) {
		return lSearch(array, key, array.length - 1);
	}

	private static int bSearch(int [] array, int value, int start, int end) {
		if (start <= end) {
			int mid = start + (end - start) / 2;

			if (array[mid] == value) {
				return mid;
			}

			if (array[mid] < value) {
				return bSearch(array, value, mid + 1, end);
			}

			return bSearch(array, value, start, mid - 1);
		}

		return -1;
	}

	public static int binarySearch(int [] array, int value) {
		return bSearch(array, value, 0, array.length - 1);
	}
}
