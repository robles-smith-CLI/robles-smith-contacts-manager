package ContactsApp;

public class ContactInfo {
    protected String name;
    protected String number;

    public ContactInfo(String text) {
        String[]textarray = text.split("|");
        textarray[0] = this.name;
        textarray[1] = this.number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public ContactInfo(String name, String number) {
        this.name = name;
        this.number = number;
    }
@Override
   public String toString() {
        return String.format("%-15s | %-14s |", this.name, this.number);
   }

    public ContactInfo() {
    }
}
