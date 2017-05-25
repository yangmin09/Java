package sortalgorithm;

/**
 * Created by yangmin on 15/8/27.
 */

public class HeapSort {
	public static void main(String[] args) {

		// TODO 自动生成的方法存根
		int[] a = {1, 2, 3, 7, 9, 89, 1, 4, 45, 6};
		HeapSort hello = new HeapSort();
		hello.heapSort(a);
	}

	//化堆方法
	void heapify(int[] a, int index, int n) {

		int tmp;
		if (2 * index + 1 <= n) {
			if (a[2 * index - 1] < Math.min(a[index - 1], a[2 * index])) {
				tmp = a[index - 1];
				a[index - 1] = a[2 * index - 1];
				a[2 * index - 1] = tmp;
				heapify(a, 2 * index, n);
			} else if (a[2 * index] < Math.min(a[index - 1], a[2 * index - 1])) {
				tmp = a[index - 1];
				a[index - 1] = a[2 * index];
				a[2 * index] = tmp;
				heapify(a, 2 * index + 1, n);
			}
		} else if (2 * index == n) {
			if (a[index - 1] > a[2 * index - 1]) {
				tmp = a[index - 1];
				a[index - 1] = a[2 * index - 1];
				a[2 * index - 1] = tmp;
			}
		}

	}

	//提取方法
	int extract(int[] a, int n) {
		int tmp;
		tmp = a[0];
		a[0] = a[n - 1];
		a[n - 1] = tmp;
		heapify(a, 1, n - 1);
		return a[n - 1];
	}

	//建堆
	void buildHeap(int[] a) {
		int n = a.length;
		for (int i = n / 2; i >= 1; i--)
			heapify(a, i, n);

	}

	//堆排序
	void heapSort(int[] a) {
		buildHeap(a);
		for (int i = a.length; i > 0; i--)
			System.out.print(extract(a, i) + " ");
	}

	//插入
	boolean insert(int[] a, int n, int target) {
		if (a.length < n + 1)
			return false;//返回false代表插入失败
		a[n] = target;
		int x = n + 1;
		int y = x / 2;
		while (y >= 1 && a[y - 1] > a[x - 1]) {
			int tmp = a[y - 1];
			a[y - 1] = a[x - 1];
			a[x - 1] = tmp;
			x = y;
			y = y / 2;
		}
		return true;

	}

	//建堆的另外一种方法
	void buildHeap1(int[] a) {
		int[] b = new int[a.length];
		for (int i = 0; i < a.length; i++)
			insert(b, i, a[i]);
		System.arraycopy(b, 0, a, 0, a.length);
	}

}

