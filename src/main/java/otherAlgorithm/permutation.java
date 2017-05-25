package otherAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class permutation {

	List<List<Integer>> res = new ArrayList<List<Integer>>();

	public static void main(String[] args) {

		permutation hello = new permutation();
		hello.combine(10, 7);
		System.out.println(hello.res);


	}

	public List<List<Integer>> combine(int n, int k) {
		List<Integer> result1 = new ArrayList<Integer>();
		List<Integer> result2 = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++)
			result1.add(i);
		combine(k, result1, result2);
		return res;
	}

	public void combine(int num, List<Integer> result1, List<Integer> result2) {
		if (result2.size() == num) {
			res.add(result2);
		}
		for (int i = 0; i < result1.size(); i++) {
			List<Integer> tmp1 = new ArrayList<Integer>(result1);
			List<Integer> tmp2 = new ArrayList<Integer>(result2);
			tmp2.add(tmp1.get(i));
			tmp1.remove(i);
			combine(num, tmp1, tmp2);
		}
	}
}