import java.util.Arrays;

public class Bank {
    Customer[] customer = new Customer[100];
    MyDate[] myDate = new MyDate[100000];
    int indexofCustomer = 0;
    int indexofDate = 0;
    int index;

    public Bank() {
        for (int i = 0; i < 100; i++) {
            customer[i] = new Customer();
        }
        for (int i = 0; i < 100000; i++) {
            myDate[i] = new MyDate();
        }

    }

    public int makeRandomNumber() {
        int numberAccount = 100000;
        int result = 0;
        for (int i = 0; i < 5; i++) {
            result = (int) (Math.random() * numberAccount);
        }
        return result;

    }


    public void addAccount(String name, int money, int year, int month, int day, KindOfAccount kindAcoount) {
        if (indexofCustomer != 0) {
            for (int i = 0; i < indexofCustomer; i++) {
                if (!customer[indexofCustomer - 1].getName().equals(name)) {
                    addCustomer(name, money, year, month, day, kindAcoount);
                    break;
                } else {
                    indexofCustomer = indexofCustomer - 1;
                    customerAccount(money, year, month, day, kindAcoount);
                }
            }
        } else {
            addCustomer(name, money, year, month, day, kindAcoount);
        }

    }


    public void addCustomer(String name, int money, int year, int month, int day, KindOfAccount kindAcoount) {
        index = customer[indexofCustomer].lastIndex;

        customer[indexofCustomer].setName(name);
        customerAccount(money, year, month, day, kindAcoount);
    }

    private void customerAccount(int money, int year, int month, int day, KindOfAccount kindAcoount) {
        switch (kindAcoount.getShortcut()) {
            case 0:
                customer[indexofCustomer].account[index] = new CheckingAccount();
                break;
            case 1:
                customer[indexofCustomer].account[index] = new SavingAccount();
                break;
            case 2:
                customer[indexofCustomer].account[index] = new LoanAccount();
                break;
        }
        customer[indexofCustomer].account[index].setNumberaccount(1000000 + makeRandomNumber());
        customer[indexofCustomer].account[index].setAccountMoney(money);
        customer[indexofCustomer].account[index].setKindOfAccount(kindAcoount);
        customer[indexofCustomer].account[index].setMyDate(new MyDate(year, month, day));
        System.out.println("name : " + customer[indexofCustomer].getName() +
                " , " + "kind of account : " + customer[indexofCustomer].account[index].getKindOfAccount().toString() +
                " , " + "date : " + customer[indexofCustomer].account[index].getMyDate().toString() +
                " , " + " money : " + customer[indexofCustomer].account[index].getAccountMoney() + " , "
                + " number account : " + customer[indexofCustomer].account[index].getNumberaccount());
        indexofCustomer++;
        indexofDate++;
        index++;
    }

    public void viewAccount(String name) {
        for (int i = 0; i < indexofCustomer; i++) {
            if (customer[i].getName().equals(name)) {
                for (int j = 0; j < index; j++) {
                    System.out.println("kind of account : " + customer[i].account[j].getKindOfAccount().toString() +
                            " money : " + customer[i].account[j].getAccountMoney() +
                            " name :" + customer[i].getName()
                            + "date : " + customer[i].account[j].getMyDate().toString());
                }
            }


        }
    }


    public void withdraw(int accountNumber, int money, int year, int month, int day) {
        for (int i = 0; i < indexofCustomer; i++) {
            for (int j = 0; j < customer[i].account.length; j++) {
                if (customer[i].account[j].getNumberaccount() == accountNumber) {
                    for (int k = 0; k < index; k++) {
                        KindOfAccount kindOfAccount = customer[i].account[j].getKindOfAccount();
                        if (kindOfAccount.getShortcut() == 0) {
                            customer[i].account[j].withDraw(money, year, month, day);
                            break;
                        } else if (kindOfAccount.getShortcut() == 1) {
                            customer[i].account[j].withDraw(money, year, month, day);
                            break;
                        } else {
                            customer[i].account[j].withDraw(money, year, month, day);
                            break;
                        }
                    }
                    break;
                }

            }
        }
    }

    public void deposit(int accountNumber, int money, int year, int month, int day) {
        for (int i = 0; i < indexofCustomer; i++) {
            for (int j = 0; j < customer[i].account.length; j++) {
                if (customer[i].account[j].getNumberaccount() == accountNumber) {
                    for (int k = 0; k < index; k++) {
                        KindOfAccount kindOfAccount = customer[i].account[j].getKindOfAccount();
                        if (kindOfAccount.getShortcut() == 0) {
                            customer[i].account[j].deposit(money, year, month, day);
                        } else if (kindOfAccount.getShortcut() == 1) {
                            customer[i].account[j].deposit(money, year, month, day);
                        } else {
                            customer[i].account[j].deposit(money, year, month, day);
                        }
                    }
                }
            }
        }
    }


    public void calculateInterest(int accountNumber) {

        for (int i = 0; i < indexofCustomer; i++) {
            for (int j = 0; j < customer[i].account.length; j++) {
                if (customer[i].account[j].getNumberaccount() == accountNumber) {
                    for (int k = 0; k < index; k++) {
                        KindOfAccount kindOfAccount = customer[i].account[j].getKindOfAccount();
                        if (kindOfAccount.getShortcut() == 0) {
                            customer[i].account[j].calculateInterest();
                            break;
                        } else if (kindOfAccount.getShortcut() == 1) {
                            customer[i].account[j].calculateInterest();
                            break;
                        } else {
                            customer[i].account[j].calculateInterest();
                            System.out.println(" date : " + myDate[j].toString());
                            break;
                        }
                    }
                }
            }
        }
    }

    public void ViewTransaction(int accountNumber) {
        for (int i = 0; i < indexofCustomer; i++) {
            for (int j = 0; j < index; j++) {
                if (customer[i].account[j].getNumberaccount() == accountNumber) {
                    for (int k = 0; k < index; k++) {
                        KindOfAccount kindOfAccount = customer[i].account[j].getKindOfAccount();
                        if (kindOfAccount.getShortcut() == 0) {
                            System.out.println(Arrays.toString(customer[i].account[j].getTransActions()));
                        } else if (kindOfAccount.getShortcut() == 1) {
                            System.out.println(customer[i].account[j].transActions.toString());
                        } else {
                            System.out.println(customer[i].account[j].getTransActions().toString());
                        }
                    }
                }
            }
        }
    }
}
