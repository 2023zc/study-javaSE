package javasepromax.study_interface.interface_example;

public abstract class Coach extends People {
    public Coach() {
    }

    public Coach(String name, int age) {
        super(name, age);
    }

    public abstract void teach();
}
