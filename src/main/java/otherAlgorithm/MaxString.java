package otherAlgorithm;

import java.util.Arrays;

/**
 * Created by yangmin on 15/8/21.
 */
public class MaxString {

	public static void main(String[] args) {
		MaxString maxString = new MaxString();
		System.out.println(maxString.maxString("helloworld"));


	}

	int maxString(String str) {

		char[] chars = str.toCharArray();
		int count = 0;
		int[] test = new int[256];
		Arrays.fill(test, -1);
		int begin = 0;
		int begin_back = 0;
		for (int i = 0; i < chars.length; i++) {
			if (test[chars[i] - '\0'] == -1)
				test[chars[i] - '\0'] = i;
			else {
				count = Math.max(count, i - begin);
				begin_back = test[chars[i] - '\0'] + 1;
				for (int j = begin; j < begin_back - 1; j++)
					test[chars[j] - '\0'] = -1;
				begin = begin_back;
			}
		}
		count = Math.max(count, chars.length - begin);
		return count;

	}
}
