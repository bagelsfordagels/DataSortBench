import static org.junit.jupiter.api.Assertions.fail;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestComputeEngineStorage{
	
	@Test
	public void test(){
		ComputeEngineStorageImplementation testCEImplementation = new ComputeEngineStorageImplementation();
		
		char[] arr = {'a','b'};
		
		if(testCEImplementation.sendData(1) != 1) {
			Assertions.fail();
		}
		
		if(testCEImplementation.retreiveSortedData(1).length != arr.length) {
			Assertions.fail();
		}
	}
	
}