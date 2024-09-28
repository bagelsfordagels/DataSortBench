import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class DataStorageImplementation implements DataStorageSystem{
//	int userData;
//	char[] sortedData;
//
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

}