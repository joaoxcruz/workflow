package hello;

// Use JUnit 5 imports
import org.junit.jupiter.api.Test;
// Import Hamcrest statically
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
// Optional: Import JUnit 5 assertions if preferred
// import static org.junit.jupiter.api.Assertions.*;

/**
 * A comment
 */
class GreeterTest { // Class can be package-private

	private final Greeter greeter = new Greeter(); // Can be final

	@Test // JUnit 5 annotation
	void greeterSaysHello() { // Method can be package-private, no 'public' needed
		assertThat(greeter.sayHello(), containsString("Hello world!"));

		// Alternative using only JUnit 5 assertions:
		// String result = greeter.sayHello();
		// assertNotNull(result);
		// assertTrue(result.contains("Hello world!"), "Greeting should contain 'Hello world!'");
	}
}