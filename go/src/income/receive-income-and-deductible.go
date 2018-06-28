package income

import "fmt"

func ReceiveIncomeAndDeductible() float64 {

	var i float64
	fmt.Println("Input Gross Annual Income:")
	_, err := fmt.Scan(&i)
	if err != nil {
		fmt.Println(err)
	}
	return i
}
