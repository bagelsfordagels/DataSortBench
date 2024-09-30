import java.util.UUID;

public class FakeDataStore implements DataStorageSystem{
	public UUID sendData(int userData) {
		return null;
	}
	public char[] recieveData(UUID key) {
		return null;
	}
	public boolean testDataStore() {
		TestInputConfig inputConfig = new TestInputConfig();
		OutputConfigTest outputConfig = new OutputConfigTest();
		int incount = 0;
		int outcount = 0;
		//tests if the input List are empty
		if(inputConfig.getInputData().size() == 0) {
			System.out.println("Input list is empty");
			return false;
		}
		//tests if the output List is empty
		if(outputConfig.getOutputData().size() == 0) {
			System.out.println("Output List is Empty");
			return false;
		}
		//runs through the input list to make sure it can be read
		for(int i=0;i<inputConfig.getInputData().size();i++) {
			incount++;
		}
		if(inputConfig.getInputData().size() == incount) {
			return true;
		}
		//runs through the output list to make sure that it can be read
		for(int i=0;i<outputConfig.getOutputData().size();i++) {
			outcount++;
		}
		if(outputConfig.getOutputData().size() == outcount) {
			return true;
		}
		return false;
	}
}