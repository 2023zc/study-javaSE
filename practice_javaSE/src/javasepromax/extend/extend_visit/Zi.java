package javasepromax.extend.extend_visit;

public class Zi extends Fu {   //子类继承父类
    private String name = "子类名称";

    public void test() {
        String name = "局部名称";
        System.out.println(name);  //局部变量的名字
        System.out.println(this.name);  //子类的名字
        System.out.println(super.getName());   //父类的名字

        this.print();  //子类的方法
        super.print();  //父类的方法

        /*
        可通过super关键字来访问父类的方法/
         */
    }

    @Override
    public void print() {
        System.out.println("子类方法");
    }

}
