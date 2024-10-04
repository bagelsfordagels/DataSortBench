import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class FakeDataStore implements DataStorageSystem{
	public UUID sendData(int userData) {
		return null;
	}
	public ArrayList<Integer> recieveData(UUID key) {
		return null;
	}
	@Test
	public void testDataStore() {
		ArrayList<Character> testOutput = new ArrayList<>();
		testOutput.add('a');
		testOutput.add('c');
		testOutput.add('g');
		testOutput.add('w');
		TestInputConfig inputConfig = new TestInputConfig(7);
		OutputConfigTest outputConfig = new OutputConfigTest(testOutput);
		Assertions.assertEquals(inputConfig.getUserData(), 7);
		Assertions.assertEquals(outputConfig.getOutputData().size(), 4);
	}
	@Override
	public UUID sendData(InputConfig userdata) {
		// TODO Auto-generated method stub
		return null;
		
	}
	@Override
	public File mkFile(ArrayList<char[]> charAl) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}
}