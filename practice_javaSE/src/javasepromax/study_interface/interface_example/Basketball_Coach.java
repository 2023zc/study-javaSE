package javasepromax.study_interface.interface_example;

public class Basketball_Coach extends Coach {
    public Basketball_Coach() {
    }

    public Basketball_Coach(String name, int age) {
        super(name, age);
    }

    @Override
    public void teach() {
        System.out.println("篮球教练会教打篮球");
    }
}
