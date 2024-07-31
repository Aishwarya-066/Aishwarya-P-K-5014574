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
interface PaymentProcessor {
    void processPayment(double amount);
}

class PayPal {
    public void makePayment(double amount) {
        System.out.println("Processing payment of " + amount + " through PayPal.");
    }
}

class Stripe {
    public void pay(double amount) {
        System.out.println("paying " + amount + " through Stripe.");
    }
}

class PayPalAdapter implements PaymentProcessor {
    private PayPal payPal;

    public PayPalAdapter(PayPal payPal) {
        this.payPal = payPal;
    }

    @Override
    public void processPayment(double amount) {
        payPal.makePayment(amount);
    }
}

class StripeAdapter implements PaymentProcessor {
    private Stripe stripe;

    public StripeAdapter(Stripe stripe) {
        this.stripe = stripe;
    }

    @Override
    public void processPayment(double amount) {
        stripe.pay(amount);
    }
}

public class AdapterPatternExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the amount to process: ");
        double amount = scanner.nextDouble();

        System.out.print("Choose payment gateway (1 for PayPal, 2 for Stripe): ");
        int choice = scanner.nextInt();

        PaymentProcessor paymentProcessor;

        if (choice == 1) {
            paymentProcessor = new PayPalAdapter(new PayPal());
        } else if (choice == 2) {
            paymentProcessor = new StripeAdapter(new Stripe());
        } else {
            System.out.println("Invalid choice");
            scanner.close();
            return;
        }

        paymentProcessor.processPayment(amount);
    }
}
