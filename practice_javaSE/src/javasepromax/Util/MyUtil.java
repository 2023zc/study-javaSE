package javasepromax.Util;

import java.util.Random;

public class MyUtil {
    private MyUtil() {   //因为工具类只是为了调用方法，所以不需要生成对象，所以直接让构造器私有，这样就不能再生成对象了

    }

    static Random rand = new Random();

    public static String createCode(int n) {    //放回n位验证码
        String ans = new String();
        String date = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < n; i++) {
            ans += date.charAt(rand.nextInt(53));
        }
        return ans;
    }
}
