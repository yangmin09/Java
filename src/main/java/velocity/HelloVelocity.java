package velocity;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;


/**
 * Created by yangmin on 16/7/25.
 */
public class HelloVelocity {


	public static void main(String[] args) throws Exception {

		// 初始化并取得Velocity引擎
		VelocityEngine ve = new VelocityEngine();
		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());

		ve.init();

		// 取得velocity的模版
		Template t = ve.getTemplate("Learn.vm");

		// 取得velocity的上下文context
		VelocityContext context = new VelocityContext();

		// 把数据填入上下文
		context.put("name", "sheng");
		context.put("date", (new Date()).toString());

		// 为演示后面的例子，提前输入List数值
		List temp = new ArrayList();
		Hashtable<String, String> hashTable = new Hashtable();
		hashTable.put("yangmin", "great");
		temp.add("1");
		temp.add("2");

		context.put("list", temp);
		context.put("hashTable", hashTable);

		// 输出流
		StringWriter writer = new StringWriter();


		// 转换输出
		t.merge(context, writer);

		System.out.println(writer.toString());

	}
}
