package code.maman12.ex1;

public abstract class Employee {
    private final String firstName;
    private final String lastName;
    private final String socialSecurityNumber;
    protected final Birthday birthday;

    public Employee(String firstName, String lastName, String socialSecurityNumber, Birthday birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
        this.birthday = birthday;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public Birthday getBirthday() {
        return this.birthday;
    }

    @Override
    public String toString() {
        if (birthday.isBirthdayMonth())
        {
            return String.format("%s %s%nsocial security number: %s \nbirthday: %s \n Today its the Employee Birthday month, Extra 200 added to his salary!",
                getFirstName(), getLastName(), getSocialSecurityNumber(), getBirthday());
        }

        return String.format("%s %s%nsocial security number: %s \nbirthday: %s",
                getFirstName(), getLastName(), getSocialSecurityNumber(), getBirthday());
    }

    public abstract double earnings();
}
