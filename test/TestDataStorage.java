import static org.junit.jupiter.api.Assertions.fail;

import java.util.UUID;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestDataStorage{
	
	@Test
	public void test() {
		DataStorageImplementation testDSImplementation = new DataStorageImplementation();
		
		char[] testArr= {'q','w'};
		UUID key = UUID.randomUUID();
		InputConfig i = new IntegerInputConfig(1);
		if (testDSImplementation.sendData(i) != key) {
			Assertions.fail();
		}
		
//		if(testDSImplementation.recieveData(key) != testArr.length) {
//			Assertions.fail();
//		}
	}
}