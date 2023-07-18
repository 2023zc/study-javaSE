package bases;

import java.util.Scanner;

public class Scan {
    public static void main(String[] args) {
        //1.生成一个键盘扫描对象
        Scanner sc = new Scanner(System.in);
        //2.调用对象的方法
        int a = sc.nextInt();
        //循环输入
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextInt()) {
            int b = scan.nextInt();
            System.out.println(b);
        }
    }
}
