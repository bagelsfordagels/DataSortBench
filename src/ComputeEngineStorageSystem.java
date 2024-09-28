import java.util.UUID;

public interface ComputeEngineStorageSystem {
	UUID sendData(int userData);
	char[] retreiveSortedData(UUID key);
	
}
