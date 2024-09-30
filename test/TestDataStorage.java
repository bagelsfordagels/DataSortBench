import static org.junit.jupiter.api.Assertions.fail;

import java.util.UUID;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestDataStorage{
	
	@Test
	public void test() {
		DataStorageImplementation testDSImplementation = new DataStorageImplementation(1);
		
		char[] testArr= {'q','w'};
		UUID key = UUID.randomUUID();
		
		if (testDSImplementation.sendData(1) != key) {
			Assertions.fail();
		}
		
		if(testDSImplementation.recieveData(key).length != testArr.length) {
			Assertions.fail();
		}
	}
}