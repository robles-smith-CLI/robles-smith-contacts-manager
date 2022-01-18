package ContactsApp;

public class ContactInfo {
    protected String name;
    protected Long number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public ContactInfo(String name, Long number) {
        this.name = name;
        this.number = number;
    }
@Override
   public String toString() {
        return String.format("%-7s | %-12d |", this.name, this.number);
   }

    public ContactInfo() {
    }
}
