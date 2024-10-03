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
import java.io.IOException;
import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ComputeEngineIntegrationTest implements InputConfig, OutputConfig{

    @Test
    public void testComputeEngine() throws IOException {
    	UserPrototype user = new UserPrototype();
    	InputConfig userData =  new IntegerInputConfig(1);
    	InputConfig userData1 =  new IntegerInputConfig(10);
    	InputConfig userData2 =  new IntegerInputConfig(20);
    	
    	UUID key = user.sendData(userData);
    	UUID key1 = user.sendData(userData1);
    	UUID key2 = user.sendData(userData2);
    	
        ComputeEngineStorageImplementation computeEngine = new ComputeEngineStorageImplementation();


        // Trigger computation
        UUID userKey = computeEngine.sendData(userData);
        UUID userKey1 = computeEngine.sendData(userData1);
        UUID userKey2 = computeEngine.sendData(userData2);

        // Retrieve output data
        char[] resultData = computeEngine.retreiveCharArr(userKey);
        char[] resultData1 = computeEngine.retreiveCharArr(userKey1);
        char[] resultData2 = computeEngine.retreiveCharArr(userKey2);
        
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

	@Override
	public int getUserData() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getUserFileData() {
		// TODO Auto-generated method stub
		return null;
	}
}

