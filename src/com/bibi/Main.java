package com.bibi;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        System.out.print("Principal: ");
        int principal = new Scanner(System.in).nextInt();
        System.out.print("Annual Interest Rate: ");
        Float annualInterestRate = new Scanner(System.in).nextFloat();
        System.out.print("Period (Years): ");
        Byte periodYears = new Scanner(System.in).nextByte();

        Float monthlyInterestRate = annualInterestRate / PERCENT / MONTHS_IN_YEAR;

        int numberOfPayments = periodYears * MONTHS_IN_YEAR;

        Double monthlyPayment = principal
                *((monthlyInterestRate*(Math.pow((1 + monthlyInterestRate),numberOfPayments)))
                /(Math.pow((1 + monthlyInterestRate),numberOfPayments) - 1));
        System.out.println("Mortgage: " + NumberFormat.getCurrencyInstance().format(monthlyPayment));
    }
}
