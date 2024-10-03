import java.io.IOException;
import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestComputeEngineStorage{
	
	@Test
	public void test() throws IOException{
		ComputeEngineStorageImplementation testCEImplementation = new ComputeEngineStorageImplementation();
		
		char[] arr = {'a','b'};
		UUID key = UUID.randomUUID();
		InputConfig i = new IntegerInputConfig(1);
		if (testCEImplementation.sendData(i) != key) {
			Assertions.fail();
		}
		
		
		if(testCEImplementation.retreiveCharArr(key).length != arr.length) {
			Assertions.fail();
		}
	}
	
}