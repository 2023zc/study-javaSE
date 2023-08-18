package javasepromax.study_Inner_object;

public class test {
    public static void main(String[] args) {
        Outer.Inner_pub io = new Outer().new Inner_pub();  //直接创建的方法创建内部类
        Object io1 = new Outer().getInstance();   //用Object类接受内部类,实现多态
        System.out.println(io1);

    }
}
