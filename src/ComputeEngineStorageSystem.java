import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

public interface ComputeEngineStorageSystem {
	UUID sendData(InputConfig userData);
	char[] retreiveCharArr(UUID key);
	ArrayList<char[]> retreiveCharAl(UUID key) throws IOException;
	
}
