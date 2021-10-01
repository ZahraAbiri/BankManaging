public class TransAction {
MyDate myDate;
TransActionType transActionType;
private double amount;

    public TransAction(MyDate myDate, TransActionType transActionType, double amount) {
        this.myDate = myDate;
        this.transActionType = transActionType;
        this.amount = amount;
    }

    public TransAction(TransActionType transActionType, double amount) {
        this.transActionType = transActionType;
        this.amount = amount;
    }

    public TransAction() {

    }

    public MyDate getMyDate() {
        return myDate;
    }

    public void setMyDate(MyDate myDate) {
        this.myDate = myDate;
    }

    public TransActionType getTransActionType() {
        return transActionType;
    }

    public void setTransActionType(TransActionType transActionType) {
        this.transActionType = transActionType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    public void print(){
        System.out.println(myDate.toString()+" , "+transActionType+" , "+amount);
    }
}
