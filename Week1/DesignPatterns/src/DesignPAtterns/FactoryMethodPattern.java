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

interface Document {
    void open();
    void close();
}
class WordDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening a Word document.");
    }
    
     @Override
    public void close() {
        System.out.println("Closing the Word document.");
    }
}

class PdfDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening a PDF document.");
    }
    
       @Override
    public void close() {
        System.out.println("Closing the PDF document.");
    }
}

class ExcelDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening an Excel document.");
    }
    
      @Override
    public void close() {
        System.out.println("Closing the Excel document.");
    }
}

 
abstract class DocumentFactory {
    public abstract Document createDocument();
}


class WordDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new WordDocument();
    }
}


class PdfDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new PdfDocument();
    }
}


class ExcelDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new ExcelDocument();
    }
}


public class FactoryMethodPattern {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select document type to create:");
        System.out.println("1. Word Document");
        System.out.println("2. PDF Document");
        System.out.println("3. Excel Document");
        System.out.print("Enter your choice (1-3): ");
        int choice = scanner.nextInt();

        DocumentFactory factory = null;

        switch (choice) {
            case 1:
                factory = new WordDocumentFactory();
                break;
            case 2:
                factory = new PdfDocumentFactory();
                break;
            case 3:
                factory = new ExcelDocumentFactory();
                break;
            default:
                System.out.println("Invalid choice.");
                scanner.close();
                return;
        }

        Document document = factory.createDocument();
        document.open();
        
            System.out.print("Do you want to close the document? (yes/no): ");
        String closeChoice = scanner.next();

        if (closeChoice.equalsIgnoreCase("yes")) {
            document.close();
        } else {
            System.out.println("Document remains open.");
        }
        
    }
    
}
