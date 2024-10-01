import java.util.UUID;

public interface ComputeEngineStorageSystem {
	UUID sendData(InputConfig userData);
	char[] retreiveSortedData(UUID key);
	
}
