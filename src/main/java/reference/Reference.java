package reference;

import java.lang.ref.WeakReference;
import java.util.Date;

/**
 * @author yangmin
 * @email ym99929@alibaba-inc.com
 * @date 2017/3/3 上午12:35
 * @description
 */
public class Reference {

	public static void main(String[] args) {
		WeakReference ref = new WeakReference(new MyDate());
		System.gc();
		System.out.println("test---");
	}
}
class MyDate{

}