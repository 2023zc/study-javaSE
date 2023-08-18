package javasepromax.polymorphism;


class people {
    public void printname() {
        System.out.println("人");
    }
}

class student extends people {
    @Override
    public void printname() {
        System.out.println("学生");
    }

    public void test() {
        System.out.println("学生需要考试");
    }
}

class teacher extends people {
    @Override
    public void printname() {
        System.out.println("老师");
    }

    public void teach() {
        System.out.println("老师需要教书");
    }
}

public class study_instanceof {
    public static void main(String[] args) {
        people a1 = new student();
        people a2 = new teacher();
        go(a1);
        go(a2);
    }

    public static void go(people p) {
        if (p instanceof student) {
            student s1 = (student) p;
            s1.printname();
            s1.test();
        } else if (p instanceof teacher) {   //需要添加instanceof判断对象的真实对象是什么再进行强制转换
            teacher s2 = (teacher) p;
            s2.printname();
            s2.teach();
        }
    }
}
