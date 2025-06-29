package junit_advanced;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExceptionThrowerTest {

    @Test
    void shouldThrowIllegalState() {
        ExceptionThrower et = new ExceptionThrower();
        assertThrows(IllegalStateException.class, et::throwException);
    }
}
