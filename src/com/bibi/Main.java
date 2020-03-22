package com.bibi;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int principal = (int) readInput("Principal ($1K - $1M): ", 1000, 1000000);
        float annualInterestRate = (float) readInput("Annual Interest Rate: ", 0, 30);
        byte periodYears = (byte) readInput("Period (Years): ", 1, 30);

        double monthlyPayment = calculateMortgage(principal, annualInterestRate, periodYears);

        String mortgage = NumberFormat.getCurrencyInstance().format(monthlyPayment);

        System.out.println("Mortgage: " + mortgage);
    }

    public static double readInput(String prompt, double min, double max) {
        Scanner scanner = new Scanner(System.in);
        double value;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextFloat();

            if (value >= min && value <= max)
                break;

            System.out.println("Enter a value between " + min + " and " + max);
        }
        return value;
    }

    public static double calculateMortgage(
            int principal,
            float annualInterestRate,
            byte periodYears) {

        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        float monthlyInterestRate = annualInterestRate / PERCENT / MONTHS_IN_YEAR;
        byte numberOfPayments =(byte)(periodYears * MONTHS_IN_YEAR);

        double monthlyPayment = principal
                *((monthlyInterestRate*(Math.pow((1 + monthlyInterestRate),numberOfPayments)))
                /(Math.pow((1 + monthlyInterestRate),numberOfPayments) - 1));

        return monthlyPayment;
    }
}
