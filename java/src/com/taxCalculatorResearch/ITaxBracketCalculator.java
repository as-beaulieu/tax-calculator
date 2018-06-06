package com.taxCalculatorResearch;

public interface ITaxBracketCalculator {
    double determineSingleTaxBill(double income, double deductible);
    double determineMarriedJointlyTaxBill(double income, double deductible);
}
