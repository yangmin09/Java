package test;

import javax.management.AttributeList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author yangmin
 * @email ym99929@alibaba-inc.com
 * @date 2016/12/1 下午2:35
 * @description
 */
public class StreamTest {

	public static List<Integer> buildRetentionTimePeriods(String retentionTimePeriod) {

		int totalSize = Integer.parseInt(retentionTimePeriod);
		List<Integer> result = new ArrayList<>();
		if (totalSize < 9){
			for(int i=1;i<totalSize+1;i++)
				result.add(i);
			return result;
		}

		int count = (totalSize - 2) / 7;
		result.add(1);
		int tag=0;
		for (int i = 2; tag<7; i += count) {
			result.add(i);
			tag++;
		}
		result.add(totalSize);

		return result;
	}


	public static void main(String[] args) {
//
//		Stream<String> map=Stream.of("c2","a1","a2","b0")
//				.filter(s->s.startsWith("a"));
//		Stream<String> map1=map.map(s->s.toUpperCase());
//		IntStream map2=map1.mapToInt(s->s.length());
//		System.out.println(map2.sum());
////		System.out.println(map1.count());
//		buildRetentionTimePeriods("20").forEach(x-> System.out.println(x));

//		System.out.println(buildRetentionTimePeriods("20").toString());

		System.out.println();

		ArrayList list=new AttributeList();
		Iterator iterator=list.iterator();
			}
}
