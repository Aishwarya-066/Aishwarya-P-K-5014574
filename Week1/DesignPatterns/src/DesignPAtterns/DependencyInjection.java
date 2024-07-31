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
class Customer {
    private int id;
    private String name;
    private String email;

    public Customer(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}

interface CustomerRepository {
    Customer findCustomerById(int id);
    void addCustomer(Customer customer);
}



class CustomerRepositoryImpl implements CustomerRepository {

    private Map<Integer, Customer> customerDatabase = new HashMap<>();

    @Override
    public Customer findCustomerById(int id) {
        return customerDatabase.get(id);
    }

    @Override
    public void addCustomer(Customer customer) {
        customerDatabase.put(customer.getId(), customer);
    }
}


 class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer getCustomerById(int id) {
        return customerRepository.findCustomerById(id);
    }

    public void addCustomer(Customer customer) {
        customerRepository.addCustomer(customer);
    }
}



public class DependencyInjection {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
      CustomerRepository customerRepository = new CustomerRepositoryImpl();

        CustomerService customerService = new CustomerService(customerRepository);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter no of customer : ");
        int n = scanner.nextInt();
         Customer newCustomer[] = new Customer[n];
        for(int i = 0; i < n; i++){
        System.out.print("Enter Customer ID: ");
        int customerId = scanner.nextInt(); 
        System.out.print("Enter Customer Name: ");
        String customerName = scanner.next();
        System.out.print("Enter Customer Email: ");
        String customerEmail = scanner.next();
       newCustomer[i] = new Customer(customerId, customerName, customerEmail);
        customerService.addCustomer(newCustomer[i]);
           
        }
        System.out.println("Enter the customer id you want to view : ");
        int cid = scanner.nextInt();
        Customer customer = customerService.getCustomerById(cid);
        if (customer != null) {
            System.out.println("Customer ID: " + customer.getId());
            System.out.println("Customer Name: " + customer.getName());
            System.out.println("Customer Email: " + customer.getEmail());
        } else {
            System.out.println("Customer not found.");
        }

    }
    
}
