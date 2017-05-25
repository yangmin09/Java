package sortalgorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangmin on 15/8/28.
 */
public class FundementalSort {

	public static void main(String[] args) {

		FundementalSort fundementalSort = new FundementalSort();
		int[] a = {1, 23, 34, 14, 65, 27};
		fundementalSort.fundementalSort(a, 2);
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");


	}

	int getDigit(int a, int d, int target) {

		int[] result = new int[d];
		for (int i = 0; i < d; i++) {
			result[i] = a % 10;
			a = a / 10;
		}
		return result[target];
	}

	void fundementalSort(int[] a, int d) {
		List<List<Integer>> lists = new ArrayList<>();

		for (int i = 0; i < 10; i++)
			lists.add(new ArrayList<Integer>());
		for (int i = 0; i < d; i++) {
			for (int j = 0; j < a.length; j++)
				lists.get(getDigit(a[j], d, i)).add(a[j]);
			int k = 0;
			for (int m = 0; m < 10; m++) {
				for (int j = 0; j < lists.get(m).size(); j++)
					a[k++] = lists.get(m).get(j);
				lists.get(m).clear();
			}

		}
	}


}
