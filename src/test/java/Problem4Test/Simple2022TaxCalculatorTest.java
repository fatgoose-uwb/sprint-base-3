package Problem4Test;

import Problem4.SimpleTaxCalculator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

// DO NOT REMOVE OR CHANGE ANYTHING

// this test is included for study purpose

public class Simple2022TaxCalculatorTest {
    @Test
    public void testTaxCalculator() {
        List<TaxCalculatorTestCase> testCases = new ArrayList<>(Arrays.asList(
                new TaxCalculatorTestCase(-1, 0),
                new TaxCalculatorTestCase(5000, 10),
                new TaxCalculatorTestCase(20000, 12),
                new TaxCalculatorTestCase(70000, 22),
                new TaxCalculatorTestCase(150000, 24),
                new TaxCalculatorTestCase(180000, 32),
                new TaxCalculatorTestCase(300000, 35),
                new TaxCalculatorTestCase(549900, 37)
        ));

        for (TaxCalculatorTestCase testCase : testCases) {
            int actualTaxRate = SimpleTaxCalculator.calculate(testCase.annualEarning);
            assertEquals(testCase.expectedTaxRateInPercentage, actualTaxRate, testCase.toString());
        }
    }

    @Test
    public void testTaxCalculatorSimple() {
        int actualTaxRate = SimpleTaxCalculator.calculate(10);
        int expectTaxRate = 10;
        assertEquals(expectTaxRate, actualTaxRate);

        actualTaxRate = SimpleTaxCalculator.calculate(5000);
        assertEquals(expectTaxRate, actualTaxRate);

        actualTaxRate = SimpleTaxCalculator.calculate(20000);
        expectTaxRate = 12;
        assertEquals(expectTaxRate, actualTaxRate);

        actualTaxRate = SimpleTaxCalculator.calculate(70000);
        expectTaxRate = 22;
        assertEquals(expectTaxRate, actualTaxRate);

        actualTaxRate = SimpleTaxCalculator.calculate(150000);
        expectTaxRate = 24;
        assertEquals(expectTaxRate, actualTaxRate);

        actualTaxRate = SimpleTaxCalculator.calculate(180000);
        expectTaxRate = 32;
        assertEquals(expectTaxRate, actualTaxRate);

        actualTaxRate = SimpleTaxCalculator.calculate(300000);
        expectTaxRate = 35;
        assertEquals(expectTaxRate, actualTaxRate);

        actualTaxRate = SimpleTaxCalculator.calculate(549900);
        expectTaxRate = 37;
        assertEquals(expectTaxRate, actualTaxRate);
    }

    @Test
    public void testTaxCalculatorBetter() {

        int[] earnings = {10, 5000, 20000, 60000, 150000, 180000, 300000, 549900};
        int[] expectedTaxRate = {10, 10, 12, 22, 24, 32, 35, 37};

        assertEquals(expectedTaxRate.length, earnings.length);

        for (int i = 0; i < earnings.length; i++) {
            int earning = earnings[i];
            int expectTaxRate = expectedTaxRate[i];

            int actualTaxRate = SimpleTaxCalculator.calculate(earning);

            assertEquals(expectTaxRate, actualTaxRate);
        }
    }
}
