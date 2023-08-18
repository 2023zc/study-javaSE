package javasepromax.study_interface;

import java.awt.event.ActionListener;

public class Interip1 implements Inter {

    @Override
    public void show() {
        System.out.println("你好");
    }

    public void me(ActionListener e) {

    }

    public static void main(String[] args) {
        Interip1 n = new Interip1();
        n.method();
    }
}

