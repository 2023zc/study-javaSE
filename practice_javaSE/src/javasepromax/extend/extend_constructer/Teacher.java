package javasepromax.extend.extend_constructer;


public class Teacher extends People {
    private String skill;

    public Teacher(String name, int age, String skill) {   //调用父类的有参构造器完成构造,如果直接用this.name=name这样会报错
        super(name, age);
        this.skill = skill;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    @Override  //重写toString方法
    public String toString() {
        return "Teacher{" +
                "name='" + getName() + '\'' +
                "age='" + getAge() + '\'' +
                "skill='" + skill + '\'' +
                '}';
    }
}
