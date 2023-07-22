package javasepromax.study_final;

public class test {
    //3.修饰变量，变量有且仅能赋值一次
    public static final double PI=3.1415926;
    /*用static final修饰的成员变量为常量
    *常量命名规则:名称全部大写，多个单词用下划线连接,例如:PI,SCHOOL_NAME
     */
    public static void main(String[] args) {
        //3.修饰变量，变量有且仅能赋值一次
        //Pi=0;  //2次赋值会报错
        final int a=0;
        //a=1;  //报错，有且仅能赋值一次


        final int[] arr={1,2,3};  //地址不能变，但内容可以改变
        arr[0]=2;  //可以改变内容

    }
}
//1.修饰类,为最终类，不会被继承
final class A{

}
//class B extends Abstract_Class{    //B不可以继承A,因为A为最终类
//}
class C{
    public final void printname(){
        System.out.println("C");
    }
}
class D extends C{
    //2.修饰方法,方法不能被重写
//    public void printname(){
//        System.out.println("D");
//    }
}
