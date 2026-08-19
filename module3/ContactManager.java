import java.util.*; 
 
public class ContactManager { 

    private static HashMap<String, Contact> contacts = new HashMap<>(); 
 
    public static void main(String[] args) { 
 
        
 
        // Step 4: add contacts here 
        contacts.put("John Doe", new Contact("John Doe", "123-456-7890"));
        contacts.put("Jane Smith", new Contact("Jane Smith", "098-765-4321"));
        contacts.put("Alice Johnson", new Contact("Alice Johnson", "555-555-5555"));
        contacts.put("Bob Brown", new Contact("Bob Brown", "111-222-3333"));
        contacts.put("Charlie Davis", new Contact("Charlie Davis", "444-555-6666"));
        contacts.put("REMOVE Wilson", new Contact("REMOVE Wilson", "777-888-9999"));

 
        // Step 5: look up a contact 
        System.out.println("\n\n Looking up existing contact:");
        Contact contact = contacts.get("John Doe");
        if (contact != null) {
            System.out.println(contact);
        }
        else {
            System.out.println("Contact not found.");
        }

        System.out.println("\n\n Looking up non-existing contact:");
        contact = contacts.get("Jim Doe");
        if (contact != null) {
            System.out.println(contact);
        }
        else {
            System.out.println("Contact not found.");
        }
 
        // Step 6: print sorted list

        System.out.println("\n\n Sorted BEFORE removing contact:");
        ArrayList<Contact> sorted = new ArrayList<>(contacts.values());  
        sorted.sort((a, b) -> a.getName().compareTo(b.getName()));  

        for (Contact c : sorted) {
            System.out.println(c);
        }
        
        removeContact("REMOVE Wilson");

        System.out.println("\n\n AFTER removing contact:");

        sorted = new ArrayList<>(contacts.values());
        sorted.sort((a, b) -> a.getName().compareTo(b.getName()));

        for (Contact c : sorted) {
            System.out.println(c);
        }

    } 

    private static void removeContact(String name) {
        contacts.remove(name);
    }

}