package javasepromax.singleInstance;


/*
* 饿汉式单例模式:
* 在拿对象时，对象已经创建好了
* */
public class Hunger_Instance {
    //2.定义一个类变量，记住类的一个对象
    private static Hunger_Instance object =new Hunger_Instance();

    //1.私有类的构造器
    private Hunger_Instance(){ }

    //3.定义一个类的方法，返回类的对象
    public static Hunger_Instance getObject(){
        return object;
    }

    /*
    写对象的内容
     */

}
