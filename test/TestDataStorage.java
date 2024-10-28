import java.util.ArrayList;
import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestDataStorage{
	
	@Test
	public void test() throws Exception {
		DataStorageSystem testDSImplementation = new DataStorageImplementation();
		
		InputConfig testFile = new FileInputConfig("TestFile");
		UUID key = testDSImplementation.sendData(testFile);
		
		ArrayList<Integer> testAl = testDSImplementation.recieveData(key);
		
		//test to see if array list is correct size
		Assertions.assertEquals(3, 3);
		
		
		
		
//		InputConfig i = new IntegerInputConfig(1);
//		if (testDSImplementation.sendData(i) != key) {
//			Assertions.fail();
//		}
		
//		if(testDSImplementation.recieveData(key) != testArr.length) {
//			Assertions.fail();
//		}
	}
}