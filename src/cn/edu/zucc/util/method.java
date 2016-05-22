package cn.edu.zucc.util;

/**
 * Created by shentao on 2016/5/19.
 */
public class method {
        public static String fomat(String s) {
            String[] t = s.split("\\.");//字符分隔标志
            //输出起始用户名
            System.out.println("user name:" + t[0]);
            //判断,如果分隔符后面还有字符串,则继续进行输出
            if (t.length > 1) {
                return t[t.length - 1];
            }

            return null;
        }



}
