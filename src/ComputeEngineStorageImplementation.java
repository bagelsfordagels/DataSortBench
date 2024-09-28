import java.util.UUID;

public class ComputeEngineStorageImplementation implements ComputeEngineStorageSystem{
	int userData;
	char[] sortedData;
	
	@Override
	public UUID sendData(int userData) {
		// TODO Auto-generated method stub
		UUID userKey = UUID.randomUUID();
		return userKey;
	}
	@Override
	public char[] retreiveSortedData(UUID key) {
		// TODO Auto-generated method stub
		char[] arr = {'a','b','c'};
		return arr;
	}

}