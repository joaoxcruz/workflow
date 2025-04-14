package hello; // Make sure this matches your folder structure

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Try importing a class from the EAPLI framework
// If this import line shows an error in your IDE *after* reloading Maven,
// the dependency was not found.
import eapli.framework.validations.Preconditions;

/**
 * Simple test to verify that classes from the EAPLI framework dependency
 * can be resolved during compilation and loaded at runtime.
 */
public class EapliFrameworkIntegrationTest {

    @Test
    void testFrameworkClassIsAccessibleAndUsable() {
        // Arrange: Create a simple object to test with
        String testObject = "This is definitely not null";
        String testName = "Test Object Name";
        Object nullObject = null;

        // Act & Assert 1: Call a static method from the framework with a non-null value.
        // If the framework JAR is not on the classpath or cannot be loaded,
        // this execution would likely throw a NoClassDefFoundError or ClassNotFoundException at runtime.
        // assertDoesNotThrow verifies that executing the lambda doesn't throw an exception.
        assertDoesNotThrow(() -> {
            Preconditions.nonNull(testObject, testName); // Use the framework class
            System.out.println(">>> Successfully called eapli.framework.validations.Preconditions.nonNull() with non-null object.");
        }, "Should be able to call EAPLI Preconditions class static method without runtime errors.");

        // Act & Assert 2: Call the same method with a null value to ensure it behaves as expected
        // (throws an exception). This further confirms the framework code is actually running.
        assertThrows(IllegalArgumentException.class, () -> {
            Preconditions.nonNull(nullObject, "Null test object"); // This is expected to throw
        }, "EAPLI Preconditions.nonNull should throw IllegalArgumentException for null input.");
        System.out.println(">>> Successfully verified Preconditions throws expected exception for null object.");

        // Act & Assert 3: Just declare a variable of another framework type to check compile-time resolution.
        eapli.framework.domain.model.ValueObject testVO = null;
        assertNull(testVO, "Framework ValueObject type should be resolvable (compile-time check passed).");
        System.out.println(">>> Successfully declared a variable of type eapli.framework.domain.model.ValueObject.");
    }
}
