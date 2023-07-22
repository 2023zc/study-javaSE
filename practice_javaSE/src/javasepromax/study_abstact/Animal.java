package javasepromax.study_abstact;
//抽象类
public abstract class Animal {
    private String name;

    public abstract void cry();   //抽象方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
