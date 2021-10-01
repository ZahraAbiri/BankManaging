public class LoanAccount extends Account{
private int loanTerm;
private double interest;
private double loanMony;

    public LoanAccount() {

    }

    public double getLoanMony() {
        return loanMony;
    }

    public void setLoanMony(double loanMony) {
        this.loanMony = loanMony;
    }

    public int getLoanTerm() {
        return loanTerm;
    }

    public void setLoanTerm(int loanTerm) {
        this.loanTerm = loanTerm;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public LoanAccount(int id, int money, MyDate myDate, TransAction[] transActions, int loanTerm, double interest) {
        super(id, money, myDate, transActions);
        this.loanTerm = loanTerm;
        this.interest = interest;
    }

    @Override
    public void calculateInterest() {
        double temp=0.5*getAccountMoney();
        setAccountMoney((int) (temp+loanMony));
        addCurrentTransAction(temp,TransActionType.INTREST);
        System.out.println("interest : "+temp);
    }
}
