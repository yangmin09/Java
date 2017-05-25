package test;

/**
 * @author yangmin
 * @email ym99929@alibaba-inc.com
 * @date 2017/3/5 下午10:01
 * @description
 */
public class LoopTest {


	public static void main(String[] args) throws InterruptedException{
		while(true){
			System.out.println("test");
			Thread.sleep(1000);
		}
	}
}
