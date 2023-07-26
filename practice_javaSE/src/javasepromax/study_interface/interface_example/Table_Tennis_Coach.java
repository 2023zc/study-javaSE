package javasepromax.study_interface.interface_example;

public class Table_Tennis_Coach extends Coach implements Speak_English {
    public Table_Tennis_Coach() {
    }

    public Table_Tennis_Coach(String name, int age) {
        super(name, age);
    }

    @Override
    public void teach() {
        System.out.println("乒乓球教练会教打乒乓球");
    }

    @Override
    public void Speak_English() {
        System.out.println("乒乓球运动员会说英语");
    }

}
