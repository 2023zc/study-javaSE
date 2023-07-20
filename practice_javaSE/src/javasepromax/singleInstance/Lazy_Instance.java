package javasepromax.singleInstance;

public class Lazy_Instance {
    //2.定义一个类对象用于存储对象
    private static Lazy_Instance object;   //不能直接=new Lazy_Instance()因为这样就直接创造了对象了
    //1.将构造器私有化
    private Lazy_Instance(){ }

    //3.定义一个类方法，保证返回同一个对象
    public static Lazy_Instance getObject(){
        if(object==null){
            object=new Lazy_Instance();
        }
        return object;
    }

}
