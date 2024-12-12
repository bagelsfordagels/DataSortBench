import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.grpc.ComputeServiceGrpc.ComputeServiceBlockingStub;

import io.grpc.ManagedChannel;
import io.grpc.Server;
import io.grpc.inprocess.InProcessChannelBuilder;
import io.grpc.inprocess.InProcessServerBuilder;

public class ComputeServiceClientTest {
    
    private ComputeServiceClient client;
    private ComputeServiceBlockingStub mockBlockingStub;
	private ComputeServiceBlockingStub stub;
	private Server server;
	private String serverName;
    
	// start the in-process server
	public void start() throws IOException{
        serverName = InProcessServerBuilder.generateName();
        try {
			server = InProcessServerBuilder.forName(serverName)
					.addService(new ComputeServiceImpl())
					.build()
					.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    
    @BeforeEach
    public void setUp() {
    	try {
        	start();
		} catch (IOException e) {
			 e.printStackTrace();
		}  
        
        ManagedChannel channel = InProcessChannelBuilder.forName(serverName).build();

        // Initialize the client with the channel
        client = new ComputeServiceClient(channel);
        
        
    }
    
    @Test
    public void testSendDataIntegerInput() throws Exception {
        
        InputConfig testInt = new IntegerInputConfig(5);
        InputConfig testFile = new FileInputConfig("RepoTestFile.txt");
        
        // test making keys
        UUID key1 = client.sendData(testInt);
        UUID key2 = client.sendData(testFile);
        Assertions.assertNotEquals(key1, key2);
        
        // testing Retrieve Array
        char[] result = client.retrieveCharArr(key1);
        Assertions.assertEquals(5, result.length);
       
       
        // testing retrieve ArrayList
        ArrayList<char[]> testAl = client.retrieveCharAl(key2);
        Assertions.assertEquals(3, testAl.size());
        
        
    }
   
}