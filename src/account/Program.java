package account;

import entities.exception.DomainException;
import java.util.Locale;
import java.util.Scanner;
import model.entities.Account;

public class Program {

    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
       
        try {
            System.out.println("Enter account data");
            System.out.print("Number: ");
            int number = sc.nextInt();
            System.out.print("Holder: ");
            sc.nextLine();
            String holder = sc.nextLine();
            System.out.print("Initial balance: ");
            double initialBalance = sc.nextDouble();
            System.out.print("withdraw limit: ");
            double withdrawLimite = sc.nextDouble();

            Account acc = new Account(number, holder, initialBalance, withdrawLimite);

            System.out.println();
            System.out.print("Enter amount for withdraw: ");
            double withdraw = sc.nextDouble();
            acc.withdraw(withdraw);
            System.out.println("New balance: " + acc.getBalance());
            
        } catch (DomainException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro nao esperado!");
        }
        finally{
            System.out.println("End of program.");
        }
        sc.close();
    }
    
}
