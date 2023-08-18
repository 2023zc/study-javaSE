package javasepromax.extend.extend_overwrite;


public class Test {
    public static void main(String[] args) {
        Student s = new Student("小明", 18);
        System.out.println(s);   //重写toString函数输出学生的信息,否则输出学生地址
    }
}
