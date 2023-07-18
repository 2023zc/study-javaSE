package Object;

import java.util.ArrayList;
import java.util.Scanner;

public class FoodOperation {
    static Scanner cin=new Scanner(System.in);
    private ArrayList<Food> Foodmeun;
    public FoodOperation(){
        Foodmeun=new ArrayList<>();
    }
    public void adddFood(){
        Food new_food=new Food();
        String food_name,food_des;
        Double food_price;
        System.out.println("请输入菜品名称:");
        food_name=cin.next();
        new_food.setName(food_name);
        System.out.println("请输入菜品价格:");
        food_price=cin.nextDouble();
        new_food.setPrice(food_price);
        System.out.println("请输入菜品描述信息:");
        food_des=cin.next();
        new_food.setDescreption(food_des);
        Foodmeun.add(new_food);
        System.out.println("菜品添加成功!");
    }
    public void display(){
        System.out.println("以下是现有的菜品信息:");
        System.out.println("------------------------------------");
        for (int i = 0; i < Foodmeun.size(); i++) {
            System.out.println("名称:"+Foodmeun.get(i).getName()+"\t"+"价格:"+Foodmeun.get(i).getPrice());
            System.out.println("描述:" + Foodmeun.get(i).getDescreption());
            System.out.println("------------------------------------");
        }
    }
    public void showmeun(){
        int op;
        System.out.println("请选择功能:");
        while(true){
            System.out.println("1-上架菜品"+"\t"+"2-展示信息"+"\t"+"3-退出系统");
            op=cin.nextInt();
            switch (op){
                case 1:
                    adddFood();
                    break;
                case 2:
                    display();
                    break;
                case 3:
                    System.out.println("欢迎下次使用!");
                    return;
                default:
                    System.out.println("输入有误!请重新输入:");
            }
        }
    }
}
