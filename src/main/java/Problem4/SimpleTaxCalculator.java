// based on the 2022 IRS info
// https://www.irs.gov/newsroom/irs-provides-tax-inflation-adjustments-for-tax-year-2022
// Single filing

package Problem4;

// DO NOT REMOVE OR CHANGE ANYTHING

// This file is included for study purpose.

public class SimpleTaxCalculator {

    /*
    This code "couples" data (those bracket numbers) with logics.
    This makes the code very limited because it will only work for 2022 input. Any year after that with the data updated,
    the code would need to be updated too.
     */
    public static int calculate(int earning) {
        if (earning <= 0) {
            return 0;
        }
        if (earning <= 10275) {
            return 10;
        }
        if (earning <= 41775) {
            return 12;
        }
        if (earning <= 89075) {
            return 22;
        }
        if (earning <= 170050) {
            return 24;
        }
        if (earning <= 215950) {
            return 32;
        }
        if (earning <= 539900) {
            return 35;
        }

        return 37;
    }
}