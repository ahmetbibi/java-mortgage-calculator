package com.bibi;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        int principal = 0;
        Float annualInterestRate = 0.0F;
        Byte periodYears = 0;
        Float monthlyInterestRate = 0.0F;
        int numberOfPayments = 0;

        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.print("Principal ($1K - $1M): ");
            principal = scanner.nextInt();
            if (principal >= 1000 && principal <= 1000000)
                break;
            System.out.println("Enter a number between 1,000 and 1,000,000");
        }

        while (true) {
            System.out.print("Annual Interest Rate: ");
            annualInterestRate = scanner.nextFloat();
            if (annualInterestRate > 0 && annualInterestRate <= 30) {
                monthlyInterestRate = annualInterestRate / PERCENT / MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter a value greater than 0 and less than 30");
        }

        while (true) {
            System.out.print("Period (Years): ");
            periodYears = scanner.nextByte();
            if (periodYears >= 1 && periodYears <= 30) {
                numberOfPayments = periodYears * MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter a value between 1 and 30");
        }


        Double monthlyPayment = principal
                *((monthlyInterestRate*(Math.pow((1 + monthlyInterestRate),numberOfPayments)))
                /(Math.pow((1 + monthlyInterestRate),numberOfPayments) - 1));
        System.out.println("Mortgage: " + NumberFormat.getCurrencyInstance().format(monthlyPayment));


    }
}
