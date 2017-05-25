package test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yangmin
 * @email ym99929@alibaba-inc.com
 * @date 2016/11/9 上午7:27
 * @description //
 */
public class DateTest {


	public static void main(String[] args) {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyMMdd");
		System.out.println(formatter.format(date));


	}


}


