package java8;

import java.util.function.Predicate;

/**
 * Created by yangmin on 16/7/23.
 */

class Artist {

	String name;
	boolean isFromLondon;

	public Artist(String name, boolean isFromLondon) {
		this.name = name;
		this.isFromLondon = isFromLondon;
//		System.out.println("Initiating-----zzz");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

public class Lamda {

	public static Predicate<Integer> lazyTest(Predicate<Integer> p1, Predicate<Integer> p2) {
		return p1.and(p2);
	}

	public static void main(String[] args) {

		/*Artist brow=new Artist("Obama",true);



		List<Artist> artists = Arrays.asList(new Artist("brown", false), new Artist("hellen", true), new Artist("max", true));

		Stream<Artist> str = artists.stream().filter(artist -> {

			System.out.println(artist.getName());
			return artist.isFromLondon;
		});

		System.out.println(str.count());*/
		/*Stream<String> of = Stream.of("c2", "a1","a2", "b0");
		Stream<String> map = of.map(s -> {
			System.out.println("map: " + s);//副作用
			return s.toUpperCase();
		});
		Stream<String> filter = map.filter(s -> {
			System.out.println("filter: " + s);
			return s.startsWith("A");
		});
		filter.forEach(s -> System.out.println("forEach: " + s));
*/
		lazyTest(x -> {
			System.out.println("this is predicate p1");
			return x > 0;
		}, x -> {
			System.out.println("this is predicate p2");
			return x < 8;
		});


	}
}
