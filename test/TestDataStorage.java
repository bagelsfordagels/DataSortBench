import static org.junit.jupiter.api.Assertions.fail;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestDataStorage{
	
	@Test
	public void test() {
		DataStorageImplementation testDSImplementation = new DataStorageImplementation();
		
		char[] testArr= {'q','w'};
		
		if (testDSImplementation.sendData(1).length != testArr.length) {
			Assertions.fail();
		}
		
		if(testDSImplementation.recieveData(0).length != testArr.length) {
			Assertions.fail();
		}
	}
}