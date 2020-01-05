package by.epamlab.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Computer {

    public static final int TRIES = 3;
    public static final int START_VALUE = 1;
    public static final int END_VALUE = 20;

    private int randomSecretNumber;
    private HistoryRecord historyRecord;

    private int getRandomSecretNumber() {
        return randomSecretNumber;
    }

    private void chooseRandomNumber(int start, int end) {
        this.randomSecretNumber = start + (int) (Math.random() * end);
    }

    public void start(){
        String command;
        Scanner input = new Scanner(System.in);
        List<String> records = new ArrayList<>();
        while (true){
            System.out.println("1. Start new game");
            System.out.println("2. Show history");
            System.out.println("3. Exit");
            command = input.next();
            switch (command) {
                case "1":
                    playGame(input);
                    System.out.println("It was number " + getRandomSecretNumber());
                    records.add(historyRecord.toString());
                    break;
                case "2":
                    if (records.size() > 3) {
                        records.stream().skip(records.size() - 3).forEach(System.out::println);
                    } else {
                        records.forEach(System.out::println);
                    }
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Unknown command");
                    break;
            }
        }
    }

    private void playGame(Scanner input){
        chooseRandomNumber(START_VALUE, END_VALUE);
        int inputNumber;
        List<String> attempts = new ArrayList<>();

        for (int i = 0; i < TRIES; i++) {
            System.out.println("Guess number : ");
            inputNumber = input.nextInt();
            String inputNumberString = Integer.toString(inputNumber);

            if (inputNumber == getRandomSecretNumber()){
                System.out.println("Congratulations");
                attempts.add(inputNumberString);
                historyRecord = new HistoryRecord("success", attempts);
                return;
            } else {
                System.out.println("Failure");
                attempts.add(inputNumberString);
            }
        }
        historyRecord = new HistoryRecord("failure", attempts);
    }
}
