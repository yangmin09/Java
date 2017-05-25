package test;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author yangmin
 * @email ym99929@alibaba-inc.com
 * @date 2016/11/21 下午10:52
 * @description csv的写格式如下：1.如果有逗号，那么所在字段用双引号；2.如果在1的基础上还有引号，那么将引号换为双引号
 * csv读的逻辑如下：1.从最左端的逗号读起，一直到右边为逗号左边部位引号的引号为止，当做一个字段(在没有写格式第二条的前提下，如果以第一
 * 个右边为逗号的引号为终止则会出现异常：如果内部引号右边是一个逗号，那么一个字段就被分离为两个了)，然后将并列的双引号换为
 * 单引号，将两头的引号去除
 *
 * csvWriter的处理逻辑：所有字段都用双引号包起来,如果有单引号则换为双引号；按照csvwirter的逻辑我们总能获得正确的结果；
 */
public class CSVTester {
	public static void main(String[] args) {
		try {

			FileWriter writer = new FileWriter("a.csv");
			CSVWriter csvWriter = new CSVWriter(writer);
			String[] hello=new String[]{"he\"llo","world","goodboy"};
			csvWriter.writeNext(hello);
			csvWriter.flush();
			FileReader reader=new FileReader("a.csv");
			CSVReader csvReader=new CSVReader(reader);
			String[] strs=csvReader.readNext();
			System.out.println(strs[0]);
			System.out.println(strs[1]);
			System.out.println(strs[2]);

		} catch (IOException e) {
			e.printStackTrace();
		}


	}
}
