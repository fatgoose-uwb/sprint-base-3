package Problem4Test;

// DO NOT REMOVE OR CHANGE ANYTHING

public class TaxCalculatorTestCase {
    public int annualEarning;
    public int expectedTaxRateInPercentage;

    public TaxCalculatorTestCase(int annualEarning, int expectedTaxRateInPercentage) {
        this.annualEarning = annualEarning;
        this.expectedTaxRateInPercentage = expectedTaxRateInPercentage;
    }

    @Override
    public String toString() {
        return "TestCase{" +
                "annualEarning=" + annualEarning +
                ", expectedTaxRateInPercentage=" + expectedTaxRateInPercentage +
                '}';
    }
}