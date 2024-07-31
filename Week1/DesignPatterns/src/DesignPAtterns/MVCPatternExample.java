/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPAtterns;

import java.util.*;

/**
 *
 * @author Aishwarya
 */
 class Student {
    private String name;
    private int id;
    private String grade;

    public Student(int id, String name, String grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}

class StudentView {
    public void displayStudentDetails(int studentId, String studentName, String studentGrade) {
        System.out.println("Student ID: " + studentId);
        System.out.println("Student Name: " + studentName);
        System.out.println("Student Grade: " + studentGrade);
    }
}

class StudentController {
    private Student model;
    private StudentView view;

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    public void setStudentName(String name) {
        model.setName(name);
    }

    public String getStudentName() {
        return model.getName();
    }

    public void setStudentGrade(String grade) {
        model.setGrade(grade);
    }

    public String getStudentGrade() {
        return model.getGrade();
    }

    public void updateView() {
        view.displayStudentDetails(model.getId(), model.getName(), model.getGrade());
    }
}

public class MVCPatternExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter no of customer : ");
        int n = scanner.nextInt();
       HashMap<Integer,Student> hm = new HashMap<>();
         for(int i = 1; i < n+1; i++){
        System.out.print("Enter Student ID: ");
        int studentId = scanner.nextInt();
      
        System.out.print("Enter Student Name: ");
        String studentName = scanner.next();

        System.out.print("Enter Student Grade: ");
        String studentGrade = scanner.next();

        hm.put(studentId,new Student(studentId, studentName, studentGrade));
         }
        StudentView view = new StudentView();
        System.out.println("Enter the student id you want to update if no enter 0: ");
        int id = scanner.nextInt();
        if(id > 0){
        StudentController controller = new StudentController(hm.get(id), view);

        controller.updateView();

        System.out.print("Enter Updated Student Name: ");
        String updatedName = scanner.next();

        System.out.print("Enter Updated Student Grade: ");
        String updatedGrade = scanner.next();


        controller.setStudentName(updatedName);
        controller.setStudentGrade(updatedGrade);


        controller.updateView();
        }
        else{
            System.out.println("Thank you");
        }
    }
}
