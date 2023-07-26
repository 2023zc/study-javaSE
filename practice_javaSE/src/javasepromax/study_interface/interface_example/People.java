package javasepromax.study_interface.interface_example;

//因为在实例化一个人类是没有意义的，所以直接写成抽象类
public abstract class People {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public People() {
    }

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

}
