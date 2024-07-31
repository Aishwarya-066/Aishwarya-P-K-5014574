/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinancialForecasting;

/**
 *
 * @author Aishwarya
 */
import java.util.Scanner;




public class FinancialForecasting {
    
 
    public static double calculateFutureValue(double presentValue, double growthRate, int years) {
       
        if (years == 0) {
            return presentValue;
        }
 
        return calculateFutureValue(presentValue * (1 + growthRate), growthRate, years - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the present value: ");
        double presentValue = scanner.nextDouble();

        System.out.print("Enter the growth rate (as a decimal, e.g., 0.05 for 5%): ");
        double growthRate = scanner.nextDouble();

        System.out.print("Enter the number of years: ");
        int years = scanner.nextInt();

        double futureValue = calculateFutureValue(presentValue, growthRate, years);
        
   
        System.out.printf("The future value after %d years is: %.2f%n", years, futureValue);
        
        scanner.close();
    }
    public static double calculateFutureValueIterative(double presentValue, double growthRate, int years) {
    double futureValue = presentValue;
    for (int i = 0; i < years; i++) {
        futureValue *= (1 + growthRate);
    }
    return futureValue;
}
}

