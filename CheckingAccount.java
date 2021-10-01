public class CheckingAccount extends Account{

    public CheckingAccount(int id, double money, MyDate myDate, TransAction[] transActions) {
        super(id, money, myDate, transActions);
    }
    public CheckingAccount() {
    }
    public void withDraw(double withdrMoney,int year, int month, int day) {
        int withdrawlimit = 2000000;
        if(withdrMoney< withdrawlimit){
            super.withDraw(withdrMoney,year,month,day);
            addCurrentTransAction(withdrMoney,TransActionType.WITHDRAW);
        }else {
            System.out.println("you can withdraw less than 2,000,000");
        }
    }
    public void calculateInterest() {
        double temp=0.6*getAccountMoney();
        setAccountMoney((int) (temp+getAccountMoney()));
        addCurrentTransAction(temp,TransActionType.INTREST);
        System.out.println("interest : "+temp);
    }
}
