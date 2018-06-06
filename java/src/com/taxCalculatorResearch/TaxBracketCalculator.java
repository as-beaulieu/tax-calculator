package com.taxCalculatorResearch;

public class TaxBracketCalculator implements ITaxBracketCalculator {

    public TaxBracketCalculator(){

    }

    public double determineSingleTaxBill(double income, double deductible){
        double taxableIncome = income - deductible;
        double firstBracket = 9325.00;
        double secondBracket;
        double thirdBracket;
        double fourthBracket;
        double fifthBracket;
        double sixthBracket;
        double seventhBracket;
        double taxBill = 0.00;

        if(taxableIncome <= 9325.00){
            taxBill += taxableIncome * 0.10;
        }
        else if (taxableIncome > 9325.00 && taxableIncome < 37950){
            //$932.50 plus 15% of the amount over $9,325
            taxBill += firstBracket * 0.10;
            secondBracket = taxableIncome - firstBracket;
            taxBill += secondBracket * 0.15;
        }
        else if (taxableIncome > 37950 && taxableIncome < 91900){
            //$5,226.25 plus 25% of the amount over $37,950
            taxBill += firstBracket * 0.10;
            secondBracket = 37950 - firstBracket;
            taxBill += secondBracket * 0.15;
            thirdBracket = taxableIncome - 37950;
            taxBill += thirdBracket * 0.25;
        }
        else if (taxableIncome > 91900 && taxableIncome < 191650){
            //$18,713.75 plus 28% of the amount over $91,900
            taxBill += firstBracket * 0.10;
            secondBracket = 37950 - firstBracket;
            taxBill += secondBracket * 0.15;
            thirdBracket = 91900 - 37950;
            taxBill += thirdBracket * 0.25;
            fourthBracket = taxableIncome - 91900;
            taxBill += fourthBracket * 0.28;
        }
        else if (taxableIncome > 191650 && taxableIncome < 416700) {
            //$46,643.75 plus 33% of the amount over $191,650
            taxBill += firstBracket * 0.10;
            secondBracket = 37950 - firstBracket;
            taxBill += secondBracket * 0.15;
            thirdBracket = 91900 - 37950;
            taxBill += thirdBracket * 0.25;
            fourthBracket = 191650 - 91900;
            taxBill += fourthBracket * 0.28;
            fifthBracket = taxableIncome - 191650;
            taxBill += fifthBracket * 0.33;
        }
        else if (taxableIncome > 416700 && taxableIncome < 418400){
            //$120,910.25 plus 35% of the amount over $416,700
            taxBill += firstBracket * 0.10;
            secondBracket = 37950 - firstBracket;
            taxBill += secondBracket * 0.15;
            thirdBracket = 91900 - 37950;
            taxBill += thirdBracket * 0.25;
            fourthBracket = 191650 - 91900;
            taxBill += fourthBracket * 0.28;
            fifthBracket = 416700 - 191650;
            taxBill += fifthBracket * 0.33;
            sixthBracket = taxableIncome - 416700;
            taxBill += sixthBracket * 0.35;
        }
        else if (taxableIncome > 418400){
            //$121,505.25 plus 39.6% of the amount over $418,400
            taxBill += firstBracket * 0.10;
            secondBracket = 37950 - firstBracket;
            taxBill += secondBracket * 0.15;
            thirdBracket = 91900 - 37950;
            taxBill += thirdBracket * 0.25;
            fourthBracket = 191650 - 91900;
            taxBill += fourthBracket * 0.28;
            fifthBracket = 416700 - 191650;
            taxBill += fifthBracket * 0.33;
            sixthBracket = 418400 - 416700;
            taxBill += sixthBracket * 0.35;
            seventhBracket = taxableIncome - 418400;
            taxBill += seventhBracket * 0.396;
        }
        return taxBill;
    }

    public double determineMarriedJointlyTaxBill(double income, double deductible){
        double taxableIncome = income - deductible;
        double firstBracket = 18650;
        double secondBracket;
        double thirdBracket;
        double fourthBracket;
        double fifthBracket;
        double sixthBracket;
        double seventhBracket;
        double taxBill = 0.00;

        if(taxableIncome <= 18650){
            taxBill += taxableIncome * 0.10;
        }
        else if (taxableIncome > 18650 && taxableIncome < 75900){
            taxBill += firstBracket * 0.10;
            secondBracket = taxableIncome - firstBracket;
            taxBill += secondBracket * 0.15;
        }
        else if (taxableIncome > 75900 && taxableIncome < 153100){
            taxBill += firstBracket * 0.10;
            secondBracket = 18650 - firstBracket;
            taxBill += secondBracket * 0.15;
            thirdBracket = taxableIncome - 75900;
            taxBill += thirdBracket * 0.25;
        }
        else if (taxableIncome > 153100 && taxableIncome < 233350){
            taxBill += firstBracket * 0.10;
            secondBracket = 18650 - firstBracket;
            taxBill += secondBracket * 0.15;
            thirdBracket = 153100 - 75900;
            taxBill += thirdBracket * 0.25;
            fourthBracket = taxableIncome - 153100;
            taxBill += fourthBracket * 0.28;
        }
        else if (taxableIncome > 233350 && taxableIncome < 416700) {
            taxBill += firstBracket * 0.10;
            secondBracket = 18650 - firstBracket;
            taxBill += secondBracket * 0.15;
            thirdBracket = 153100 - 75900;
            taxBill += thirdBracket * 0.25;
            fourthBracket = 233350 - 153100;
            taxBill += fourthBracket * 0.28;
            fifthBracket = taxableIncome - 233350;
            taxBill += fifthBracket * 0.33;
        }
        else if (taxableIncome > 416700 && taxableIncome < 470700){
            taxBill += firstBracket * 0.10;
            secondBracket = 18650 - firstBracket;
            taxBill += secondBracket * 0.15;
            thirdBracket = 153100 - 75900;
            taxBill += thirdBracket * 0.25;
            fourthBracket = 233350 - 153100;
            taxBill += fourthBracket * 0.28;
            fifthBracket = 416700 - 233350;
            taxBill += fifthBracket * 0.33;
            sixthBracket = taxableIncome - 416700;
            taxBill += sixthBracket * 0.35;
        }
        else if (taxableIncome > 418400){
            taxBill += firstBracket * 0.10;
            secondBracket = 18650 - firstBracket;
            taxBill += secondBracket * 0.15;
            thirdBracket = 153100 - 75900;
            taxBill += thirdBracket * 0.25;
            fourthBracket = 233350 - 153100;
            taxBill += fourthBracket * 0.28;
            fifthBracket = 416700 - 233350;
            taxBill += fifthBracket * 0.33;
            sixthBracket = 470700 - 416700;
            taxBill += sixthBracket * 0.35;
            seventhBracket = taxableIncome - 470700;
            taxBill += seventhBracket * 0.396;
        }
        return taxBill;
    }
}
