package code.maman12.ex1;

public class BasePlusCommissionEmployee extends CommissionEmployee {
    private double baseSalary;

    public BasePlusCommissionEmployee(String firstName, String lastName, String socialSecurityNumber,
            double grossSales, double commissionRate, double baseSalary, Birthday birthday) {
        super(firstName, lastName, socialSecurityNumber,
                grossSales, commissionRate, birthday);

        if (baseSalary < 0) {
            throw new IllegalArgumentException("Base salary must be >= 0");
        }

        this.baseSalary = baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        if (baseSalary < 0) {
            throw new IllegalArgumentException("Base salary must be >= 0");
        }

        this.baseSalary = baseSalary;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    @Override
    public double earnings() {
        return getBaseSalary() + super.earnings();
    }

    @Override
    public String toString() {
        return String.format("%s, %s %s; $s: $%.2f",
                "Base-salaried", super.toString(), "Base salary", getBaseSalary());
    }

}
