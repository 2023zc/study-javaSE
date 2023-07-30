package javasepromax.extend.extend_constructer;

public class this_construct {

    public static void main(String[] args) {
        student s=new student("小明",18);
        System.out.println(s.getName());
        System.out.println(s.getAge());
        System.out.println(s.getSchool());
    }
}
class student{   //需求:对于一个学生类，具有姓名,年龄,学校.需要我们在没填学校时，学校为东北大学
    private String name;
    private int age;
    private String school;

    public student(String name,int age){
        this(name,age,"东北大学");
    }

    public student() {
    }

    public student(String name, int age, String school) {
        this.name = name;
        this.age = age;
        this.school = school;
    }

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

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}
