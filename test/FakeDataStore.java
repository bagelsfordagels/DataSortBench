import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;


public class FakeDataStore implements DataStorageSystem{
	public UUID sendData(int userData) {
		return null;
	}
	public ArrayList<Integer> recieveData(UUID key) {
		return null;
	}
	public boolean testDataStore() {
		ArrayList<Character> testOutput = new ArrayList<>();
		testOutput.add('a');
		testOutput.add('c');
		testOutput.add('g');
		testOutput.add('w');
		TestInputConfig inputConfig = new TestInputConfig(7);
		OutputConfigTest outputConfig = new OutputConfigTest(testOutput);
		DataStorageImplementation dataStore = new DataStorageImplementation();
		//tests if the input List are empty
		if(inputConfig.getUserData() != 7) {
			System.out.println("Input list is empty");
			Assertions.fail();
		}
		//tests if the output List is empty
		if(outputConfig.getOutputData().size() = 4) {
			System.out.println("Output List is Empty");
			Assertions.fail();
		}
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