package io;

import java.io.*;

/**
 * Created by yangmin on 16/8/21.
 */
public class JavaIO {


	public static void main(String[] args) throws Exception {

		File file = new File(JavaIO.class.getResource("..").getPath()+"hello.txt");
		FileOutputStream outputStream = new FileOutputStream(file);
		DataOutputStream dataOutputStream=new DataOutputStream(outputStream);
		BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(dataOutputStream,20);

		bufferedOutputStream.write("hello".getBytes());

	}


}
