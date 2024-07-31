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

class Logger{
    private static Logger instance;
    private Logger(){        
    }
    
    public static Logger getInstance(){
        if(instance == null){
            instance = new Logger();
        }
        return instance;
    }
    
    public static void logme(String message){
        System.out.println(message);
    }
}
public class SingletonPatternExample {

    public static void main(String[] args) {
       Logger l1 = Logger.getInstance();
       Logger l2 = Logger.getInstance();
       l1.logme("logged from l1");
       l2.logme("logged from l2");
       
       if(l1 == l2){
           System.out.println("Both have same instance");
       }
       else{
           System.out.println("different");
       }
       
       
    }
    
}
