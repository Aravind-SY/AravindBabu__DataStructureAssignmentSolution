package com.greatlearning.company.service;

public class SortingService {
	
	public static void sort(int[] arr, int l, int r) {
		if (l < r) {
			// find the middle index
			int m = l + (r - l) / 2;

			// sort the left half
			sort(arr, l, m);

			// sort the right half
			sort(arr, m + 1, r);

			// merge the sorted halves
			merge(arr, l, m, r);
		}
	}

	// method to merge the array
	private static void merge(int[] arr, int l, int m, int r) {
		// find sizes of 2 sub-arrays
		int n1 = m - l + 1;
		int n2 = r - m;

		// temporary arrays to hold the halves
		int[] L = new int[n1];
		int[] R = new int[n2];

		// copy data to sub-arrays
		for (int i = 0; i < n1; ++i)
			L[i] = arr[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[m + 1 + j];

		// initialize index for both the sub-arrays
		int i = 0, j = 0;

		// initialize index of merged array
		int k = l;

		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		// copy remaining elements in L[] if any
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		// copy remaining elements in R[] if any
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}

}
