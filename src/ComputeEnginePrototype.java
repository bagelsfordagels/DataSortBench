import java.util.UUID;

public class ComputeEnginePrototype implements ComputeEngineStorageSystem{
	public void prototype(ComputeEngineStorageSystem cess) {
		//send data to compute engine
		//test to compile
		char[] arr = {'a','b'};
		//key is associated with certain data compute engine needs
		UUID key =  cess.sendData(1);
		
		//receive data from compute engine
		//key is associated with sorted data
		cess.retreiveSortedData(key);
	}

	@Override
	public UUID sendData(int userData) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public char[] retreiveSortedData(UUID key) {
		// TODO Auto-generated method stub
		return null;
	}

 
}