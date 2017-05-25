package Exception;

/**
 * @author yangmin
 * @email ym99929@alibaba-inc.com
 * @date 2017/3/2 下午8:06
 * @description
 */
public class Junk {
	public static void main(String args[]) {
		try {
			a();
		} catch (HighLevelException e) {

			StackTraceElement[] a=e.getStackTrace();
			e.printStackTrace();
		}
	}

	static void a() throws HighLevelException {
		try {
			b();
		} catch (MidLevelException e) {
			throw new HighLevelException(e);
		}
	}

	static void b() throws MidLevelException {
		c();
	}

	static void c() throws MidLevelException {
		try {
			d();
		} catch (LowLevelException e) {
			throw new MidLevelException(e);
		}
	}

	static void d() throws LowLevelException {
		e();
	}

	static void e() throws LowLevelException {
		throw new LowLevelException();
	}
}

class HighLevelException extends Exception {
	HighLevelException(Throwable cause) {
		super(cause);
	}
}

class MidLevelException extends Exception {
	MidLevelException(Throwable cause) {
		super(cause);
	}
}

class LowLevelException extends Exception {
}
