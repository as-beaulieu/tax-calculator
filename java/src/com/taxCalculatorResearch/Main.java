package com.taxCalculatorResearch;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //double income;
        //Scanner kb = new Scanner(System.in);

        IFilingStatusFactory filingFactory = new FilingStatusFactory();

        System.out.println("Welcome to the 2017 tax calculator.");

        double result = filingFactory.sortFilingStatus();

        System.out.println("Your tax bill will be: " + result);
    }
}
