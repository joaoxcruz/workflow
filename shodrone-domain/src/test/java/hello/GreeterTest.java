package hello;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GreeterTest {

    private final Greeter greeter = new Greeter(); 

    @Test 
    void greeterSaysHello() { 
        String result = greeter.sayHello();
        assertNotNull(result, "Greeting should not be null"); 
        assertTrue(result.contains("Hello world!"), "Greeting should contain 'Hello world!'"); 
        
    }
}