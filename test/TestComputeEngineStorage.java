import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestComputeEngineStorage{
	
	@Test
	public void test() throws Exception{
		ComputeEngineStorageSystem testCEImplementation = new ComputeEngineStorageImplementation();
		

		InputConfig i = new IntegerInputConfig(4);
		UUID key = testCEImplementation.sendData(i);
		char[] testArr = testCEImplementation.retrieveCharArr(key);
		
		// check if testArr length is correct
		Assertions.assertEquals(testArr.length, 4);
		

	}
	
}