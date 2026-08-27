import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach; 
 
public class ContactTest { 


    static Contact c;

    @BeforeEach
    void setup() {
        c = new Contact("Ada Lovelace", "+1 617 555 0101");
    }

 
  @Test 
  void constructor_setsNameCorrectly() { 
    //Check that the constructor sets the name correctly and getName returns the correct value
    assertEquals("Ada Lovelace", c.getName()); 
  } 
 
  @Test
  void constructor_setsPhoneCorrectly() { 
    //Check that the constructor sets the phone correctly and getPhone returns the correct value
    assertEquals("+1 617 555 0101", c.getPhone()); 
  } 
 
  @Test
  void getName_returnsExactString_notTransformed() { 
    //Check that getName returns the exact string passed to the constructor, without any transformations
    assertEquals("Ada Lovelace", c.getName());
  } 
 
  @Test
  void toString_containsName() { 
    //Check that toString returns a string that contains the name of the contact set in the constructor
    assertTrue(c.toString().contains("Ada Lovelace"));
  } 
 
  @Test
  void toString_containsPhone() {
    //Check that toString returns a string that contains the phone number of the contact set in the constructor
    assertTrue(c.toString().contains("555 0101"));
  }
} 