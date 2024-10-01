import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class DataStorageImplementation implements DataStorageSystem{
//	private int userData;
//	private String fileName;
//	private char[] result;
////
//	
//
//	public DataStorageImplementation(int userInt) {
//		// TODO Auto-generated constructor stub
//		userData = userInt;
//	}
//	
//	public DataStorageImplementation(String fileName) {
//		this.fileName = fileName;
//	}
//
//	public void dataStorageImplementaion(int userData) {
//		this.userData = userData;
//		this.result = null; 
//	}
//	@Override
//	public char[] sendData(int key) {
//		// TODO Auto-generated method stub
//		char[] c = {'h'};
//		return c;
//	}
//
//	@Override
//	public char[] recieveData(int key) {
//		// TODO Auto-generated method stub
//		char[] c = {'h'};
//		return c;
//	}
	
	
	private Map<UUID, InputConfig> dataStore = new HashMap<>();

	public UUID sendData(InputConfig userData) {
        UUID key = UUID.randomUUID();
        dataStore.put(key, userData);
        return key;
    }

	public void recieveData(UUID key) {
        InputConfig storedData = dataStore.get(key);
        
    }

	@Override
	public int getUserData() {
		// TODO Auto-generated method stub
		return this.userData;
	}

}