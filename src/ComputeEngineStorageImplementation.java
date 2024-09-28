import java.util.UUID;

public class ComputeEngineStorageImplementation implements ComputeEngineStorageSystem{
	int userData;
	char[] sortedData;
	
	@Override
	public int sendData(UUID key) {
		// TODO Auto-generated method stub
		return 1;
	}
	@Override
	public char[] retreiveSortedData(UUID key) {
		// TODO Auto-generated method stub
		char[] arr = {'a','b','c'};
		return arr;
	}

}