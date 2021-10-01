public class SavingAccount extends Account{
    public SavingAccount(int id, int money, MyDate myDate, TransAction[] transActions) {
        super(id, money, myDate, transActions);
    }

    public SavingAccount(int id, int money, MyDate myDate) {
        super(id, money, myDate);
    }

    public SavingAccount() {

    }

    @Override
    public void calculateInterest() {
        double monthperfit = 0.1;
        double temp= getAccountMoney()* monthperfit;
        setAccountMoney(temp);
        addCurrentTransAction(temp,TransActionType.INTREST);

        System.out.println(" interest : "+temp);
    }
}
