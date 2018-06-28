package main

//DetermineMarriedJointlyTaxBill
//Determines tax rate for reporting as married, filing jointly
func DetermineMarriedJointlyTaxBill(income, deductible float64) float64 {
	var firstBracket, secondBracket, thirdBracket, fourthBracket, fifthBracket, sixthBracket, seventhBracket, taxBill float64
	firstBracket = 18650
	taxableIncome := income - deductible
	if taxableIncome <= 18650 {
		taxBill += taxableIncome * 0.10
	} else if taxableIncome > 18650 && taxableIncome < 75900 {
		taxBill += firstBracket * 0.10
		secondBracket = taxableIncome - firstBracket
		taxBill += secondBracket * 0.15
	} else if taxableIncome > 75900 && taxableIncome < 153100 {
		taxBill += firstBracket * 0.10
		secondBracket = 18650 - firstBracket
		taxBill += secondBracket * 0.15
		thirdBracket = taxableIncome - 75900
		taxBill += thirdBracket * 0.25
	} else if taxableIncome > 153100 && taxableIncome < 233350 {
		taxBill += firstBracket * 0.10
		secondBracket = 18650 - firstBracket
		taxBill += secondBracket * 0.15
		thirdBracket = 153100 - 75900
		taxBill += thirdBracket * 0.25
		fourthBracket = taxableIncome - 153100
		taxBill += fourthBracket * 0.28
	} else if taxableIncome > 233350 && taxableIncome < 416700 {
		taxBill += firstBracket * 0.10
		secondBracket = 18650 - firstBracket
		taxBill += secondBracket * 0.15
		thirdBracket = 153100 - 75900
		taxBill += thirdBracket * 0.25
		fourthBracket = 233350 - 153100
		taxBill += fourthBracket * 0.28
		fifthBracket = taxableIncome - 233350
		taxBill += fifthBracket * 0.33
	} else if taxableIncome > 416700 && taxableIncome < 470700 {
		taxBill += firstBracket * 0.10
		secondBracket = 18650 - firstBracket
		taxBill += secondBracket * 0.15
		thirdBracket = 153100 - 75900
		taxBill += thirdBracket * 0.25
		fourthBracket = 233350 - 153100
		taxBill += fourthBracket * 0.28
		fifthBracket = 416700 - 233350
		taxBill += fifthBracket * 0.33
		sixthBracket = taxableIncome - 416700
		taxBill += sixthBracket * 0.35
	} else if taxableIncome > 418400 {
		taxBill += firstBracket * 0.10
		secondBracket = 18650 - firstBracket
		taxBill += secondBracket * 0.15
		thirdBracket = 153100 - 75900
		taxBill += thirdBracket * 0.25
		fourthBracket = 233350 - 153100
		taxBill += fourthBracket * 0.28
		fifthBracket = 416700 - 233350
		taxBill += fifthBracket * 0.33
		sixthBracket = 470700 - 416700
		taxBill += sixthBracket * 0.35
		seventhBracket = taxableIncome - 470700
		taxBill += seventhBracket * 0.396
	}
	return taxBill
}
