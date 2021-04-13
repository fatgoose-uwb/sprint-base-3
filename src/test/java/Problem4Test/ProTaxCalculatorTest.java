package Problem4Test;

import Problem4.ProTaxCalculator;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

// DO NOT REMOVE OR CHANGE ANYTHING

public class ProTaxCalculatorTest {

    private final int[] stops = {0, 10275, 41775, 89075, 170050, 215950, 539900, Integer.MAX_VALUE};
    private final int[] taxRate = {0, 10, 12, 22, 24, 32, 35, 37};
    private final ProTaxCalculator proTaxCalculator = new ProTaxCalculator(stops, taxRate);

    /*
    This test validates the function with a few input samples.
    It passes with the given (wrong) implementation c( O.O )ɔ
     */
    @Test
    public void testTaxCalculatorSampling() {
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
            int actualTaxRate = proTaxCalculator.calculate(testCase.annualEarning);
            assertEquals(testCase.expectedTaxRateInPercentage, actualTaxRate, testCase.toString());

        }
    }

    /*
    This test validates function all possible inputs between MIN_EARNING_RANGE and MAX_EARNING_RANGE.
     */
    @Test
    public void testTaxCalculatorComprehensive() {
        final int MIN_EARNING_RANGE = -50;
        final int MAX_EARNING_RANGE = 1000000;

        int expectedVerifiedEarnings = MAX_EARNING_RANGE + (Math.abs(MIN_EARNING_RANGE));

        // Being obsessive here. count how many unique earnings have been validated.
        Set<Integer> uniqueValidatedEarnings = new HashSet<>();

        int earningStart = MIN_EARNING_RANGE;

        for (int i = 0; i < stops.length; i++) {

            int stop = stops[i];
            int expectTaxRate = taxRate[i];

            for (int earning = earningStart; earning <= stop && earning < MAX_EARNING_RANGE; earning++) {

                int actualTaxRate = proTaxCalculator.calculate(earning);

                assertEquals(expectTaxRate, actualTaxRate, earning + " failed");

                uniqueValidatedEarnings.add(earning);
            }
            earningStart = stop + 1;
        }
        assertEquals(expectedVerifiedEarnings, uniqueValidatedEarnings.size());
    }
}