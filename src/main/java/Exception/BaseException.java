package Exception;

/**
 * @author yangmin
 * @email ym99929@alibaba-inc.com
 * @date 2017/2/25 下午11:56
 * @description 自定义异常
 */
public class BaseException extends Exception {

	public BaseException(String message, Throwable cause) {
		super(message, cause);
	}

	public static class UserBasedException extends Exception {
		public UserBasedException(String message) {
			super(message);
		}

	}

	public static void main(String[] args) {
		try {
//			throw new BaseException("Just test baseException!!!",new UserBasedException("Caused by this!!!"));
			a();
		} catch (Exception e) {
			StackTraceElement[] a=e.getStackTrace();
			e.printStackTrace();
		}

	}


	static void a() throws BaseException{
	b();

	}

	static void b() throws BaseException{
		throw new BaseException("Just test baseException!!!",new UserBasedException("Caused by this!!!"));
	}
}
