import java.util.UUID;

public interface ComputeEngineStorageSystem {
	int sendData(UUID key);
	char[] retreiveSortedData(UUID key);
	
}
