package javasepromax.study_interface.interface_base;



public class test_interface {
    public static void main(String[] args) {
        //狗的对象
        Dog d=new Dog("狗狗",18);
        d.eat();
        d.Swim();
        //青蛙的对象
        Frog f=new Frog("小青",1);
        f.eat();
        f.Swim();
        //兔子的对象
        Rabbit r=new Rabbit("小白",2);
        r.eat();
    }

}
