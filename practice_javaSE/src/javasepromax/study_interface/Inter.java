package javasepromax.study_interface;


public interface Inter {
    public void show();

    public default void method(){
        math();
    }

    private static void math(){
        System.out.println("静态方法");
    }


}
