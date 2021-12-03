package code.maman12.ex1;

public class ConcreteEmployee extends Employee {
    public ConcreteEmployee(String firstName, String lastName, String socialSecurityNumber, Birthday birthday){
        super(firstName, lastName, socialSecurityNumber, birthday);
    }    

    public double earnings()
    {
        if (this.birthday.isBirthdayMonth()){
            return 200.0;
        }
        return 0.0;
    }
}
