package code.maman12.ex1;

public class HourlyEmployee extends ConcreteEmployee {
    private double wage;
    private double hours;

    public HourlyEmployee(String firstName, String lastName, String socialSecurityNumber,
            double wage, double hours, Birthday birthday) {
        super(firstName, lastName, socialSecurityNumber, birthday);

        if (wage < 0) {
            throw new IllegalArgumentException("Hourly wage must be >= 0");
        }

        if ((hours < 0) || (hours > 168)) {
            throw new IllegalArgumentException("Hours worked must be >= 0 and <= 168");
        }

        this.wage = wage;
        this.hours = hours;
    }

    public void setWage(double wage) {
        if (wage < 0) {
            throw new IllegalArgumentException("Hourly wage must be >= 0");
        }

        this.wage = wage;
    }

    public void setHours(double hours) {
        if ((hours < 0) || (hours > 168)) {
            throw new IllegalArgumentException("Hours worked must be >= 0 and <= 168");
        }

        this.hours = hours;
    }

    public double getWage() {
        return wage;
    }

    public double getHours() {
        return hours;
    }

    @Override
    public double earnings() {
        if (getHours() <= 40) {
            return getWage() * getHours() + super.earnings();
        } else {
            return 40 * getWage() + (getHours() - 40) * getWage() * 1.5 + super.earnings();
        }
    }

    @Override
    public String toString() {
        return String.format("Hourly employee: %s%n%s : $%.2f; %s: %,.2f",
                super.toString(), "Hourly wage", getWage(), "hours worked", getHours());
    }
}
