import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ComputeEngineStorageImplementation implements ComputeEngineStorageSystem{
	int userData;
	char[] sortedData;
	
	private Map<UUID, InputConfig> dataStore = new HashMap<>();
	// puts user entered integer into map and links it to random key
	public UUID sendData(InputConfig userData) {
		UUID userKey = UUID.randomUUID();
		dataStore.put(userKey,userData);
		return userKey;
	}

	public char[] retreiveSortedData(UUID key) {
		// retrieves user entered integer from map
		// if user enters integer
		if(dataStore.get(key) instanceof IntegerInputConfig) {
			InputConfig userInt = dataStore.get(key);
			char[] arr = ComputeEngine.mkArr(userInt);
			return arr;
		}
		// if user enters file name
		if(dataStore.get(key) instanceof FileInputConfig) {
			InputConfig file = dataStore.get(key);
			DataStorageSystem dss = new DataStorageImplementation();
			dss.sendData(file);
			ComputeEngine.readFile(file);
			// just for compiling
			// not sure what it should be returning 
			char[] c = {'c','c','c'};
			return c;
			
		}
		
		

	}

}