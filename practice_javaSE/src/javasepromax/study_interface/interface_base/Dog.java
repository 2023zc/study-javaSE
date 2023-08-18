package javasepromax.study_interface.interface_base;

public class Dog extends Animal implements Swim {

    public Dog(String name, int age) {
        super(name, age);
    }

    public Dog() {
    }

    @Override
    public void eat() {
        System.out.println("狗在吃骨头");
    }

    @Override
    public void Swim() {
        System.out.println("狗在狗刨");
    }
}
