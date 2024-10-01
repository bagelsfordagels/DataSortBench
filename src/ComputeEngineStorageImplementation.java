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
		InputConfig userInt = dataStore.get(key);
//		ComputeEngine ce = new ComputeEngine(userInt);
//		ComputeEnginePrototype cep = new ComputeEnginePrototype();
//		cep.se
		char[] arr = ComputeEngine.mkArr(userInt);
		return arr;
		

	}

}