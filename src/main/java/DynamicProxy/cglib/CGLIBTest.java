package DynamicProxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author Hercules
 * @mailto ym99929@alibaba-inc.com
 * @date 2017/4/15 下午4:21
 * @description
 */
public class CGLIBTest {

	public static void main(String[] args) {

		James james = new James();
		Kobe kobe=new Kobe();
		Enhancer enhancer = new Enhancer();
		Hacker hacker = new Hacker();
		enhancer.setSuperclass(james.getClass());
		enhancer.setCallback(hacker);
		James test = (James) enhancer.create();
		test.drive();
		Enhancer enhancer1 = new Enhancer();
		enhancer1.setSuperclass(kobe.getClass());
		enhancer1.setCallback(hacker);
		Kobe test1 = (Kobe) enhancer1.create();
		test1.drive();

	}


}

class James {

	public void drive() {
		System.out.println("James is driving---");
	}

}

class Kobe {

	public void drive() {

		System.out.println("Kobe is driving---");

	}

}

class Hacker implements MethodInterceptor {

	public Object intercept(Object obj, Method method, Object[] args,
							MethodProxy proxy) throws Throwable {
		System.out.println("**** I am a hacker,Let's see what the poor programmer is doing Now...");
		System.out.println(method);
		System.out.println(obj.getClass());
		proxy.invokeSuper(obj, args);
//		method.invoke(obj,args);
		System.out.println("****  Oh,what a poor programmer.....");
		return null;
	}
}