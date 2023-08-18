package ATM_system;

public class Account {
    private String creadit_ID;
    private String owner_name;
    private String sex;
    private double remain_money;
    private double withdrawal_limit;
    private String password;

    public Account() {
    }

    public String getCreadit_ID() {
        return creadit_ID;
    }

    public void setCreadit_ID(String creadit_ID) {
        this.creadit_ID = creadit_ID;
    }

    public String getOwner_name() {
        return owner_name;
    }

    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public double getRemain_money() {
        return remain_money;
    }

    public void setRemain_money(double remain_money) {
        this.remain_money = remain_money;
    }

    public double getWithdrawal_limit() {
        return withdrawal_limit;
    }

    public void setWithdrawal_limit(double withdrawal_limit) {
        this.withdrawal_limit = withdrawal_limit;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void display() {
        System.out.println("============当前账户信息如下============");
        System.out.println("卡号:" + this.getCreadit_ID());
        System.out.println("户主:" + this.getOwner_name());
        System.out.println("余额:" + this.getRemain_money());
        System.out.println("限额:" + this.getWithdrawal_limit());
    }
}
