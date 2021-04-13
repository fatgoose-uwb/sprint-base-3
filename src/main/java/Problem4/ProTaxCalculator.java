package Problem4;

// This "pro" version tax calculator uses data passed in from the outside, and therefore the data and logic are no
// longer coupled. As a result, no code change is required when different data is used for computation.
public class ProTaxCalculator {
    // TODO (optional): your code here

    // this pro-calculator is initialized with earning range stops and corresponding tax rates
    public ProTaxCalculator(int[] stops, int[] taxRates) {
        // TODO: your code here
    }

    public int calculate(int target) {
        // The following code was able to pass the testTaxCalculatorSampling test,
        // but it fails the testTaxCalculatorComprehensive. This shows testTaxCalculatorSampling
        // by itself is not a good test because it only tests ("covers") a very limited number of inputs.
        // testTaxCalculatorComprehensive is a more comprehensive test that covers way more inputs

        // TODO: rewrite this function to pass all tests
        // DO NOT hardcode any value (numbers) in this entire class.
        // Use the stops and taxRate passed in from the constructor.

        switch (target) {   // bad implementation
            case -1:
                return 0;
            case 5000:
                return 10;
            case 20000:
                return 12;
            case 70000:
                return 22;
            case 150000:
                return 24;
            case 180000:
                return 32;
            case 300000:
                return 35;
            default:
                return 37;
        }
    }
}