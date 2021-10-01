import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Bank bank = new Bank();
        KindOfAccount[] kind = new KindOfAccount[3];
        kind[0] = KindOfAccount.CHECHINGACOUNT;
        kind[1] = KindOfAccount.SAVINGACCOUNT;
        kind[2] = KindOfAccount.LOANACCOUNT;
        String name;
        int money;
        int year;
        int month;
        int day;
        int kindaccount;
        int accountNumber;
        boolean checkContinue = false;
        do {
            System.out.println("************Welcome****************");
            int choice = 0;
            boolean check = false;
            do {
                System.out.println("1.Add new account\n2.View account\n3.WithDraw\n4.Deposit\n5.Calculate interest\n6.View transAction\n7.Exit");
                System.out.println("Select a Choice:");
                choice = input.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Enter information of customer:\n" +
                                "name , money , year,month,day,\n kindAcount(enter 0 for open check account,1 for saving account , 2 for loan account)");
                        name = input.next();
                        money = input.nextInt();
                        year = input.nextInt();
                        month = input.nextInt();
                        day = input.nextInt();
                        kindaccount = input.nextInt();
                        bank.addAccount(name, money, year, month, day,kind[kindaccount]);
                        check = false;
                        break;
                    case 2:
                        System.out.println("enter name of customer");
                        name = input.next();
                        bank.viewAccount(name);
                        break;
                    case 3:
                        System.out.println("enter acount number , money , year ,month , day");
                        accountNumber = input.nextInt();
                        money = input.nextInt();
                        year = input.nextInt();
                        month = input.nextInt();
                        day = input.nextInt();
                        bank.withdraw(accountNumber,money,year,month,day);
                        break;
                    case 4:
                        System.out.println("enter acount number , money , year ,month , day");
                        accountNumber = input.nextInt();
                        money = input.nextInt();
                        year = input.nextInt();
                        month = input.nextInt();
                        day = input.nextInt();
                        bank.deposit(accountNumber,money,year,month,day);
                        break;
                    case 5:
                        System.out.println(" enter accountNumber");
                        accountNumber = input.nextInt();
                        bank.calculateInterest(accountNumber);
                        break;
                    case 6:
                        System.out.println(" enter accountNumber");
                        accountNumber = input.nextInt();
                        bank.ViewTransaction(accountNumber);
                        break;
                    case 7:
                        check = true;
                        break;
                    default:
                        System.out.println("Enter number between 1 and 7:");
                }
            } while (!check);
        }
        while (checkContinue);
    }
}



