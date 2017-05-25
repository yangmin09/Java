package DynamicProxy.jdk;

/**
 * Created by yangmin on 16/8/21.
 */
public class IAImpl implements IA, IB {


	@Override
	public void print() {
		System.out.println("this is IAImpl-----");
	}


	@Override
	public void say() {

		System.out.println("this is IB-----");

	}
}
