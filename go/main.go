package main

import (
	"bufio"
	"fmt"
	"goprograms/taxcalculator/src/income"
	"os"
	"strings"
)

//As long as files are on the same level as Main, can build without importing as package
//just use 'go build .' and .exe will be named (foldername).exe

//For local packages, reference the function by its package, and reference it from the gopath in import
//Example for function a inside package b
//referece b.a, VSC will also try to automatically insert the import

//Also considering
//https://www.thebalancesmb.com/how-to-calculate-deductions-from-employee-paychecks-398721

// type ITaxBracketCalculator interface {
// 	DetermineSingleTaxBill(income, deductible float64) float64
// }

func main() {
	fmt.Println("Welcome to the 2017 tax calculator.")
	//var calculator ITaxBracketCalculator
	fmt.Println("Filing Single, or Married filling jointly")
	buf := bufio.NewReader(os.Stdin)
	filingStatus, err := buf.ReadBytes('\n')
	if err != nil {
		fmt.Println(err)
	}
	s := string(filingStatus[:])
	sLower := strings.ToLower(s)
	var output float64
	if strings.Compare(sLower, "s") == 1 {
		income := income.ReceiveIncomeAndDeductible()
		deductible := 6350.00
		output = DetermineSingleTaxBill(income, deductible)
	} else if strings.Compare(sLower, "m") == 1 {
		income := income.ReceiveIncomeAndDeductible()
		deductible := 12700.00
		output = DetermineMarriedJointlyTaxBill(income, deductible)
	}

	fmt.Println("Your tax requirement for the year is: ", output)
}

func DetermineSingleTaxBill(income, deductible float64) float64 {
	var firstBracket, secondBracket, thirdBracket, fourthBracket, fifthBracket, sixthBracket, seventhBracket, taxBill float64
	firstBracket = 9325.00
	taxableIncome := income - deductible
	if taxableIncome <= 9325.00 {
		taxBill += taxableIncome * 0.10
	} else if taxableIncome > 9325.00 && taxableIncome < 37950 {
		//$932.50 plus 15% of the amount over $9,325
		taxBill += firstBracket * 0.10
		secondBracket = taxableIncome - firstBracket
		taxBill += secondBracket * 0.15
	} else if taxableIncome > 37950 && taxableIncome < 91900 {
		//$5,226.25 plus 25% of the amount over $37,950
		taxBill += firstBracket * 0.10
		secondBracket = 37950 - firstBracket
		taxBill += secondBracket * 0.15
		thirdBracket = taxableIncome - 37950
		taxBill += thirdBracket * 0.25
	} else if taxableIncome > 91900 && taxableIncome < 191650 {
		//$18,713.75 plus 28% of the amount over $91,900
		taxBill += firstBracket * 0.10
		secondBracket = 37950 - firstBracket
		taxBill += secondBracket * 0.15
		thirdBracket = 91900 - 37950
		taxBill += thirdBracket * 0.25
		fourthBracket = taxableIncome - 91900
		taxBill += fourthBracket * 0.28
	} else if taxableIncome > 191650 && taxableIncome < 416700 {
		//$46,643.75 plus 33% of the amount over $191,650
		taxBill += firstBracket * 0.10
		secondBracket = 37950 - firstBracket
		taxBill += secondBracket * 0.15
		thirdBracket = 91900 - 37950
		taxBill += thirdBracket * 0.25
		fourthBracket = 191650 - 91900
		taxBill += fourthBracket * 0.28
		fifthBracket = taxableIncome - 191650
		taxBill += fifthBracket * 0.33
	} else if taxableIncome > 416700 && taxableIncome < 418400 {
		//$120,910.25 plus 35% of the amount over $416,700
		taxBill += firstBracket * 0.10
		secondBracket = 37950 - firstBracket
		taxBill += secondBracket * 0.15
		thirdBracket = 91900 - 37950
		taxBill += thirdBracket * 0.25
		fourthBracket = 191650 - 91900
		taxBill += fourthBracket * 0.28
		fifthBracket = 416700 - 191650
		taxBill += fifthBracket * 0.33
		sixthBracket = taxableIncome - 416700
		taxBill += sixthBracket * 0.35
	} else if taxableIncome > 418400 {
		//$121,505.25 plus 39.6% of the amount over $418,400
		taxBill += firstBracket * 0.10
		secondBracket = 37950 - firstBracket
		taxBill += secondBracket * 0.15
		thirdBracket = 91900 - 37950
		taxBill += thirdBracket * 0.25
		fourthBracket = 191650 - 91900
		taxBill += fourthBracket * 0.28
		fifthBracket = 416700 - 191650
		taxBill += fifthBracket * 0.33
		sixthBracket = 418400 - 416700
		taxBill += sixthBracket * 0.35
		seventhBracket = taxableIncome - 418400
		taxBill += seventhBracket * 0.396
	}
	return taxBill
}

// func ReceiveIncomeAndDeductible() float64 {

// 	var i float64
// 	fmt.Println("Input Gross Annual Income:")
// 	_, err := fmt.Scan(&i)
// 	if err != nil {
// 		fmt.Println(err)
// 	}
// 	return i
// }
