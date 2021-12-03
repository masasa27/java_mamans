package code.maman12.ex1;

public class WorkerManagement {
    private Employee[] employees;

    public WorkerManagement(Employee[] employees) {
        this.employees = employees;
    }

    public WorkerManagement()
    {
        SalariedEmployee salariedEmployee = new SalariedEmployee("John", "Smith", "111-11-1111", 800.00, new Birthday(31,03,1995));
        HourlyEmployee hourlyEmployee = new HourlyEmployee("Karen", "Price", "222-22-2222", 16.75, 40, new Birthday(07,12,1995));
        CommissionEmployee commissionEmployee = new CommissionEmployee(
              "Sue", "Jones", "333-33-3333", 10000, .06, new Birthday(9,11,1995));
        BasePlusCommissionEmployee basePlusCommissionEmployee = new BasePlusCommissionEmployee(
              "Bob", "Lewis", "444-44-4444", 5000, .04, 300, new Birthday(11,06,1995));
        PieceWorker basePieceWorker = new PieceWorker("dorel", "masasa", "555-55-55", 30, 64, new Birthday(31,03,1995));
  

        employees = new Employee[5];
  
        employees[0] = salariedEmployee;
        employees[1] = hourlyEmployee;
        employees[2] = commissionEmployee;
        employees[3] = basePlusCommissionEmployee;
        employees[4] = basePieceWorker;
    }

    
    public void printWorkers()
    {
        for (Employee currentEmployee : employees)
         {
            System.out.println(currentEmployee); // invokes toString
            System.out.printf("employee earnings $%,.2f\n", currentEmployee.earnings());
         }
    }
}
