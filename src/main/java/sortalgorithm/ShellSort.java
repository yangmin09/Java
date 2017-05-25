package sortalgorithm;

/**
 * Created by yangmin on 15/8/27.
 */
public class ShellSort {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] list = {1, 2, 3, 7, 2, 89, 1, 4, 2, 6};
		ShellSort hello = new ShellSort();
		hello.shellSort(list);
		for (int i = 0; i < list.length; i++)
			System.out.print(list[i] + " ");
	}

	void shellSort(int[] a) {
		for (int gap = a.length / 2; gap > 0; gap = gap / 2)
			for (int i = 0; i < gap; i++) {
				for (int j = i + gap; j < a.length; j += gap) {
					int tmp = a[j];
					int k = j - gap;
					while (k >= i && a[k] > tmp) {
						a[k + gap] = a[k];
						k -= gap;
					}
				}

			}
	}

}
