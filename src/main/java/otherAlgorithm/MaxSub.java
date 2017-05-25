package otherAlgorithm;

/**
 * Created by yangmin on 15/8/21.
 */
public class MaxSub {


	public static void main(String[] args) {

		MaxSub maxSub = new MaxSub();
		int[] a = {2, 3, 4, 5, 6, 7, 2, 3, 4, 1, 3, 5};

		System.out.println(maxSub.maxSub(a, 0));


	}

	int maxSub(int[] a, int begin) {
		int count = 0;

		for (int i = 1; i < a.length; i++) {
			if (a[i] >= a[i - 1])
				;
			else {
				count = Math.max(i - begin, count);
				begin = i;
			}

		}

		count = Math.max(a.length - begin, count);

		return count;

	}
}
