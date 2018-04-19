package test;

import java.net.URLEncoder;

/**
 * @author yangmin
 * @email ym99929@alibaba-inc.com
 * @date 2017/3/6 上午12:17
 * @description
 */
public class LoopTest2 {

	public static void main(String[] args) throws InterruptedException{
		//while(true){
		//	System.out.println("test2");
		//	Thread.sleep(1000);
		//}
		System.out.println(URLEncoder.encode("mp3%2Bplayer"));
	}
}
