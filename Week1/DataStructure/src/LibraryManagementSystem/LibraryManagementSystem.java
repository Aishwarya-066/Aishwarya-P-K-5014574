/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LibraryManagementSystem;

/**
 *
 * @author Aishwarya
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Book {
    private int bookId;
    private String title;
    private String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Book ID: " + bookId + ", Title: " + title + ", Author: " + author;
    }
}

public class LibraryManagementSystem {

    
    public static Book linearSearch(List<Book> books, String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

   
    public static Book binarySearch(List<Book> books, String title) {
        int left = 0;
        int right = books.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = books.get(mid).getTitle().compareToIgnoreCase(title);

            if (comparison == 0) {
                return books.get(mid); 
            } else if (comparison < 0) {
                left = mid + 1; 
            } else {
                right = mid - 1; 
            }
        }
        return null; 
    }

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "The Great Gatsby", "F. Scott Fitzgerald"));
        books.add(new Book(2, "To Kill a Mockingbird", "Harper Lee"));
        books.add(new Book(3, "1984", "George Orwell"));
        books.add(new Book(4, "Pride and Prejudice", "Jane Austen"));
        books.add(new Book(5, "Moby Dick", "Herman Melville"));

        Collections.sort(books, Comparator.comparing(Book::getTitle));

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the title of the book to search (using linear search): ");
        String title = scanner.nextLine();

        Book foundBookLinear = linearSearch(books, title);
        if (foundBookLinear != null) {
            System.out.println("Found using linear search: " + foundBookLinear);
        } else {
            System.out.println("Book not found using linear search.");
        }

        System.out.print("Enter the title of the book to search (using binary search): ");
        title = scanner.nextLine();

        Book foundBookBinary = binarySearch(books, title);
        if (foundBookBinary != null) {
            System.out.println("Found using binary search: " + foundBookBinary);
        } else {
            System.out.println("Book not found using binary search.");
        }

    }
}

