package test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.io.*;

/**
 * @author yangmin
 * @email ym99929@alibaba-inc.com
 * @date 2017/3/21 下午8:53
 * @description
 */
public class HtmlResolver {

	public static String resolve(File file) throws FileNotFoundException, IOException {

		FileInputStream inputStream = new FileInputStream(file);
		InputStreamReader reader = new InputStreamReader(inputStream, "UTF-8");
		CharArrayWriter writer = new CharArrayWriter();
		int i = -1;
		while ((i = reader.read()) != -1)
			writer.write(i);
		String str = writer.toString();
		String[] strings=str.split(" = ",-1);
		String baseString=strings[1].substring(0,strings[1].length()-11);
		JSONArray baseArray=JSON.parseArray(baseString).getJSONArray(1);
		for(Object obj:baseArray){
			System.out.println(obj);
		}
//		baseString="helloworld".substring(0,3);
		return baseString;



//		"completion = [\"shaco\",[\"shacos hair\",\"shaco kitchen faucet\",\"shaco faucet\",\"shaco modern brushed nickel stainless steel\",\"shaco modern streamline kitchen faucet\",\"shacoolie\",\"shacos fashionable portable cosmetic bag\",\"shaco commercial\",\"shaco faucet bronze\",\"shacoya wilson\"],[{\"nodes\":[{\"name\":\"Beauty & Personal Care\",\"alias\":\"beauty\"},{\"name\":\"Health, Household & Baby Care\",\"alias\":\"hpc\"}]},{},{},{},{},{},{},{},{},{}],[],\"1ODDMXRA0NWN0\"];String();\n"

	}

	public static void main(String[] args) throws IOException{

		File file=new File("/Users/yangmin/Documents/Java/personal/UsefulTools/src/test/java/test/nax5Hf8f.html");
		System.out.println(resolve(file));


	}


}
