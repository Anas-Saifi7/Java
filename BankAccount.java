
import java.util.Scanner;
import java.util.*;

public class BankAccount {
   private double AccountNumber;
   private double balance;
  // Constructor 
  public BankAccount(double AccountNumber, double initialBalance){
    this.AccountNumber = AccountNumber;
    if(initialBalance < 0){
     System.out.println("Initial balance cannot be negative");
    }
    this.balance = initialBalance; 
  }
  public double getAccountNumber(){
    return AccountNumber;
  }
  // method to check the current balance
  public double checkBalance(){
    return balance;
  }
   // deposit money into the bankaccount
       public  void deposit(double amount){
        if(amount <= 0){
          System.out.println("deposit  amount must be positive.");
           }
            balance += amount;
      System.out.println("Successfully deposit: " + amount + "\n New balance : "+ balance); 
  }
      // withraw money from the bankaccount
    public  void withdraw(double amount){
      if(amount > balance){
            System.out.println("Insufficient funds.withdraw faild!");
            return;
      }
      balance -= amount;
      System.out.println("Successfully withdraw: " + amount + " \n New balance : "+ balance);; 
  }
  public static void main(String[] args) {
    BankAccount account = new BankAccount(1223, 1000);
    // check the balance 
    System.out.println("Initial balance:" + account.checkBalance());
    // Deposit money
     account.deposit(1200);
    // withraw  money
    account.withdraw(500);

     account.withdraw(1000);
    System.out.println("Final balance :" + account.checkBalance());
  }


}