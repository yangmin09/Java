package sortalgorithm;

/**
 * Created by yangmin on 15/8/27.
 */
public class InsertSort {
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] list = {1, 2, 3, 7, 2, 89, 1, 4, 2, 6};
		InsertSort hello = new InsertSort();
		hello.insertSort(list);
		for (int i = 0; i < list.length; i++)
			System.out.print(list[i] + " ");

	}

	void insertSort(int[] a) {
		for (int i = 2; i < a.length; i++) {
			int tmp = a[i];
			int k = i - 1;
			while (k >= 0 && a[k] > tmp) {
				a[k + 1] = a[k];
				k--;
			}
			a[k + 1] = tmp;
		}
	}

}
