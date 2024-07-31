/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Order;

import java.util.*;

/**
 *
 * @author Aishwarya
 */
public class Order {
    
    int orderId;
    String Customer_name;
    int totalPrice;
    
    Order(int orderId, String Customer_name, int totalPrice){
        this.orderId = orderId;
        this.Customer_name = Customer_name;
        this.totalPrice = totalPrice;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of Orders : ");
        int n = sc.nextInt();
        Order[] obj = new Order[n];
        for(int i = 0; i < n; i++){
            System.out.println("Enter Order id : ");
            int o = sc.nextInt();
            System.out.println("Enter Customer_name : ");
            String name = sc.next();
            System.out.println("Enter Total Price : ");
            int totalPrice = sc.nextInt();
            obj[i] = new Order(o,name,totalPrice);
        }
        
        System.out.println("Enter your choice for sorting (Bubble sort : 0 / Quick sort : 1)");
        int choice = sc.nextInt();
        
        if(choice == 1){
        int low = 0;
        int high = obj.length-1;
        quick(obj,low,high);
        display(obj); 
        }
        else{
            Bubblesort(obj);
            display(obj);
        }

    }
    
     public static void quick(Order[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quick(arr, low, pi - 1);
            quick(arr, pi + 1, high);
        }
    }

    public static int partition(Order[] arr, int low, int high) {
        int pivot = arr[high].totalPrice; 
        int i = (low - 1);     

        for (int j = low; j < high; j++) {
            if (arr[j].totalPrice >= pivot) {
                i++;

                int temp = arr[i].totalPrice;
                arr[i].totalPrice = arr[j].totalPrice;
                arr[j].totalPrice = temp;
                
                 String tname = arr[i].Customer_name;
                arr[i].Customer_name = arr[j].Customer_name;
                arr[j].Customer_name = tname;
                
                 int temp1 = arr[i].orderId;
                arr[i].orderId = arr[j].orderId;
                arr[j].orderId = temp1;
                
              
            }
        }

        int temp = arr[i + 1].totalPrice;
        arr[i + 1].totalPrice = arr[high].totalPrice;
        arr[high].totalPrice = temp;
        
         String tname = arr[i+1].Customer_name;
                arr[i+1].Customer_name = arr[high].Customer_name;
                arr[high].Customer_name = tname;
                
                 int temp1 = arr[i+1].orderId;
                arr[i+1].orderId = arr[high].orderId;
                arr[high].orderId = temp1;

        return i + 1;
    }



    
    public static void Bubblesort(Order[] arr){
        
        for(int i = arr.length-1; i > 0; i--){
            for(int j = 0; j < i; j++){
                if(arr[j].totalPrice < arr[j+1].totalPrice){
                    int temp = arr[j].totalPrice;
                    arr[j].totalPrice = arr[j+1].totalPrice;
                    arr[j+1].totalPrice= temp;
                    
                     
                 String tname = arr[i].Customer_name;
                arr[i].Customer_name = arr[j].Customer_name;
                arr[j].Customer_name = tname;
                
                 int temp1 = arr[i].orderId;
                arr[i].orderId = arr[j].orderId;
                arr[j].orderId = temp1;
                }
            }
        }
    }
    
    public static void display(Order[] obj){
        int n = obj.length;
        
        for(int i = 0; i < n; i++){
            System.out.println("Order id : "+ obj[i].orderId);
            System.out.println("Customer name : "+ obj[i].Customer_name);
            System.out.println("Total Price : " + obj[i].totalPrice);
        }
    }
    
}
