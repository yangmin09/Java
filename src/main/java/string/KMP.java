package string;


public class KMP {


	public static void main(String[] args) {
		KMP kmp = new KMP();
		System.out.println(kmp.kmp("welcome to china boy", "boy"));


	}

	int[] getNext(char[] chars) {
		int[] next = new int[chars.length];
		next[0] = 0;
		for (int q = 1; q < next.length; q++) {
			int k = next[q - 1];
			int flag = 1;
			while (chars[k] != chars[q]) {
				if (k >= 1)
					k = next[k - 1];
				else {
					flag = 0;
					break;
				}
			}
			if (flag == 0)
				next[q] = 0;
			else
				next[q] = k + 1;
		}
		return next;
	}

	int kmp(String str1, String str2) {
		char[] chars1 = str1.toCharArray();
		char[] chars2 = str2.toCharArray();
		int[] next = getNext(chars2);
		int i = 0;
		while (i < chars1.length && chars1[i] != chars2[0])
			i++;
		if (i == chars1.length)
			return -1;
		System.out.println(i);
		int begin = i;

		while (true) {
			while (i < chars1.length && chars1[i] == chars2[i - begin]) {
				if (i - begin == chars2.length - 1)
					return begin;
				else
					i++;
			}
			if (i == chars1.length)
				return -1;
			if (next[i - begin - 1] != 0)
				begin = i - begin - next[i - begin - 1] + begin;
			else {
				int j = i;
				while (j < chars1.length && chars1[j] != chars2[0])
					j++;
				if (j == chars1.length)
					return -1;
				System.out.println(j);
				begin = j;
				i = begin;
			}

		}
	}

}
