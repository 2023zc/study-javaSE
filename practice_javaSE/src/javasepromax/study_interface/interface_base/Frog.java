package javasepromax.study_interface.interface_base;

public class Frog extends Animal implements Swim {
    public Frog(String name, int age) {
        super(name, age);
    }

    public Frog() {
    }

    @Override
    public void eat() {
        System.out.println("青蛙在吃虫子");
    }

    @Override
    public void Swim() {
        System.out.println("青蛙在游泳");
    }
}
