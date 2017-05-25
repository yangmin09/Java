package Reflect;

import java.lang.reflect.Method;

/**
 * @author Hercules
 * @mailto ym99929@alibaba-inc.com
 * @date 2017/4/15 下午2:10
 * @description
 */
public class MethodReflectTest {

	public static void main(String[] args) throws Exception {
		Class driver = Driver.class;
		Method method = driver.getDeclaredMethod("drive", null);
		Driver driverDemo = new James();
		method.invoke(driverDemo,null);
		System.out.println(driver.getResource("../reference/").getPath());
	}
}

interface Driver {
	void drive();
}

class James implements Driver {
	public void drive() {
		System.out.println("James is driving---");
	}
}
