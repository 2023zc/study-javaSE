package javasepromax.Puzzlegame.gameUI;

import javax.swing.*;
import java.util.Random;

public class GameJFrame extends JFrame {   //游戏主界面

    int[][] picture = new int[4][4];

    public GameJFrame() {

        //初始化菜单
        initJMeunBar();
        //初始化数据
        initDate();
        //初始化图片
        initImagin();
        //初始化界面
        initJFrame();
    }

    //打乱数组
    private void initDate() {
        int[] temp = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        //打乱数组
        for (int i = 0; i < temp.length; i++) {
            //获取随机下标
            Random rand = new Random();
            int randindex = rand.nextInt(16);
            //交换对应下标的数字
            int tmp = temp[randindex];
            temp[randindex] = temp[i];
            temp[i] = tmp;
        }
        //将结果存进二维数组
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                this.picture[i][j] = temp[i * 4 + j];
            }
        }
    }

    //初始化图片
    private void initImagin() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                //创建ImaginIcon对象
                ImageIcon icon = new ImageIcon("C:\\Users\\asus\\Desktop\\java\\code\\study-javaSE\\practice_javaSE\\image\\animal\\animal3\\" + this.picture[i][j] + ".jpg");
                //创建JLabel(管理容器),并将图片添加到管理容器中
                JLabel label = new JLabel(icon);
                //设置图片位置
                label.setBounds(j * 105, i * 105, 105, 105);
                //添加图片到界面上
                this.getContentPane().add(label);
            }
        }
    }

    //初始化界面
    private void initJFrame() {
        //设置界面宽高
        this.setSize(603, 680);

        //设置页面标题
        this.setTitle("拼图单机版v1.0");
        //设置页面置顶
        this.setAlwaysOnTop(true);
        //设置页面居中
        this.setLocationRelativeTo(null);
        //设置程序的关闭模式
        this.setDefaultCloseOperation(3);
    }

    //初始化菜单
    private void initJMeunBar() {
        //初始化菜单
        //创建菜单条
        JMenuBar jMenuBar = new JMenuBar();
        //创建每个菜单(功能 , 关于我们)
        JMenu functionJmeun = new JMenu("功能");
        JMenu abloutJmeun = new JMenu("关于我们");

        //1.创建功能下的3个选项:(重新游戏，重新登录,关闭游戏)
        JMenuItem restartItem = new JMenuItem("重新游戏");
        JMenuItem reloginItem = new JMenuItem("重新登录");
        JMenuItem closegameItem = new JMenuItem("关闭游戏");

        //2.创建关于我们下面的菜单:(公众号)
        JMenuItem accountItem = new JMenuItem("公众号");

        //将选项添加到菜单下:
        functionJmeun.add(restartItem);
        functionJmeun.add(reloginItem);
        functionJmeun.add(closegameItem);

        abloutJmeun.add(accountItem);

        //将菜单添加到菜单条下:
        jMenuBar.add(functionJmeun);
        jMenuBar.add(abloutJmeun);

        //给界面设置菜单:
        this.setJMenuBar(jMenuBar);
        //取消默认布局，只有取消了才能按照XY轴的方式布局
        this.setLayout(null);
        //让界面显示出来
        this.setVisible(true);
    }


}
