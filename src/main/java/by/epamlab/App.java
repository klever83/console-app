package by.epamlab;

import by.epamlab.beans.Computer;

public class App {
    public static void main(String[] args) {
        System.out.println("Welcome to the game Guess The Number");
        System.out.println("------------------------------------");
        Computer computer = new Computer();
        computer.start();
    }
}
