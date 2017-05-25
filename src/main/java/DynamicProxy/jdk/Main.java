package DynamicProxy.jdk;

import java.lang.reflect.Proxy;

/**
 * Created by yangmin on 16/8/21.
 */
public class Main {

	public static void main(String[] args) {
		IAImpl hello = new IAImpl();
		MyHandler handler = new MyHandler(hello);
		System.out.println(hello.getClass().getClassLoader());
		IB proxy = (IB) Proxy.newProxyInstance(hello.getClass().getClassLoader(), hello.getClass().getInterfaces(), handler);
		proxy.say();


	}


}
