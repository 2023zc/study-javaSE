package ATM_system;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ATM {
    private static Random rand=new Random();
    private static Scanner cin=new Scanner(System.in);
    private ArrayList<Account> account_List=new ArrayList<>();
    private void print_startmeun(){
        System.out.println("欢迎来到银行ATM系统:-----------------");
        System.out.println("1-用户登录");
        System.out.println("2-用户开户");
        System.out.println("请输入你操作的命令:");
    }
    private void print_logmeun(Account account){
        System.out.println("============" + account.getOwner_name() + ",你可办理以下业务:============");
        System.out.println("1-查询账户");
        System.out.println("2-存款");
        System.out.println("3-取款");
        System.out.println("4-转帐");
        System.out.println("5-修改密码");
        System.out.println("6-退出");
        System.out.println("7-注销账户");
        System.out.println("请选择:");
    }
    private boolean check_password(String password){    //检查密码是否合法
        char str;
        for(int i=0;i<password.length();i++){
            str=password.charAt(i);
            if(str<'0'||str>'9'){
                return false;
            }
        }
        return true;
    }
    private int check_ID(String ID){   //检查当前账户列表中是否有这个卡号,返回对应账户的下标
        for(int i=0;i<account_List.size();i++){
            if(account_List.get(i).getCreadit_ID().equals(ID)){
                return i;
            }
        }
        return -1;
    }
    private double to_num(String str){
        double ans=0;
        char a;
        for(int i=0;i<str.length();i++){
            a=str.charAt(i);
            ans+=((a-'0')*Math.pow(10,str.length()-i-1));
        }
        return ans;
    }
    private String creatID(){   //生成卡号
        StringBuilder ID=new StringBuilder();
        for(int i=0;i<7;i++){
            int num= rand.nextInt(10);
            ID.append(num);
        }
        return ID.toString();
    }
    private void creatAccount(){   //用户开户
        Account new_accout=new Account();
        double withdraw_limit;
        String name,password,tmp,sex,creadit_ID;
        System.out.println("============用户开户操作============");
        System.out.println("请输入你的账户用户名:");
        name=cin.next();
        new_accout.setOwner_name(name);
        System.out.println("请输入你的性别(男/女):");
        while (true){
            sex=cin.next();
            if(!sex.equals("男")&&!sex.equals("女")){
                System.out.println("输入的性别有误，请重新输入!");
                continue;
            }
            break;
        }
        new_accout.setSex(sex);
        while (true){
            System.out.println("请输入你的用户密码:");
            password=cin.next();
            if(!check_password(password)){
                System.out.println("密码含有非法字符!");
                continue;
            }
            System.out.println("请确认你的密码:");
            tmp=cin.next();
            if(!password.equals(tmp)){
                System.out.println("两次输入的密码有误，请重新输入:");
                continue;
            }
            new_accout.setPassword(password);
            break;
        }
        System.out.println("请输入你的取款额度:");
        withdraw_limit=cin.nextInt();
        new_accout.setWithdrawal_limit(withdraw_limit);

        creadit_ID=creatID();
        new_accout.setCreadit_ID(creadit_ID);
        account_List.add(new_accout);
        System.out.println("恭喜你,"+new_accout.getOwner_name()+",你开户成功,您的卡号是:"+new_accout.getCreadit_ID()+",请妥善保管你的银行卡!");

    }

    private Account logAccount(){
        int index;
        String creadit_ID,password;
        Account target_account=new Account();
        if(account_List.size()==0){
            System.out.println("当前系统下还无账户,快去开户吧!");
            return target_account;
        }
        while (true){
            System.out.println("请输入登录卡号:");
            creadit_ID=cin.next();
            index=check_ID(creadit_ID);
            if(index==-1){
                System.out.println("系统中不存在该账户卡号!");
                continue;
            }
            break;
        }
        target_account=account_List.get(index);
        while(true){
            System.out.println("请输入登录密码:");
            password=cin.next();
            if(!password.equals(target_account.getPassword())){
                System.out.println("密码输入有误,请重新输入:");
                continue;
            }
            break;
        }
        System.out.println("恭喜你,"+target_account.getOwner_name()+",你已进入系统,你的卡号是:"+target_account.getCreadit_ID());
        return target_account;
    }
    private void deposit(Account account){   //存款
        String num;
        System.out.println("============用户存钱操作============");
        while(true){
            System.out.println("请输入你的存款金额:");
            num=cin.next();
            if(!check_password(num)){
                System.out.println("你的存款金额输入有误,请重新输入:");
                continue;
            }
            break;
        }
        account.setRemain_money(account.getRemain_money()+to_num(num));
        System.out.println("恭喜你,存款成功,当前账户信息如下:");
        account.display();
    }
    private void withdraw(Account account){   //取款
        String num;
        System.out.println("============用户取款操作============");
        while (true){
            System.out.println("请输入取款金额:");
            num=cin.next();
            if(!check_password(num)){
                System.out.println("取款金额输入有误,请重新输入:");
                continue;
            }
            else if(to_num(num)>account.getWithdrawal_limit()){
                System.out.println("你当前取款金额超过取款限额,请重新输入:");
                continue;
            }
            else if(to_num(num)>account.getRemain_money()){
                System.out.println("你当前取款金额超过现有余额,请重新输入:");
                continue;
            }
            break;
        }
        account.setRemain_money(account.getRemain_money()-to_num(num));
        System.out.println("恭喜你,取钱" + to_num(num) + "成功!以下为当前账户信息:");
        account.display();
    }
    private void change_password(Account account){
        System.out.println("============修改密码操作============");
        String now_password,changed_password,tmp;
        while(true){
            System.out.println("请输入当前密码:");
            now_password=cin.next();
            if(!now_password.equals(account.getPassword())){
                System.out.println("当前密码输入有误,请重新输入:");
                continue;
            }
            break;
        }
        while (true){
            System.out.println("请输入更改后的密码:");
            changed_password=cin.next();
            if(!check_password(changed_password)){
                System.out.println("输入的密码包含非法符号,请重新输入:");
                continue;
            }
            break;
        }
        while(true){
            System.out.println("请确定密码:");
            tmp=cin.next();
            if(!tmp.equals(changed_password)){
                System.out.println("两次密码输入不同,请重新输入:");
                continue;
            }
            break;
        }
        account.setPassword(changed_password);
        System.out.println("恭喜你,密码更改成功!");
    }
    private boolean log_off(Account account){
        System.out.println("=============账户注销操作=============");
        String op;
        while(true){
            System.out.println("你真的要销户吗?y/n");
            op=cin.next();
            if(op.equals("y")){
                if(account.getRemain_money()>0){
                    System.out.println("账户里有余额,还不可以销户!");
                }
                else{
                    account_List.remove(account);
                    System.out.println("您的账户销户成功!");
                    return true;
                }
            }
            else if(op.equals("n")){
                System.out.println("你的账户会继续保存!");
                return false;
            }
            else{
                System.out.println("输入有误,请重新输入!");
                continue;
            }
            break;
        }
        return false;
    }
    private void transfer_accounts(Account account){
        String creadit_ID,name,changed_name,money;
        Account target_account;
        char first_name;
        int index;
        System.out.println("============用户转账操作============");
        if(account_List.size()<2){
            System.out.println("当前账户列表的账户数量少于两个账户,快去开户吧!");
            return;
        }
        while (true){
            System.out.println("请输入对方的卡号:");
            creadit_ID=cin.next();
            index=check_ID(creadit_ID);
            if(index==-1){
                System.out.println("当前系统中没有该账户!");
                continue;
            }
            name=account_List.get(index).getOwner_name();
            changed_name=name.replace(name.charAt(0),'*');
            System.out.println("请输入[" + changed_name + "]的姓氏:");
            first_name=cin.next().charAt(0);
            if(!(first_name==name.charAt(0))){
                System.out.println("您输入的信息有误!");
                continue;
            }
            break;
        }
        target_account=account_List.get(index);
        while (true){
            System.out.println("请输入转账金额:");
            money=cin.next();
            if(!check_password(money)){
                System.out.println("输入有误,请重新输入:");
                continue;
            }
            else if(to_num(money)>account.getRemain_money()){
                System.out.println("转账金额超出您的当前余额,你最多可以转"+account.getRemain_money()+"元,请重新输入:");
                continue;
            }
            break;
        }
        account.setRemain_money(account.getRemain_money()-to_num(money));
        target_account.setRemain_money(to_num(money)+target_account.getRemain_money());
        System.out.println("转账成功,你的账户还剩"+account.getRemain_money()+"元");
    }
    public void start() {
        Account target_account;
        while (true){
            print_startmeun();
            int op=cin.nextInt();
            switch (op){
                case 1:
                    target_account=logAccount();
                    if(target_account.getCreadit_ID()==null){
                        break;
                    }
                    log_meun(target_account);
                    break;
                case 2:
                    creatAccount();   //用户开户
                    break;
                default:
                    System.out.println("输入有误,请重新输入:");
            }
        }
    }
    private void log_meun(Account account){
        System.out.println("==============系统登录操作==============");
        int op,flag=0;
        while (true) {
            print_logmeun(account);
            op = cin.nextInt();
            switch (op) {
                case 1:   //查询账户
                    account.display();
                    break;
                case 2:   //存款
                    deposit(account);
                    break;
                case 3:  //取款
                    withdraw(account);
                    break;
                case 4:  //转账
                    transfer_accounts(account);
                    break;
                case 5:  //修改密码
                    change_password(account);
                    break;
                case 6:  //退出
                    flag = 1;
                    break;
                case 7:  //注销账户
                    if(log_off(account)){
                        flag=1;
                    }
                    break;
                default:
                    System.out.println("输入有误,请重新输入:");

            }
            if (flag == 1) {
                break;
            }
        }
    }
}
