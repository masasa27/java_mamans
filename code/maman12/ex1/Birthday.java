package code.maman12.ex1;
import java.util.Calendar;

public class Birthday {
    public Calendar today = Calendar.getInstance();
    public int day;
    public int month;
    public int year;

    public Birthday(int day, int month, int year) {
        this.day = day;
        this.month = month;        this.year = year;
    }

    public Boolean isBirthdayMonth() {
        return (this.month == this.today.get(Calendar.MONTH) + 1);
    }

    public String toString() {
        return String.format("Birthday %d/%d/%d", this.day, this.month, this.year);
    }
}
