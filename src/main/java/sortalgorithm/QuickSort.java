package sortalgorithm;

/**
 * Created by yangmin on 15/8/27.
 */
public class QuickSort {
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		QuickSort quickSort = new QuickSort();
		int[] list = {1, 2, 3, 7, 2, 89, 1, 4, 2, 6};
		quickSort.quickSort(list, 0, list.length - 1);
		for (int i = 0; i < list.length; i++)
			System.out.print(list[i] + " ");

	}

	//	划分
	public int partition(int[] list, int first, int last) {
		int pivot = list[last];
		int div = first - 1;
		int tmp = 0;
		for (int i = first; i < last; i++) {
			if (list[i] < pivot) {
				div++;
				tmp = list[div];
				list[div] = list[i];
				list[i] = tmp;
			}
		}
		tmp = list[div + 1];
		list[div + 1] = pivot;
		list[last] = tmp;


		return div;

	}

	//	快排方法
	public void quickSort(int[] list, int first, int last) {
		if (last > first) {
			int a = partition(list, first, last);
			quickSort(list, first, a);
			quickSort(list, a + 2, last);
		}

	}

}
