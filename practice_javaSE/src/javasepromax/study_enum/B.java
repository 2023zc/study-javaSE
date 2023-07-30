package javasepromax.study_enum;
//抽象枚举
public enum  B {
    AA("小明"){
        @Override
        public void test() {
            //方法体
        }
    },
    BB("小花"){    //因为有抽象方法，所以在创建对象时必须重写抽象方法
        @Override
        public void test() {
            //方法体
        }
    };
    private String name;

    B() {
    }

    B(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void test();
}
