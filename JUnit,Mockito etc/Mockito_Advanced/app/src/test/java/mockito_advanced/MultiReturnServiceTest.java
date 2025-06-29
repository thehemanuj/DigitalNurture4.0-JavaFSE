package mockito_advanced;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MultiReturnServiceTest {
    @Test
    public void testServiceWithMultipleReturnValues() {
        // 1. Create a mock of the Repository class
        Repository mockRepository = mock(Repository.class);
        
        // 2. Stub method to return different values on consecutive calls
        when(mockRepository.getData())
            .thenReturn("First Mock Data")
            .thenReturn("Second Mock Data");

        // 3. Test the service with multiple calls
        Service service = new Service(mockRepository);
        String firstResult = service.processData();
        String secondResult = service.processData();

        assertEquals("Processed First Mock Data", firstResult);
        assertEquals("Processed Second Mock Data", secondResult);
        
        // Verify the method was called twice
        verify(mockRepository, times(2)).getData();
    }
}