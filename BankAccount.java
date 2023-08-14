import java.util.Scanner;
class BankAccount
{
      String name;
      String username;
      String password;
      String accountNo;
      float balance = 100000f;
      int transactions = 0;
      String transactionHistory = "";

      public void register()
      {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter your Name: ");
            this.name = sc.nextLine();
            System.out.println("Enter your Username: ");
            this.username = sc.nextLine();
            System.out.println("Enter your Password: ");
            this.password = sc.nextLine();
            System.out.println("Enter your Account Number: ");
            this.accountNo = sc.nextLine();
            System.out.println("Registration Completed...Kindly Please Login");
      }
      public boolean login()
      {
            boolean isLogin = false;
            Scanner sc = new Scanner(System.in);
            while (!isLogin)
            {
                  System.out.println("Enter your Username: ");
                  String Username = sc.nextLine();
                  if (Username.equals(username))
                  {
                        while (!isLogin)
                        {
                              System.out.println("Enter your Password: ");
                              String Password = sc.nextLine();
                              if (Password.equals(password))
                              {
                                    System.out.println("Login Successfull!!");
                                    isLogin = true;
                              }
                              else
                              {
                                    System.out.println("Incorrect Password");
                              }
                        }
                  }
                  else
                  {
                        System.out.println("Username is not found");
                  }
            }
            return isLogin;
      }
      public void withdraw()
      {
            System.out.println("Enter amount to withdraw: ");
            Scanner sc = new Scanner(System.in);
            float amount = sc.nextFloat();
            try
            {
                  if(balance >= amount)
                  {
                        transactions++;
                        balance -= amount;
                        System.out.println("Withdrawal is Successful");
                        String str = amount + "Rs. Withdrawn\n";
                        transactionHistory = transactionHistory.concat(str);
                  }
                  else
                  {
                        System.out.println("Insufficient Balance");
                  }
            }
            catch (Exception e)
            {
            }
      }
      public void deposit()
      {
            System.out.println("Enter amount to deposit: ");
            Scanner sc = new Scanner(System.in);
            float amount = sc.nextFloat();
            try
            {
                  if(amount <= 100000f)
                  {
                        transactions++;
                        balance += amount;
                        System.out.println("Successfully Deposited");
                        String str = amount + "Rs. Deposited\n";
                        transactionHistory = transactionHistory.concat(str);
                  }
                  else
                  {
                        System.out.println("Sorry...Limit is 100000.00");
                  }
            }
            catch (Exception e)
            {
            }
      }
      public void transfer()
      {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Recepient's Name: ");
            String recepient = sc.nextLine();
            System.out.println("Enter amount to transfer");
            float amount = sc.nextFloat();
            try
            {
                  if (balance >= amount)
                  {
                        if (amount <= 50000f)
                        {
                              transactions++;
                              balance -= amount;
                              System.out.println("Successfully Transferred to " + recepient);
                              String str = amount + "Rs. transferred to " + recepient;
                              transactionHistory = transactionHistory.concat(str);
                        }
                        else
                        {
                              System.out.println("Sorry...Limit is 50000.00");
                        }
                  }
                  else
                  {
                        System.out.println("Insufficient Balance");
                  }
            }
            catch (Exception e)
            {
            }
      }
      public void checkBalance()
      {
            System.out.println(balance + "Rs");

      }
      public void transHistory()
      {
            if (transactions == 0)
            {
                  System.out.println("Empty");
            }
            else
            {
                  System.out.println(transactionHistory);
            }
      }
}