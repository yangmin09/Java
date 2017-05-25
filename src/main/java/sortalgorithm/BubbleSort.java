package sortalgorithm;

/**
 * Created by yangmin on 15/8/27.
 */
public class BubbleSort {

	public static void bubbleSort(int[] list) {
		int flag;
		for (int k = 1; k < list.length - 1; k++) {
			flag = 0;
			for (int j = 1; j < list.length - k; j++) {

				if (list[j] > list[j + 1]) {
					int tmp = list[j];
					list[j] = list[j + 1];
					list[j + 1] = tmp;
					flag = 1;

				}
			}
			if (flag == 0)
				break;
		}
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] list = {1, 2, 3, 7, 2, 89, 1, 4, 2, 6};
		bubbleSort(list);
		for (int i = 0; i < list.length; i++)
			System.out.print(list[i] + " ");

	}

}
