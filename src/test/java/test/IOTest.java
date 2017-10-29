package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author Hercules
 * @mailto ym99929@alibaba-inc.com
 * @date 2017/9/11 下午5:03
 * @description
 */
public class IOTest {

    public static void main(String[] args) {

        try {
            BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
            String readline = sin.readLine();
            System.out.println(readline);
        } catch (Throwable e) {
            System.out.println(e);
        }

    }

}
