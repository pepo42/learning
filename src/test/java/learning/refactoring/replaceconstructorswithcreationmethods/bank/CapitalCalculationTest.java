package learning.refactoring.replaceconstructorswithcreationmethods.bank;

import learning.refactoring.replaceconstructorswithcreationmethods.bank.strategy.CapitalStrategyTermLoan;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class CapitalCalculationTest {

    @Test
    void shouldCalculateTermLoanNoPayments1() {
        // creation of termLoan
        Loan termLoan = new Loan(1.0d, 2, LocalDate.now());

        // when, then
        // call and verification of the results
    }

    @Test
    void shouldCalculateTermLoanNoPayments2() {
        // creation of termLoan
        Loan termLoan = new Loan(1.0d, 2, LocalDate.now(), 1.0d, new CapitalStrategyTermLoan());

        // when, then
        // call and verification of the results
    }
}