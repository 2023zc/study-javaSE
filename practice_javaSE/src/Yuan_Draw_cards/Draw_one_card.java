package Yuan_Draw_cards;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Draw_one_card {
    private static Random random = new Random();
    private int Character;   //表示抽到的角色  1:5星角色 2:常驻角色 3:什么都没有

    public boolean Draw_ont_time(double possiblity) {  //可以自定义概率
        double ans = random.nextDouble(1);
        return ans >= possiblity;
    }

    private int Draw_card(int wai, int num) {
        double p = 0.6, ans;
        int finalans;
        if (num <= 73) {
            p = 0.6;
        } else if (num == 90) {
            p = 100;
        } else if (num > 73 && num <= 89) {
            p = p + (num - 73) * 6;
        }
        ans = random.nextDouble(1)*100;
        if (ans >= p) {
            finalans = 3;
        } else {
            if (wai == 1) {
                finalans = 1;
            } else {
                finalans = random.nextInt(2) + 1;
            }
        }
        return finalans;
    }

    public void Draw_ten_cards_print(int num, int x) {    //十连抽的函数,num表示进行10连抽的次数,x表示判断一次十连抽中抽出x个五星;
        int now_num = 0, ans, wai = 0, num_1 = 0, num_2 = 0, only_one_num_1 = 0, only_one_num_2 = 0;
        //储存一次10连抽抽到的5星限定角色和5星常驻角色的数量
        for (int i = 1; i <= num; i++) {
            now_num++;
            for (int j = 1; j <= 10; j++) {
                ans = Draw_card(wai, now_num);
                switch (ans) {
                    case 1:
                        num_1++;
                        now_num = 0;
                        wai = 0;
                        only_one_num_1++;
                        break;
                    case 2:
                        num_2++;
                        wai = 1;
                        now_num = 0;
                        only_one_num_2++;
                        break;
                    case 3:
                        now_num++;
                        break;
                }
            }
            if (only_one_num_1 + only_one_num_2 >= x) {
                System.out.println("--------------\n太好了!在第" + i + "次10连抽中成功了!\n--------------\n");
            }
            if (only_one_num_1 > 0 || only_one_num_2 > 0) {
                System.out.println("在第" + i + "次抽卡中成功抽出" + only_one_num_1 + "个5星限定角色," + only_one_num_2 + "个5星常驻角色!");
            }
            if(only_one_num_1==0&&only_one_num_2==0){
                System.out.println("在第" + i + "次抽卡中,什么都没抽到qwq");
            }
            only_one_num_1 = 0;
            only_one_num_2 = 0;
        }
        if (num_1 > 0 || num_2 > 0) {
            System.out.println("在" + num + "次抽卡中,你总共抽出" + num_1 + "个五星限定角色," + num_2 + "个五星常驻角色!");

        }
    }

    public int[][] Draw_ten_cards_ans(int num) {    //十连抽的函数,num表示进行10连抽的次数,x表示判断一次十连抽中抽出x个五星;
        int now_num = 0, ans, wai = 0, only_one_num_1 = 0, only_one_num_2 = 0;
        //储存一次10连抽抽到的5星限定角色和5星常驻角色的数量
        int[][] chou_ans=new int[num+1][2];
        for (int i = 1; i <= num; i++) {
            now_num++;
            for (int j = 1; j <= 10; j++) {
                ans = Draw_card(wai, now_num);
                switch (ans) {
                    case 1:
                        now_num = 0;
                        wai = 0;
                        only_one_num_1++;
                        break;
                    case 2:
                        wai = 1;
                        now_num = 0;
                        only_one_num_2++;
                        break;
                    case 3:
                        now_num++;
                        break;
                }
            }
            chou_ans[i][0]=only_one_num_1;
            chou_ans[i][1]=only_one_num_2;
            only_one_num_1 = 0;
            only_one_num_2 = 0;
        }
        return chou_ans;
    }
}