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

interface Command {
    void execute();
}

class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}


class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}
 class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}

class Light {
    public void turnOn() {
        System.out.println("The light is on.");
    }

    public void turnOff() {
        System.out.println("The light is off.");
    }
}

public class CommandPatternExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Light light = new Light();
        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);
        RemoteControl remoteControl = new RemoteControl();

        while (true) {
            System.out.println("Enter command (on/off/exit): ");
            String command = scanner.nextLine();

            switch (command.toLowerCase()) {
                case "on":
                    remoteControl.setCommand(lightOn);
                    remoteControl.pressButton();
                    break;
                case "off":
                    remoteControl.setCommand(lightOff);
                    remoteControl.pressButton();
                    break;
                case "exit":
                    System.out.println("Exiting...");
                    
                    System.exit(0);
                default:
                    System.out.println("Unknown command. Please enter 'on', 'off', or 'exit'.");
            }
        }
        
    }
}
