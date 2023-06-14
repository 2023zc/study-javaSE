package classical_cases;


import java.text.NumberFormat;
import java.util.*;

public class Dual_Colors_Balls {
    static Random random = new Random();
    static Scanner cin = new Scanner(System.in);
    static int score_6 = 0, score_5 = 0, score_4 = 0, score_3 = 0, score_2 = 0, score_1 = 0, score_0 = 0;
    static NumberFormat nf = NumberFormat.getNumberInstance();

    public static int[] creatlucknum() {   //生成中奖号码
        int[] lucknum = new int[7];
        int flag;
        for (int i = 0; i < lucknum.length; i++) {
            //保证前六个红球数字1~33且不重复
            if (i != 6) {
                while (true) {
                    flag = 1;
                    lucknum[i] = random.nextInt(33) + 1;
                    for (int i1 = 0; i1 < i; i1++) {
                        if (lucknum[i] == lucknum[i1]) {
                            flag = 0;
                            break;
                        }
                    }
                    if (flag == 1) {
                        break;
                    }
                }
            } else {
                //最后一个蓝球1~16
                lucknum[i] = random.nextInt(16) + 1;
            }
        }
        return lucknum;
    }

    public static int[] your_num() {   //用户输入它的号码
        int[] numarr = new int[7];
        System.out.println("请输入你的六个红球号码(1-33,且不重复):");
        for (int i = 0; i < numarr.length - 1; i++) {
            numarr[i] = cin.nextInt();
        }
        System.out.println("请输入你的一个蓝球号码(1-16):");
        numarr[numarr.length - 1] = cin.nextInt();
        return numarr;
    }

    public static void print(int[] nums) {  //输出号码
        for (int i = 0; i < nums.length; i++) {
            System.out.print(i == nums.length - 1 ? (nums[i] + "\n") : (nums[i] + " "));
        }
    }

    public static void print_ball(List<Integer> redballs, List<Integer> blueball) {
        System.out.println("中奖红球号码为:");
        if (!redballs.isEmpty()) {
            for (int i = 0; i < redballs.size() - 1; i++) {
                System.out.println(i == redballs.size() - 1 ? (redballs.get(i) + "\n") : (redballs.get(i) + " "));
            }
        } else {
            System.out.println("你没有红球中奖.");
        }
        if (!blueball.isEmpty()) {
            if (!blueball.isEmpty()) {
                System.out.println("你中间的蓝球号码为:");
                for (int i = 0; i < blueball.size(); i++) {
                    System.out.println(i == blueball.size() - 1 ? (blueball.get(i) + "\n") : (blueball.get(i) + " "));
                }
            }
        } else {
            System.out.println("你没有蓝球中奖.");
        }
    }

    public static void check(int[] lucknum, int[] coustome_num) {
        int num_red = 0, num_blue = 0;
        List<Integer> redballs = new ArrayList<>(), blueball = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (lucknum[i] == coustome_num[j]) {
                    num_red++;
                    redballs.add(lucknum[i]);
                }
            }
        }
        if (lucknum[6] == coustome_num[6]) {
            num_blue = 1;
            blueball.add(lucknum[6]);
        }
        if (num_red <= 1 && num_blue == 1) {
//            System.out.println("恭喜你,你中了5元小奖(六等奖)!");
//            print_ball(redballs,blueball);
            score_6++;
        } else if (((num_red <= 3 && num_red >= 2) && num_blue == 1) || (num_red == 4 && num_blue == 0)) {
//            System.out.println("恭喜你,你中了10元小奖(五等奖)!");
//            print_ball(redballs,blueball);
            score_5++;
        } else if ((num_red == 4 && num_blue == 1) || (num_red == 5 && num_blue == 0)) {
//            System.out.println("恭喜你,你中了200元奖金(四等奖)!");
//            print_ball(redballs,blueball);
            score_4++;
        } else if (num_red == 5 && num_blue == 0) {
//            System.out.println("恭喜你,你中了3000元大奖(三等奖)!");
//            print_ball(redballs,blueball);
            score_3++;
        } else if (num_red == 6 && num_blue == 0) {
//            System.out.println("恭喜你,你中了最高500万的二等奖!");
//            print_ball(redballs,blueball);
            score_2++;
        } else if (num_red == 7 && num_blue == 1) {
//            System.out.println("恭喜你,你中了最高1000王的特等奖!");
//            print_ball(redballs,blueball);
            score_1++;
        } else {
//            System.out.println("抱歉，你没有中奖,欢迎下次光临!");
            score_0++;
        }
    }

    public static void printans(int n) {    //通过模拟抽球来计算在n次抽球中每种情况的概率
        System.out.println("在" + n + "次实验中:");
        double ans6 = score_6 / (n * 1.0), ans5 = score_5 / (n * 1.0), ans4 = score_4 / (n * 1.0), ans3 = score_3 / (n * 1.0), ans2 = score_2 / (n * 1.0), ans1 = score_1 / (n * 1.0), ans0 = score_0 / (n * 1.0);
        System.out.println("用户中六等奖的概率为:" + nf.format(ans6));
        System.out.println("用户中五等奖的概率为:" + nf.format(ans5));
        System.out.println("用户中四等奖的概率为:" + nf.format(ans4));
        System.out.println("用户中三等奖的概率为:" + nf.format(ans3));
        System.out.println("用户中二等奖的概率为:" + nf.format(ans2));
        System.out.println("用户中一等奖的概率为:" + nf.format(ans1));
        System.out.println("用户没中奖的概率为:" + nf.format(ans0));
    }

    public static void main(String[] args) {
        nf.setMaximumFractionDigits(8);   //保留8位小数
        int n;
        n = cin.nextInt();
        for (int i = 1; i <= n; i++) {
            int[] lucknum = creatlucknum().clone();   //生成中奖号码
            int[] coustome_num = creatlucknum().clone();
            check(lucknum, coustome_num);
//            System.out.println("本期中奖号码是:");
//            print(lucknum);
//            System.out.println("你的号码是:");
//            print(coustome_num);
        }
        printans(n);
    }
}
