package javasepromax.study_Inner_object;

public class Outer {
    int age;
    String name;

    private class Inner_pri {  //私有的内部类不可以在外部直接访问，只能写方法获取
        String color;
    }

    public class Inner_pub {  //公有的可直接创建
        String hobby;
    }


    public Inner_pri getInstance() {
        return new Inner_pri();
    }
}
