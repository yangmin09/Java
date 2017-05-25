package DynamicProxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by yangmin on 16/8/21.
 */
public class MyHandler implements InvocationHandler {

	IA a;

	public MyHandler(IA a) {
		this.a = a;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		return method.invoke(a, args);


	}
}
