import java.util.Scanner;
public class ATMInterface
{
    public static int takeIntegerInput(int limit)
    {
        int input = 0;
        boolean flag = false;

        while (!flag)
        {
            try
            {
                Scanner sc = new Scanner(System.in);
                input = sc.nextInt();
                flag = true;

                if (flag && input > limit || input < 1)
                {
                    System.out.println("Choose the number between 1 to " + limit);
                    flag = false;
                }
            }
            catch (Exception e)
            {
                System.out.println("Enter only integer value");
                flag = false;
            }
        };
        return input;
    }

public static void main(String[] args)
{
        System.out.println("*****WELCOME TO SBI ATM SYSTEM*****");
        System.out.println("1. Register\n2. Exit");
        System.out.println("Enter your choice");
        int choice = takeIntegerInput(2);

        if (choice == 1)
        {
            BankAccount ba = new BankAccount();
            ba.register();
            while (true)
            {
                System.out.println("1. Login\n2. Exit");
                System.out.println("Enter your choice");
                int ch = takeIntegerInput(2);
                if (ch == 1)
                {
                    if (ba.login())
                    {
                        System.out.println("----------WELCOME BACK " + ba.name + "----------");
                        boolean isFinished = false;
                        while (!isFinished)
                        {
                            System.out.println("1. Withdraw\n2. Deposit\n3. Transfer\n4. Check Balance\n5. Transaction History\n6. Exit");
                            System.out.println("Enter your choice");
                            int c = takeIntegerInput(6);
                            switch (c)
                            {
                                case 1:
                                    ba.withdraw();
                                    break;
                                case 2:
                                    ba.deposit();
                                    break;
                                case 3:
                                    ba.transfer();
                                    break;
                                case 4:
                                    ba.checkBalance();
                                    break;
                                case 5:
                                    ba.transHistory();
                                    break;
                                case 6:
                                    isFinished = true;
                                    break;
                            }
                        }
                    }
                }
                else
                {
                    System.exit(0);
                }
            }
        }
        else
        {
            System.exit(0);
        }
 }
}



