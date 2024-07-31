/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPAtterns;

/**
 *
 * @author Aishwarya
 */
import java.util.*;
interface PaymentStrategy {
    void pay(double amount);
}
 class CreditCardPayment implements PaymentStrategy {
    private String name;
    private String cardNumber;
    private String cvv;
    private String expirationDate;

    public CreditCardPayment(String name, String cardNumber, String cvv, String expirationDate) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expirationDate = expirationDate;
    }

    @Override
    public void pay(double amount) {
        System.out.println(amount + " paid with credit card.");
    }
}

 class PayPalPayment implements PaymentStrategy {
    private String email;
    private String password;

    public PayPalPayment(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public void pay(double amount) {
        System.out.println(amount + " paid using PayPal.");
    }
}

class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void pay(double amount) {
        paymentStrategy.pay(amount);
    }
}

public class StrategyPatternExample {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
        PaymentContext context = new PaymentContext();     
    System.out.println("Select payment method (1: Credit Card, 2: PayPal) to pay: ");
        int choice = scanner.nextInt();
        
         if (choice == 1) {
            System.out.print("Enter name: ");
            String name = scanner.next();
            System.out.print("Enter card number: ");
            String cardNumber = scanner.next();
            System.out.print("Enter CVV: ");
            String cvv = scanner.next();
            System.out.print("Enter expiration date (MM/YY): ");
            String expirationDate = scanner.next();
          
           PaymentStrategy creditCardPayment = new CreditCardPayment(name, cardNumber, cvv, expirationDate);
            context.setPaymentStrategy(creditCardPayment);

        } else if (choice == 2) {
            System.out.print("Enter PayPal email: ");
            String email = scanner.next();
            System.out.print("Enter PayPal password: ");
            String password = scanner.next();
            PaymentStrategy payPalPayment = new PayPalPayment(email, password);
            context.setPaymentStrategy(payPalPayment);
        } else {
            System.out.println("Invalid choice");
            return;
        }

 
        System.out.print("Enter amount to pay: ");
        double amount = scanner.nextDouble();

        context.pay(amount);
    }
}
