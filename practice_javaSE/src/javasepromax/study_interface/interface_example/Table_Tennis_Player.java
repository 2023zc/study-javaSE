package javasepromax.study_interface.interface_example;

public class Table_Tennis_Player extends Player implements Speak_English {
    public Table_Tennis_Player() {
    }

    public Table_Tennis_Player(String name, int age) {
        super(name, age);
    }

    @Override
    public void study() {
        System.out.println("乒乓球运动员学习乒乓球");
    }

    @Override
    public void Speak_English() {
        System.out.println("乒乓球运动员会说英语");
    }
}
