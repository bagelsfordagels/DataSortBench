import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DataStoreValidationTest{
	
	@Test
	public void validationTest() throws Exception {
		DataStorageSystem testDSImp = new DataStorageImplementation();
		boolean sendDataThrown = false;
		boolean receiveDataThrown = false;
		boolean mkFileThrown = false;
		//Tests validation in sendData
		try{
			testDSImp.sendData(null);
		}catch(Exception e) {
			sendDataThrown = true;
		}
		//Tests validation in receiveData
		try {
			testDSImp.recieveData(null);
		}catch(Exception e) {
			receiveDataThrown = true;
		}
		//Tests validation in MkFile
		try {
			testDSImp.mkFile(null);
		}catch(Exception e) {
			mkFileThrown = true;
		}
		Assertions.assertTrue(sendDataThrown);
		Assertions.assertTrue(receiveDataThrown);
		Assertions.assertTrue(mkFileThrown);
		
	}
}