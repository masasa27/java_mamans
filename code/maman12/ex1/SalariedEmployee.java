package code.maman12.ex1;


public class SalariedEmployee extends Employee {
    private double weeklySalary;

    public SalariedEmployee(String firstName, String lastName,
                            String socialSecurityNumber, double weeklySalary, Birthday birthday) {
        super(firstName, lastName, socialSecurityNumber, birthday);

        if(weeklySalary < 0){
            throw new IllegalArgumentException("Weekly salary must be >= 0");
        }

        this.weeklySalary = weeklySalary;
    }

    public void setWeeklySalary(double weeklySalary) {
        if(weeklySalary < 0){
            throw new IllegalArgumentException("Weekly salary must be >= 0");
        }

        this.weeklySalary = weeklySalary;
    }

    public double getWeeklySalary() {
        return weeklySalary;
    }

    @Override
    public double earnings() {
        return getWeeklySalary();
    }

    @Override
    public String toString() {
        return String.format("Salaried employee: %s%n%s: $%.2f",
                super.toString(), "Weekly salary", getWeeklySalary());
    }
}
