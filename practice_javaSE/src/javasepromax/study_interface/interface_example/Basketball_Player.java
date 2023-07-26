package javasepromax.study_interface.interface_example;

public class Basketball_Player extends Player{

    public Basketball_Player() {
    }

    public Basketball_Player(String name, int age) {
        super(name, age);
    }

    @Override
    public void study() {
        System.out.println("篮球运动员学习篮球");
    }
}
