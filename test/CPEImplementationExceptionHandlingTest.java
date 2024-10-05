import java.util.ArrayList;
import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CPEImplementationExceptionHandlingTest{
	@Test
	public void RetreivecharrArrTest() throws Exception {
		
		ComputeEngineStorageSystem cssTest = new ComputeEngineStorageImplementation();
		UUID invalidKey = UUID.randomUUID(); // key that does not exist in dataStore
		
		try {
			cssTest.retreiveCharArr(invalidKey);
			Assertions.fail();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	@Test
	public void RetreiveCharAlTest() throws Exception{

		ComputeEngineStorageSystem cssTest = new ComputeEngineStorageImplementation();
		
		UUID invalidKey = UUID.randomUUID(); // key that does not exist in dataStore
		try {
			cssTest.retreiveCharAl(invalidKey);
			Assertions.fail();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	@Test
	public void UserFileTest() throws Exception{
		
		ComputeEngineStorageSystem cssTest = new ComputeEngineStorageImplementation();
		
		try {
			ArrayList<char[]> testCharAl = new ArrayList<>();
			cssTest.userFile(testCharAl);
			Assertions.fail();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}