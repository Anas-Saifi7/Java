import java.util.Scanner;
import java.util.*;

public class ATM {
    private double balance;
    // constructor 
    public ATM(double initialBalance){
        if(initialBalance < 0){
         System.out.println("Initial balance cannot be negative");
        }
        this.balance = initialBalance;
    }
    // method check the CurrentBalance 
    public double checkBalance(){
        return balance;
    }
    // deposit money into the atm
     public  void deposit(double amount){
      if(amount <= 0){
        System.out.println("deposit  amount must be positive.");
         }
          balance += amount;
    System.out.println("Successfully deposit: " + amount + "\n New balance : "+ balance);; 
}
    // withraw money from the atm
  public  void withdraw(double amount){
    if(amount > balance){
          System.out.println("Insufficient funds.withdraw faild!");
          return;
    }
    balance -= amount;
    System.out.println("Successfully withdraw: " + amount + " \n New balance : "+ balance);; 
}
  public static void main(String[] args) {
      ATM atm = new ATM(2000);
      // check the balance 
      System.out.println("Initial balance:" + atm.checkBalance());
      // Deposit money
       atm.deposit(1200);
      // withraw  money
      atm.withdraw(500);
      
       atm.withdraw(1000);
      System.out.println("Final balance :" + atm.checkBalance());


  }
}