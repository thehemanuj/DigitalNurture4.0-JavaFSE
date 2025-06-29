package mockito_advanced;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ApiServiceTest {
    @Test
    public void testServiceWithMockRestClient() {
        // 1. Create mock REST client
        RestClient mockRestClient = mock(RestClient.class);
        
        // 2. Stub the REST client method
        when(mockRestClient.getResponse()).thenReturn("Mock Response");

        // 3. Test the service
        ApiService apiService = new ApiService(mockRestClient);
        String result = apiService.fetchData();

        assertEquals("Fetched Mock Response", result);
        verify(mockRestClient).getResponse();
    }
}