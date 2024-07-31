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

interface Observer {
    void update(double stockPrice);
}
 class MobileApp implements Observer {
    private String name;

    public MobileApp(String name) {
        this.name = name;
    }

    @Override
    public void update(double stockPrice) {
        System.out.println(name + " received stock price update: " + stockPrice);
    }
}
class WebApp implements Observer {
    private String name;

    public WebApp(String name) {
        this.name = name;
    }

    @Override
    public void update(double stockPrice) {
        System.out.println(name + " received stock price update: " + stockPrice);
    }
}

 class StockMarket implements Stock {
    private List<Observer> observers;
    private double stockPrice;

    public StockMarket() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void deregisterObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockPrice);
        }
    }

    public void setStockPrice(double stockPrice) {
        this.stockPrice = stockPrice;
        notifyObservers();
    }
}

interface Stock {
    void registerObserver(Observer o);
    void deregisterObserver(Observer o);
    void notifyObservers();
}

public class ObserverPatternExample {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
        StockMarket stockMarket = new StockMarket();

        System.out.print("Enter the name of the mobile app observer: ");
        String mobileAppName = scanner.nextLine();
        Observer mobileApp = new MobileApp(mobileAppName);
        stockMarket.registerObserver(mobileApp);

        System.out.print("Enter the name of the web app observer: ");
        String webAppName = scanner.nextLine();
        Observer webApp = new WebApp(webAppName);
        stockMarket.registerObserver(webApp);

        while (true) {
            System.out.print("Enter new stock price (or 'exit' to quit): ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Exiting...");
                scanner.close();
                break;
            }
            try {
                double newPrice = Double.parseDouble(input);
                stockMarket.setStockPrice(newPrice);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }
}
