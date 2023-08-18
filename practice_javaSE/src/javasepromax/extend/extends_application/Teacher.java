package javasepromax.extend.extends_application;

public class Teacher extends People {
    private String skill;

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public void printInfo() {   //打印老师信息
        System.out.println("名字:" + getName());
        System.out.println("技能:" + skill);
    }
}
