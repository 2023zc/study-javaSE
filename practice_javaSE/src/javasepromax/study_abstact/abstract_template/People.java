package javasepromax.study_abstact.abstract_template;

public abstract class People {
    public final void write() {  //用final修饰，防止子类重写
        System.out.println("第一段都一样,随便写写就行了");   //相同的代码丢进去
        System.out.println(writemain());
        System.out.println("最后一段也一样，随便写写就行了");
    }

    public abstract String writemain();  //不同的代码设计成抽象类
}
