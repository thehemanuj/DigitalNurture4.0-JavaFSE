package mockito_advanced;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NetworkServiceTest {
    @Test
    public void testServiceWithMockNetworkClient() {
        // 1. Create mock network client
        NetworkClient mockNetworkClient = mock(NetworkClient.class);
        
        // 2. Stub the network client method
        when(mockNetworkClient.connect()).thenReturn("Mock Connection");

        // 3. Test the service
        NetworkService networkService = new NetworkService(mockNetworkClient);
        String result = networkService.connectToServer();

        assertEquals("Connected to Mock Connection", result);
        verify(mockNetworkClient).connect();
    }
}