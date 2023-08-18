package javasepromax.Puzzlegame.gameUI;

import javax.swing.*;

public class LoginJFrame extends JFrame {   //游戏登录界面
    public LoginJFrame() {
        //设置界面宽高
        this.setSize(488, 433);

        //设置页面标题
        this.setTitle("登录");
        //设置页面置顶
        this.setAlwaysOnTop(true);
        //设置页面居中
        this.setLocationRelativeTo(null);
        //设置程序的关闭模式
        this.setDefaultCloseOperation(3);

        //设置界面显示
        this.setVisible(true);
    }
}
