package code.maman12.ex1;

public class CommissionEmployee extends Employee {
    private double grossSales;
    private double commissionRate;

    public CommissionEmployee(String firstName, String lastName, String socialSecurityNumber,
            double grossSales, double commissionRate) {
        super(firstName, lastName, socialSecurityNumber);

        if (commissionRate <= 0 || commissionRate >= 1) {
            throw new IllegalArgumentException("Commission rate must be > 0 and < 1");
        }

        if (grossSales < 0) {
            throw new IllegalArgumentException("Gross sales must be >= 0");
        }

        this.grossSales = grossSales;
        this.commissionRate = commissionRate;
    }

    public void setGrossSales(double grossSales) {
        if (grossSales < 0) {
            throw new IllegalArgumentException("Gross sales must be >= 0");
        }

        this.grossSales = grossSales;
    }

    public void setCommissionRate(double commissionRate) {
        if (commissionRate <= 0 || commissionRate >= 1) {
            throw new IllegalArgumentException("Commission rate must be > 0 and < 1");
        }

        this.commissionRate = commissionRate;
    }

    public double getGrossSales() {
        return grossSales;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    @Override
    public double earnings() {
        return getCommissionRate() * getGrossSales();
    }

    @Override
    public String toString() {
        return String.format("Commission employee: %s%n%s: $%.2f; %s: %.2f",
                super.toString(), "Gross sales", getGrossSales(), "Commission rate", getCommissionRate());
    }
}
