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

public class ComputeEngineIntegrationTest implements InputConfig, OutputConfig{

    @Test
    public void testComputeEngine() {
    	UserPrototype user = new UserPrototype();
    	int userData =  1;
    	int userData1 = 10;
    	int userData2 = 25;
    	UUID key = user.sendData(userData);
    	UUID key1 = user.sendData(userData1);
    	UUID key2 = user.sendData(userData2);
    	
        ComputeEngineStorageImplementation computeEngine = new ComputeEngineStorageImplementation();


        // Trigger computation
        computeEngine.sendData(key);
        computeEngine.sendData(key1);
        computeEngine.sendData(key2);

        // Retrieve output data
        char[] resultData = computeEngine.retreiveSortedData(key);
        char[] resultData1 = computeEngine.retreiveSortedData(key1);
        char[] resultData2 = computeEngine.retreiveSortedData(key2);
        
        char[] correctArr = {'h','g','l'};
        if(resultData != correctArr) {
        	Assertions.fail();
        }
        if(resultData1 != correctArr) {
        	Assertions.fail();
        }
        if(resultData2 != correctArr) {
        	Assertions.fail();
        }

    }
}

