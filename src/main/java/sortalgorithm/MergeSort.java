package sortalgorithm;

/**
 * Created by yangmin on 15/8/27.
 */
public class MergeSort {


	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] list = {1, 2, 3, 7, 14, 89, 5, 4, 9, 6};
		MergeSort mergeSort = new MergeSort();
		mergeSort.mergeSort(list);
		for (int i = 0; i < list.length; i++)
			System.out.print(list[i] + " ");
	}

	public void mergeSort(int[] list) {
		if (list.length > 1) {
			int[] firsthalf = new int[list.length / 2];
			System.arraycopy(list, 0, firsthalf, 0, list.length / 2);
			mergeSort(firsthalf);
			int[] secondhalf = new int[list.length - list.length / 2];
			System.arraycopy(list, list.length / 2, secondhalf, 0, list.length - list.length / 2);
			mergeSort(secondhalf);
			int[] tmp = merge(firsthalf, secondhalf);
			System.arraycopy(tmp, 0, list, 0, list.length);

		}


	}

	public int[] merge(int[] a, int[] b) {

		int[] c = new int[a.length + b.length];
		int i = 0;
		int j = 0;
		int k = 0;
		while (i < a.length && j < b.length) {
			if (a[i] <= b[j])
				c[k++] = a[i++];
			else
				c[k++] = b[j++];


		}
		if (i == a.length)
			while (k < c.length)
				c[k++] = b[j++];
		else
			while (k < c.length)
				c[k++] = a[i++];

		return c;

	}

}
