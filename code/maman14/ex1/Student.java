package code.maman14.ex1;

public class Student {

    private String firstName;
    private String lastName;
    private String id;
    private int birthYear;
    private String phoneNumber;

    public Student(String firstName, String lastName, String id, int birthYear, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.birthYear = birthYear;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString()
    {
        return this.phoneNumber;
    }

    @Override
    public boolean equals(Object o)
    {
        Student other = (Student) o;
        return this.id.equals(other.id);
    }

    
}
