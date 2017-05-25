package rmi;

import javax.naming.Context;
import javax.naming.InitialContext;

/**
 * Created by yangmin on 16/8/14.
 */
public class Client {

	public static void main(String[] args) {
		String url = "rmi://localhost:1099/";

//		在服务器端主机名选用ip地址
//		在客户端先根据host寻找服务端,寻找到之后根据名称找到对应的对象,服务器端返回该对象的sub,这个sub就作为一个代理
//		skelton和stub代理由RMI系统自动生成
		try {
			Context namingContext = new InitialContext();
			// 检索指定的对象。 即找到服务器端相对应的服务对象存根
			IService service02 = (IService) namingContext.lookup(url
					+ "service02");
			//这个过程通过存根完成
		/*	Class stubClass = service02.getClass();
			System.out.println(service02 + " 是 " + stubClass.getName()
					+ " 的实例！");
			// 获得本底存根已实现的接口类型
			Class[] interfaces = stubClass.getInterfaces();
			for (Class c : interfaces) {
				System.out.println("存根类实现了 " + c.getName() + " 接口！");
			}*/
			System.out.println(service02.service("你好！"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
