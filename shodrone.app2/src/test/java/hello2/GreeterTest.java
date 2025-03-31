package hello2;

// Import JUnit 5 annotations and assertions
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


/**
 * A comment
 */
public class GreeterTest {

    private final Greeter greeter = new Greeter(); // Can be final

    @Test // Use JUnit 5 @Test
    void greeterSaysHello() { // Test methods don't need to be public in JUnit 5
        String result = greeter.sayHello();
        assertNotNull(result, "Greeting should not be null"); // Example assertion
        assertTrue(result.contains("Hello"), "Greeting should contain 'Hello'"); // Junit 5 assertion
        // assertEquals("Hello world!", result); // If the test logic was changed from original example
    }
}