//import org.junit.Test;
//
//public class ComputeEngineIntegrationTest{
//
//	
//	ComputeEnginePrototype CEP = new ComputeEnginePrototype();
//	UserPrototype userTest = new UserPrototype();
//
//	@Test
//	public void test() {
//		
//	}
//	
//}
import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import io.grpc.ManagedChannel;

public class ComputeEngineIntegrationTest{

    @Test
    public void testComputeEngine() throws Exception {
//    	UserPrototype user = new UserPrototype();
//    	InputConfig userData =  new IntegerInputConfig(1);
//    	InputConfig userData1 =  new IntegerInputConfig(10);
//    	InputConfig userData2 =  new IntegerInputConfig(20);
//    	
//    	
//    	
//        ComputeEngineStorageSystem computeEngine = new ComputeEngineStorageImplementation();
//
//
//        // Trigger computation
//        UUID userKey = computeEngine.sendData(userData);
//        UUID userKey1 = computeEngine.sendData(userData1);
//        UUID userKey2 = computeEngine.sendData(userData2);
//
//        // Retrieve output data
//        char[] resultData = computeEngine.retrieveCharArr(userKey);
//        char[] resultData1 = computeEngine.retrieveCharArr(userKey1);
//        char[] resultData2 = computeEngine.retrieveCharArr(userKey2);
//        
//        
//        Assertions.assertEquals(resultData.length, 1);
//        Assertions.assertEquals(resultData1.length, 10);
//        Assertions.assertEquals(resultData2.length, 20);
//    	String target = "localhost:50051";  // Boilerplate TODO: make sure the server/port match the server/port you want to connect to
//
//        ManagedChannel channel = Grpc.newChannelBuilder(target, InsecureChannelCredentials.create())
//                .build();
//    	
//    	ComputeServiceClient csc = new ComputeServiceClient(channel);
//    	csc.order();
    	
    	
      
      

    }

}

