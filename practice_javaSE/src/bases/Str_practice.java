package bases;

import java.util.Scanner;

public class Str_practice {
    static Scanner cin=new Scanner(System.in);
    static String right_username="itheima";
    static String right_password="123456";
    static boolean log_in(){
        int num=0;
        String username,password;
        while (true){
            System.out.println("请输入你的用户名:");
            username=cin.next();
            System.out.println("请输入你的密码:");
            password=cin.next();
            if(username.equals(right_username)&&password.equals(right_password)){
                return true;
            }
            else{
                num++;
                System.out.println("用户名或者密码输入有误,请重新输入!你还有"+(3-num)+"次机会.");
            }
            if(num==3){
                return false;
            }
        }

    }
    public static void main(String[] args) {
        if (log_in()) {
            System.out.println("登陆成功,欢迎使用!");
        }
        else{
            System.out.println("已无登陆机会,系统将自动退出!");
        }
    }
}
