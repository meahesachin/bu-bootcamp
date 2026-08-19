public class Contact {

    //Define private fields for name and phone number
    private String name;
    private String phone;

    //Constructor to initialize the name and phone number
    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    //Getter methods for name and phone number
    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    //Override the toString() method to provide a string representation of the contact
    @Override
    public String toString() {
        return "contact{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';    
    }
}
