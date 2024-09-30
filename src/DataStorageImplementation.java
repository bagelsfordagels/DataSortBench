import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class DataStorageImplementation implements DataStorageSystem, InputConfig{
	private int userData;
	private char[] result;
//
	

	public DataStorageImplementation(int userInt) {
		// TODO Auto-generated constructor stub
		userData = userInt;
	}

	public void dataStorageImplementaion(int userData) {
		this.userData = userData;
		this.result = null; 
	}
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
	
	
	private Map<UUID, Integer> dataStore = new HashMap<>();

	public UUID sendData(int userData) {
        UUID key = UUID.randomUUID();
        dataStore.put(key, userData);
        return key;
    }

	public char[] recieveData(UUID key) {
        Integer storedData = dataStore.get(key);
        char[] result = new char[storedData];
        for (int i = 0; i < storedData; i++) {
            result[i] = (char) (storedData + '0'); 
        }
        return result;
    }

	@Override
	public int getUserData() {
		// TODO Auto-generated method stub
		return this.userData;
	}
	
	public String getUserFileData() {
		return null;
	}

}