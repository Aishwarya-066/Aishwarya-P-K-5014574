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

interface Notifier {
    void send(String message);
}

class EmailNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Sending Email: " + message);
    }
}

abstract class NotifierDecorator implements Notifier {
    protected Notifier wrappedNotifier;

    public NotifierDecorator(Notifier notifier) {
        this.wrappedNotifier = notifier;
    }

    @Override
    public void send(String message) {
        wrappedNotifier.send(message);
    }
}

class SMSNotifierDecorator extends NotifierDecorator {
    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        sendSMS(message);
    }

    private void sendSMS(String message) {
        System.out.println("Sending SMS: " + message);
    }
}

class SlackNotifierDecorator extends NotifierDecorator {
    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        sendSlack(message);
    }

    private void sendSlack(String message) {
        System.out.println("Sending Slack message: " + message);
    }
}
class MessageNotifierDecorator extends NotifierDecorator {
    public MessageNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        receiveMessage(message);
    }

    private void receiveMessage(String message) {
        System.out.println("Receiving message notification: " + message);
    }
}

public class DecoratorPatternExample {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

        Notifier notifier = new EmailNotifier();

        System.out.print("Would you like to add SMS notifications? (yes/no): ");
        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            notifier = new SMSNotifierDecorator(notifier);
        }

        System.out.print("Would you like to add Slack notifications? (yes/no): ");
        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            notifier = new SlackNotifierDecorator(notifier);
        }

        System.out.print("Would you like to add message receiving notifications? (yes/no): ");
        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            notifier = new MessageNotifierDecorator(notifier);
        }

        System.out.print("Enter the message to send: ");
        String message = scanner.nextLine();

        notifier.send(message);

    }
}
