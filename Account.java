import java.util.Arrays;

public class Account {
    private int id;
    private int numberaccount;
    private double accountMoney;
    private MyDate myDate;
    int indexTransAction;
    private KindOfAccount kindOfAccount;
    TransAction[] transActions = new TransAction[100];
    private TransActionType transActionType;

    public Account(int id, double money, MyDate myDate, TransAction[] transActions) {
        this.id = id;
        this.accountMoney = money;
        this.myDate = myDate;
        this.transActions = transActions;
    }

    public Account(int id, double money, MyDate myDate) {
        this.id = id;
        this.accountMoney = money;
        this.myDate = myDate;
    }

    public Account() {
        for (int i = 0; i < 100; i++) {
            transActions[i] = new TransAction();
        }
    }

    public TransActionType getTransActionType() {
        return transActionType;
    }

    public void setTransActionType(TransActionType transActionType) {
        this.transActionType = transActionType;
    }

    public MyDate getMyDate() {
        return myDate;
    }

    public void setMyDate(MyDate myDate) {
        this.myDate = myDate;
    }

    public KindOfAccount getKindOfAccount() {
        return kindOfAccount;
    }

    public void setKindOfAccount(KindOfAccount kindOfAccount) {
        this.kindOfAccount = kindOfAccount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberaccount() {
        return numberaccount;
    }

    public void setNumberaccount(int numberaccount) {
        this.numberaccount = numberaccount;
    }

    public double getAccountMoney() {
        return accountMoney;
    }

    public void setAccountMoney(double accountMoney) {
        this.accountMoney = accountMoney;
    }

    public int getIndexTransAction() {
        return indexTransAction;
    }

    public void setIndexTransAction(int indexTransAction) {
        this.indexTransAction = indexTransAction;
    }

    public TransAction[] getTransActions() {
        return transActions;
    }

    public void setTransActions(TransAction[] transActions) {
        this.transActions = transActions;
    }

    public void withDraw(double withdrMoney, int year, int month, int day) {


        if (accountMoney < withdrMoney) {
            System.out.println("dont have enough money");
        } else {
            double temp = accountMoney - withdrMoney;
            accountMoney = temp;
            addCurrentTransAction(withdrMoney, TransActionType.WITHDRAW);
            System.out.println("your balance is : " + accountMoney);
        }
    }

    public void addCurrentTransAction(double temp, TransActionType type) {

        for (int i = 0; i < indexTransAction; i++) {
            transActions[i] = new TransAction(type, temp);
        }
    }


    public void deposit(double depositMoney, int year, int month, int day) {
        double temp = accountMoney + depositMoney;
        accountMoney = temp;
        System.out.println("your balance is : " + accountMoney);
        addCurrentTransAction(temp, TransActionType.DEPOSIT);
    }

    public void calculateInterest() {
    }

    @Override
    public String toString() {
        return "Account{" +
                "transActions=" + Arrays.toString(transActions) +
                '}';
    }
}
