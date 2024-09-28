import static org.junit.jupiter.api.Assertions.fail;

import java.util.UUID;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestComputeEngineStorage{
	
	@Test
	public void test(){
		ComputeEngineStorageImplementation testCEImplementation = new ComputeEngineStorageImplementation();
		
		char[] arr = {'a','b'};
		UUID key = UUID.randomUUID();
		
		if (testCEImplementation.sendData(1) != key) {
			Assertions.fail();
		}
		
		
		if(testCEImplementation.retreiveSortedData(key).length != arr.length) {
			Assertions.fail();
		}
	}
	
}