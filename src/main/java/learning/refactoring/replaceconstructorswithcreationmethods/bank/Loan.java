package learning.refactoring.replaceconstructorswithcreationmethods.bank;

import learning.refactoring.replaceconstructorswithcreationmethods.bank.strategy.CapitalStrategy;
import learning.refactoring.replaceconstructorswithcreationmethods.bank.strategy.CapitalStrategyRCTL;
import learning.refactoring.replaceconstructorswithcreationmethods.bank.strategy.CapitalStrategyRevolver;
import learning.refactoring.replaceconstructorswithcreationmethods.bank.strategy.CapitalStrategyTermLoan;

import java.time.LocalDate;

/**
 * A term loan is a loan that must be fully paid by its maturity date.
 * A revolver, which is like a credit card, is a loan that signifies "revolving credit": you have a spending limit and an expiry date.
 * A revolving credit term loan (RCTL) is a revolver that transforms into a term loan when the revolver expires
 */
public class Loan {
    private CapitalStrategy capitalStrategy;
    private double commitment;
    private double outstanding;
    private int riskRating;
    private LocalDate maturity;
    private LocalDate expiry;

    public static Loan createTermLoan(double commitment, int riskRating, LocalDate maturity) {
        return new Loan(commitment, riskRating, maturity, null, 0.00, null);
    }

    public static Loan createTermLoan(double commitment, int riskRating, LocalDate maturity, double outstanding, CapitalStrategy capitalStrategy) {
        return new Loan(commitment, riskRating, maturity, null, outstanding, capitalStrategy);
    }

    public static Loan createRevolver(double commitment, int riskRating, LocalDate expiry, double outstanding) {
        return new Loan(commitment, riskRating, null, expiry, outstanding, null);
    }

    public static Loan createRevolver(double commitment, int riskRating, LocalDate expiry, CapitalStrategy capitalStrategy, double outstanding) {
        return new Loan(commitment, riskRating, null, expiry, outstanding, capitalStrategy);
    }

    public static Loan createRevolvingCreditTermLoan(double commitment, int riskRating, LocalDate maturity, LocalDate expiry, double outstanding) {
        return new Loan(commitment, riskRating, maturity, expiry, outstanding, null);
    }

    public static Loan createRevolvingCreditTermLoan(double commitment, int riskRating, LocalDate maturity, LocalDate expiry, double outstanding, CapitalStrategy capitalStrategy) {
        return new Loan(commitment, riskRating, maturity, expiry, outstanding, capitalStrategy);
    }

    /**
     * Revolving credit term loan (all parameters)
     */
    public Loan(double commitment, int riskRating, LocalDate maturity, LocalDate expiry, double outstanding, CapitalStrategy capitalStrategy) {
        this.commitment = commitment;
        this.outstanding = outstanding;
        this.riskRating = riskRating;
        this.maturity = maturity;
        this.expiry = expiry;
        this.capitalStrategy = capitalStrategy;

        if (capitalStrategy == null) {
            if (expiry == null) {
                this.capitalStrategy = new CapitalStrategyTermLoan();
            } else if (maturity == null) {
                this.capitalStrategy = new CapitalStrategyRevolver();
            } else {
                this.capitalStrategy = new CapitalStrategyRCTL();
            }
        }
    }
}