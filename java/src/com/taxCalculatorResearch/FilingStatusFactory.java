package com.taxCalculatorResearch;

import java.util.Scanner;


public class FilingStatusFactory implements IFilingStatusFactory {

    public ITaxBracketCalculator taxCalculator;

    public FilingStatusFactory(){
        taxCalculator = new TaxBracketCalculator();
    }

    public double sortFilingStatus(){
        double income;
        double standardDeduction;
        double taxableIncome = 0.00;
        String filingStatus;
        Scanner kb = new Scanner(System.in);

        boolean again= true;
        while (again) {
            again = false;

            System.out.println("Please enter your filing status.");
            System.out.println("\"Single\" or \"Married Filing Jointly\" ?");
            filingStatus = kb.nextLine();
            System.out.println("You entered: " + filingStatus);

            switch (filingStatus) {
                case "Single":
                    System.out.println("Please enter your income ammount: ");
                    income = kb.nextFloat();
                    standardDeduction = 6350.00;
                    taxableIncome = taxCalculator.determineSingleTaxBill(income, standardDeduction);
                    break;
                case "Married Filing Jointly":
                    System.out.println("Please enter your income ammount: ");
                    income = kb.nextFloat();
                    standardDeduction = 12700.00;
                    taxableIncome = taxCalculator.determineMarriedJointlyTaxBill(income, standardDeduction);
                    break;
                default:
                    System.out.println("Incorrect input. Please try again...");
                    again = true;
                    break;
            }
        }
        return taxableIncome;
    }
}
