package test;

/**
 * @author Hercules
 * @mailto ym99929@alibaba-inc.com
 * @date 2017/8/6 上午1:14
 * @description
 */
public class ParkTest {

    //
    //private void get(){
    //
    //    LockSupport.park();
    //
    //
    //}

    public static void main(String[] args) {
        String s1="hello";
        String s2="hello";
        //String
        System.out.println(s1==s2);
        System.out.println(s1.intern()==s1);
    }







}
