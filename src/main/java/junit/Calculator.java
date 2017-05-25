package junit;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by yangmin on 16/8/18.
 */
public class Calculator {


	// TODO: 16/8/19
	public static void main(String[] args) {


// 模拟的创建，对接口进行模拟
		List mockedList = mock(List.class);
// 使用模拟对象
		mockedList.add("one");
		mockedList.clear();
// 选择性地和显式地验证
		verify(mockedList).add("one");
		verify(mockedList).clear();
	}


}
