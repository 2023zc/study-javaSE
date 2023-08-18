package javasepromax.study_enum.caese;

public class book_store {

    public static void main(String[] args) {
        check(Constants.BOY);
    }


    static void check(Constants s) {
        switch (s) {   //设计成枚举可以更加方便的书写分支，传递信息
            case BOY:
                System.out.println("美女图书~~~");
                break;
            case GIRL:
                System.out.println("帅哥图片~~~");
                break;
        }

    }
}
