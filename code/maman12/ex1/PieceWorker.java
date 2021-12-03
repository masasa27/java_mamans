package code.maman12.ex1;

public class PieceWorker extends ConcreteEmployee {
    private int itemCount; 
    private int itemCost; 

    public PieceWorker(String firstName, String lastName, String socialSecurityNumber, int itemCount, int itemCost, Birthday birthday){
        super(firstName, lastName, socialSecurityNumber, birthday);
        this.itemCount = itemCount;
        this.itemCost = itemCost;
    }    

    public double earnings(){
        return this.itemCount * this.itemCost + super.earnings();
    }
    
    public double getItemCount(){
        return this.itemCount;
    }

    public double getItemCost(){
        return this.itemCost;
    }
    
    @Override
    public String toString() {
        return String.format("PieceMaker employee: %s%n%s : $%.2f; %s: %,.2f",
                super.toString(), "ItemCost", getItemCost(), "item count", getItemCount(), earnings());
    }
}
