public class LoanUtils {

    /*
     * Five clean-code violations in the original method:
     *
     * 1. Poor method name "calc" does not clearly describe the operation.
     * 2. Meaningless parameter names "a", "b", and "c".
     * 3. Meaningless variable names "r" and "i".
     * 4. Magic number "1200" is used without explanation.
     * 5. Poor formatting and missing braces make the code difficult to read.
     */

    /**
     * Calculates the compound loan amount using a monthly interest rate.
     *
     * @param principal the initial loan principal
     * @param annualInterestRate the annual interest rate in percentage
     * @param months the number of months
     * @return the calculated compound loan amount
     */
    public double calculateCompoundAmount(double principal, double annualInterestRate, int months) {
        final double MONTHS_PER_YEAR = 12.0;
        double compoundAmount = principal;

        for (int month = 0; month < months; month++) {
            compoundAmount *= 1 + annualInterestRate / (MONTHS_PER_YEAR * 100);
        }

        return compoundAmount;
    }
}