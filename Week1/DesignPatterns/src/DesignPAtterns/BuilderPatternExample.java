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

class Computer {
    private String CPU;
    private String RAM;
    private String storage;
    private String graphicsCard;
    private String powerSupply;

    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.graphicsCard = builder.graphicsCard;
        this.powerSupply = builder.powerSupply;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "CPU='" + CPU + '\'' +
                ", RAM='" + RAM + '\'' +
                ", storage='" + storage + '\'' +
                ", graphicsCard='" + graphicsCard + '\'' +
                ", powerSupply='" + powerSupply + '\'' +
                '}';
    }

    // Static nested Builder class
    public static class Builder {
        private String CPU;
        private String RAM;
        private String storage;
        private String graphicsCard;
        private String powerSupply;

        public Builder setCPU(String CPU) {
            this.CPU = CPU;
            return this;
        }

        public Builder setRAM(String RAM) {
            this.RAM = RAM;
            return this;
        }

        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder setGraphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }

        public Builder setPowerSupply(String powerSupply) {
            this.powerSupply = powerSupply;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}

public class BuilderPatternExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter CPU: ");
        String cpu = scanner.nextLine();
        
        System.out.print("Enter RAM: ");
        String ram = scanner.nextLine();
        
        System.out.print("Enter Storage: ");
        String storage = scanner.nextLine();
        
        System.out.print("Enter Graphics Card (optional, press Enter to skip): ");
        String graphicsCard = scanner.nextLine();
        
        System.out.print("Enter Power Supply (optional, press Enter to skip): ");
        String powerSupply = scanner.nextLine();

        Computer.Builder builder = new Computer.Builder()
                .setCPU(cpu)
                .setRAM(ram)
                .setStorage(storage);
        
        if (!graphicsCard.isEmpty()) {
            builder.setGraphicsCard(graphicsCard);
        }
        
        if (!powerSupply.isEmpty()) {
            builder.setPowerSupply(powerSupply);
        }

        Computer computer = builder.build();
        System.out.println("Created Computer: " + computer);
    }
}
